package code;

public class Menu {
    
    /**
     * run Method runs the optionSel method while the selection input is different
     * to 4.
     */
    public static void run(){
        int selection;
        do {
           selection=optionSel();
           options(selection);
        }while (selection!=4);
    } 
    
    /**
     * optionSel Method prints the menu options and
     * returns the input received from IntInputReader.
     * 
     * @return int from 1 to 4.
     */
    private static int optionSel() {
        System.out.println("Seleccione lo que desea realizar");
        System.out.println(" 1 - Agregar nuevo Libro");
        System.out.println(" 2 - Mostrar los Libros");
        System.out.println(" 3 - Vender un Libro");
        System.out.println(" 4 - Salir");
        return IntInputReader.input(1, 4);
    }
    
    /**
     * options Method recevies the int parameter o and runs a method
     * according to the int.
     * 
     * @param o int of the selection to choose:
     *      1 - Runs addBook to add a new book to the books ArrayList.
     *      2 - Runs showBooks to print on screen the attributes of all books on the ArrayList.
     *      3 - Runs sellBook to sell a book from the ArrayList.
     */
    private static void options(int o){
        if (o==1) BookManager.addBook();
        if (o==2) BookManager.showBooks();
        if (o==3) BookManager.sellBook();
    }
}
