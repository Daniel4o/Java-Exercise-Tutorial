import java.util.Scanner;

public class ReadingUserInputNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 1;
        int sum = 0;
        while(counter < 11) {
            System.out.println("Enter number " + counter + ":");
            boolean hasNextInt = scanner.hasNextInt();
            if(hasNextInt) {
                int numOne = scanner.nextInt();
                sum += numOne;
                counter++;
            }
            else System.out.println("Invalid Number");
            scanner.nextLine();
        }
        System.out.println("The sum is " + sum);
        scanner.close();
    }
}
