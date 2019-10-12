package code;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    
    public static List<Book> books = new ArrayList<>();
    
    /**
     * loadBooks Method executes JsonReader.read method to load the
     * Book objects of the .json file and save them on the books
     * ArrayList.
     */
    public static void loadBooks(){
        JsonReader.read();
    }
    
    /**
     * addBook Method adds a Book object to the books ArrayList
     * and runs JsonReader.putBook to put it into the .json 
     * file with the other books.
     */
    public static void addBook(){
        books.add(new Book());
        JsonReader.putBook(books.get(books.size()-1));
    }
    
    /**
     * showBooks Method goes through the books ArrayList and
     * runs the showBook method in each one of the objects to
     * print their attributes on console.
     */
    public static void showBooks(){
        for (int i=0;i<books.size();i++){
            books.get(i).showBook();
        }
    }
    
    /**
     * sellBook Method shows the books through the showBooks method
     * and removes the book object in the possition obtained from
     * askBook.
     */
    public static void sellBook(){
        showBooks();
        removeBook(askBook());
    }
    
    /**
     * askBook Method asks the user to imput a number according to the
     * book object id on the ArrayList and returns it.
     * 
     * @return int containing the ID of the book to remove.
     */
    private static int askBook(){
        System.out.println("Ingrese el \"ID\" del Libro a Vender");
        return IntInputReader.input(0,(books.size()));
    }
    
    /**
     * removeBook method removes the book in the bk possition of the books ArrayList
     * from the .json file running JsonReader.takeBook, and from the ArrayList itself.
     * 
     * @param bk int corresponding to the book to erase.
     */
    private static void removeBook(int bk){
        JsonReader.takeBook(books.get(bk));
        books.remove(bk);
    }
}
