package code;
import java.util.Scanner;

public class IntInputReader {

    static Scanner intro = new Scanner(System.in);
    private static int top,bot;
    
    /**
     * input Method receives the Bot and Top int parameters for the input limits and
     * returns the input from err method.
     * 
     * @param Bot int of the bottom limit of the required input.
     * @param Top int of the top limit of the required input.
     * 
     * @return int from @param Bot to @param Top.
     */
    public static int input(int Bot,int Top){
        top=Top;
        bot=Bot;
        return err(intro.next());
    }
    
    /**
     * err Method tries to parse the input String to int and returns the
     * validated int from validInt method.
     * 
     * @param input String to parse to int.
     * 
     * @return in int parsed from input String.
     */
    public static int err(String input){
        int in=0;
        try {
            in=validInt(Integer.parseInt(input));
        } catch (Exception ex) {
            System.out.println("Favor ingresar Dígitos y no carácteres");
            in=err(intro.next());
        }
        return in; 
    }
    
    /**
     * validInt Method receives the in parameter and checks if its between the
     * Bot and Top ints. Returns the same in if it is, or asks for a new int if it isn't
     * 
     * @param in int to check.
     * 
     * @return in already checked.
     */
    public static int validInt(int in){
        if (in<bot || in >top) {
            System.out.println("Favor ingresar un número entre "+bot+" y "+top);
            in=input(bot,top);
        }
        return in;
    }
}