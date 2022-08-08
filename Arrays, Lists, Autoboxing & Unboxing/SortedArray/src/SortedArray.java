import java.util.Scanner;

public class SortedArray {

    private static Scanner scanner = new Scanner(System.in);

    public static int[] getIntegers(int number) {
        int[] values = new int[number];
        System.out.println("Enter " + values.length + " integer values. \r");

        for (int i =0; i<values.length; i++) {
          values[i] = scanner.nextInt();
        }
      return values;
    }

    public static int[] sortIntegers(int[] array) {
        int temp =0;

        for(int i=0; i<array.length; i++) {
            for(int j = i+1; j<array.length; j++) {
                if(array[i] < array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    return array;
    }

    public static void printArray(int[] array) {
        for(int i =0; i<array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }

}
