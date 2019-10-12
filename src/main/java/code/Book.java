package code;

import java.util.Scanner;
import org.json.simple.JSONObject;

public class Book {
    
    private static Scanner intro=new Scanner(System.in);
    private int id;
    private String name;
    private String author;
    
    
    /**
     * Book object
     * 
     * @param id int ID of the Book on store.
     * @param name String with the name of the book.
     * @param author String with the name of the author of the book.
     */
    public Book(int id,String name,String author){
        this.id=id;
        this.name=name;
        this.author=author;
    }
    
    /**
     * Empty Book object, it will run the newBook to create the attributes for the book.
     */
    public Book(){
        newBook();
    }
    
    /**
     * toJson Method creates a JSONObject with the attributes of the current book.
     * 
     * @return JSONObject with the data of the current book.
     */
    public JSONObject toJson(){
        JSONObject book = new JSONObject();
        book.put("id", (""+this.id));
        book.put("name", this.name);
        book.put("author", this.author);
        return book;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }  
    
    /**
     * showBook Method prints on screen the attributes of the curren book.
     */
    public void showBook(){
        System.out.println("Nombre: "+this.name+", Autor: "+this.author+", ID: "+this.id);
    }

    /**
     * newBook Method sets the attributes for the book.
     */
    private void newBook(){
        this.id=BookManager.books.size();
        setName(askName());
        setAuthor(askAuthor());
    }
    
    /**
     * askName Method asks the user to input the name of the book on the console
     * and returns it.
     * 
     * @return String with the name of the book put by the user.
     */
    private String askName(){
        System.out.println("Ingrese el Nombre del libro a ingresar");
        return intro.next()+intro.nextLine();
    }
    
    /**
     * askName Method asks the user to input the name of the author of the book 
     * on the console and returns it.
     * 
     * @return String with the name of the author of the book put by the user.
     */
    private String askAuthor(){
        System.out.println("Ingrese el Nombre del autor del libro a ingresar");
        return intro.next()+intro.nextLine();
    }
}
