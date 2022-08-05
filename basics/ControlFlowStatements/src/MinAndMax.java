import java.util.Scanner;

public class MinAndMax {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       long min = Long.MAX_VALUE;
       long max = Long.MIN_VALUE;
        while(true) {
            System.out.println("Enter number:");
            boolean hasNextInt = scanner.hasNextInt();
            if(hasNextInt) {
                int num = scanner.nextInt();
                if(num<min) min = num;
                if(num>max) max = num;
            }
            else break;
            scanner.nextLine();
        }
        System.out.println("Min and max num's are: "+ min + " and " + max);
    }
}
