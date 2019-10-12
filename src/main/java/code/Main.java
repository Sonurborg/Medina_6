package code;

public class Main {
    
    /**
     * main Method is the main of the program, loads the books from
     * the .json file through BookManager.loadBooks and starts the 
     * menu.
     * 
     * @param Args 
     */
    public static void main(String[]Args){
        BookManager.loadBooks();
        Menu.run();
    }
}
