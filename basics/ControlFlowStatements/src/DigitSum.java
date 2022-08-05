public class DigitSum {
    public static void main(String[] args) {
        System.out.println("Sum of digits is number 1254 " + sumDigits(1254));
    }
    public static int sumDigits (int number) {
        if(number<10) return -1;

        int sum = 0;

        while(number > 0) {
            int digit = number % 10;
            sum+= digit;
            number /= 10;
        }
        return sum;
    }
}
