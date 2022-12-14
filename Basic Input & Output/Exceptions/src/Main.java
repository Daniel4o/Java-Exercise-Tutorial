import java.util.InputMismatchException;
import java.util.Scanner;

// Exception is an event which occurs during the execution of a program
// that disrupts the normal flow of the program's instructions.

public class Main {
    public static void main(String[] args) {
//        int x = 98;
//        int y = 0;
//        System.out.println(divideLBYL(x,y));
//        System.out.println(divideEAFP(x,y));
//        System.out.println(divide(x,y));

//        int x = getInt();
//        int x = getIntLBYL();
        int x = getIntEAFP();
        System.out.println("x is " + x);
    }

    private static int getInt() {
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    private static int getIntLBYL() {
        Scanner s = new Scanner(System.in);
        boolean isValid = true;
        System.out.println("Please enter an integer ");
        String input = s.next();
        for(int i=0; i<input.length(); i++) {
            // Testing if each inout character in the string is a number
            // If it's false break out of the loop
            if(!Character.isDigit(input.charAt((i)))) {
                isValid = false;
                break;
            }
        }
        // If all input are digits, parseInt is being passed
        if(isValid) return Integer.parseInt(input);
        // If it's not valid
        return 0;
    }

    private static int getIntEAFP() {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter an integer");
        try {
            return s.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    // Look Before You Leap
    private static int divideLBYL(int x, int y) {
        if(y != 0) return x/y;
        else return 0;
    }

    // Easy to Ask for Forgiveness than Permission
    private static int divideEAFP(int x, int y) {
        try {
            return x/y;
        } catch(ArithmeticException e) {
            return 0;
        }
    }

    // For invalid integers without checking the program will crash
    private static int divide(int x, int y) {
        return x/y;
    }
}
