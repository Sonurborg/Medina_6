package code;
 
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {
    
    private static JSONParser jsonParser = new JSONParser();
    
    @SuppressWarnings("unchecked")
    /**
     * read Method tries to read "libreria.json" file to a JSONArray and
     * runs parseBookObject for every object on the JSONArray.
     */
    public static void read(){
        try {
            JSONArray bookList = objectToArray(fileReader("libreria.json"));
            bookList.forEach( bk -> parseBookObject( (JSONObject) bk ) );
        } catch (Exception e) {
            System.out.println("Error, no fue posible leer el archivo");
        }
    }
    
    /**
     * fileReader Method receives a path and returns a JSONObject
     * obtained from reading the file on the path.
     * 
     * @param path Path of the .json file to read.
     * 
     * @return JSONObject obtained from the path.
     * 
     * @throws Exception 
     */
    private static JSONObject fileReader(String path) throws Exception{
        return (JSONObject) jsonParser.parse(new String(Files.readAllBytes(Paths.get(path))));
    }
 
    /**
     * objectToArray Method receives a JSONObject and transforms it to JSONArray.
     * 
     * @param JSONObject to transform.
     * 
     * @return JSONArray transformed from the JSONObject.
     */
    private static JSONArray objectToArray(JSONObject obj){
        return (JSONArray) obj.get("books");
    }
    
    /**
     * parseBookObject Method receives a JSONObject and instances it to a Book
     * object in the books ArrayList.
     * 
     * @param book JSONObject to instance as a Book Object.
     */
    private static void parseBookObject(JSONObject book){
        BookManager.books.add(new Book(Integer.parseInt((String) book.get("id")),(String) book.get("name"),(String) book.get("author")));
    }
    
    /**
     * putBook Method receives a Book object and tries to overwrite its attributes in the
     * "libreria.json" file.
     * 
     * @param book Book object to put on the file.
     */
    public static void putBook(Book book){
        try {
            jsonWriter(addObject(objectToArray(fileReader("libreria.json")),book));
        } catch (Exception e) {
            System.out.println("Error, no fue posible sobreescribir el archivo");
        }
    }
    
    /**
     * takeBook Method receives a Book object and tries to erase it from the "libreria.json"
     * file.
     * 
     * @param book Book object to remove from the file.
     */
    public static void takeBook(Book book){
        try {
            jsonWriter(removeObject(objectToArray(fileReader("libreria.json")),book));
        } catch (Exception e) {
            System.out.println("Error, no fue posible sobreescribir el archivo");
        }
    }
    
    /**
     * addObject Method receives a JSONArray and a Book object to return a JSONObject with
     * the existent data plus the attributes of the Book object.
     * 
     * @param bookList JSONArray containing the books JSONObject.
     * @param book Book object to put on the JSONArray.
     * 
     * @return JSONObject with the data of bookList and book.
     */
    private static JSONObject addObject(JSONArray bookList,Book book){
        bookList.add(book.toJson());    
        JSONObject bookObject = new JSONObject();
        bookObject.put("books", bookList);
        return bookObject;
    }
    
    /**
     * removeObject Method receives a JSONArray and a Book object to return a JSONObject with
     * the existent data minus the attributes of the Book object.
     * 
     * @param bookList JSONArray containing the books JSONObject.
     * @param book Book object to remove from the JSONArray.
     * 
     * @return  JSONObject with the data of bookList minus the data of book.
     */
    private static JSONObject removeObject(JSONArray bookList,Book book){
        bookList.remove(book.toJson());    
        JSONObject bookObject = new JSONObject();
        bookObject.put("books", bookList);
        return bookObject;
    }
    
    /**
     * jsonWriter Method receives a JSONObject and overwrites it on the "libreria.json" file
     * 
     * @param snickersList JSONObject with all the books to overwrite.
     * 
     * @throws Exception 
     */
    private static void jsonWriter(JSONObject bookList) throws Exception{
        FileWriter file = new FileWriter("libreria.json");
        file.write(bookList.toJSONString());
        file.flush();
    }
}