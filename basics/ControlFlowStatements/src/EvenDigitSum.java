public class EvenDigitSum {
    public static int getEvenDigitSum(int num) {
        if(num < 0) return -1;
        int digit =0;
        int sum =0;

       while(num>10) {
        digit = num % 10;
        if(digit % 2== 0) sum +=digit;
        num /=10;
       }
       if(num % 2 == 0) return sum + num;
        return sum;
    }
}