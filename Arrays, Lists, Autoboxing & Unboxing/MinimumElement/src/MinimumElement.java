import java.util.Scanner;

public class MinimumElement {


    private static int readInteger() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static int[] readElements(int num) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[num];
        for(int i=0; i<arr.length; i++)
            arr[i] = scanner.nextInt();
        return arr;
    }

    private static int findMin(int[] arr) {
       int min = arr[0];
       for(int i=1; i<arr.length; i++) {
           if(min> arr[i])
               min = arr[i];
       }
       return min;
    }
}
