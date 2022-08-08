import java.util.Arrays;

public class ReverseArray {

    private static void reverse(int[] array){
        System.out.println("Array = "+ Arrays.toString(array));
        if (array.length%2==0){
            int n = array.length/2;
            for (int i = 0; i < n; i++) {
                int temp = 0;
                temp =array[i];
                array[i] = array[array.length-1-i];
                array[array.length-1-i] = temp;
            }
            System.out.println("Reversed Array = "+ Arrays.toString(array));

        }
        else{
            int n = (array.length-1)/2;
            for (int i = 0; i <n; i++) {
                int temp = 0;
                temp =array[i];
                array[i] = array[array.length-1-i];
                array[array.length-1-i] = temp;
            }
            System.out.println("Reversed Array = "+ Arrays.toString(array));
        }
    }
}
