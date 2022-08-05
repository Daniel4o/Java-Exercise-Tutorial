import java.util.Scanner;

public class InputCalculator {

    public static void inputThenPrintSumAndAverage() {
        Scanner scanner = new Scanner(System.in);
        int sum =0;
        int count = 0;
        double average = 0;
        while(true) {
            boolean hasNextInt = scanner.hasNextInt();
            if(hasNextInt) {
                int num = scanner.nextInt();
                sum+= num;
                count++;
            }
            else {
                average = (double)sum/count;
                average = Math.ceil(average);
                System.out.println("SUM = " + sum + " AVG = " + (long)(average));
                break;
            }
            scanner.nextLine();
        }
        scanner.close();
    }
}
