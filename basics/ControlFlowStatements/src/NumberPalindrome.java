public class NumberPalindrome {

    public static boolean isPalindrome(int num) {
        int reverse = 0;
        num = Math.abs(num);
        int i = num;
        while(num> 0) {
            int remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num /= 10;
        }
        if(reverse == i) return true;
        return false;
    }
}
