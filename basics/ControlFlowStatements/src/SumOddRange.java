public class SumOddRange {

    public static boolean isOdd(int num) {
        if(num < 0) return false;
        if(num % 2 != 0) return true;
        return false;
    }

    public static int sumOdd(int start, int end) {
        if(start>end || start < 1 || end < 1 ) return -1;
       int sum=0;
        for(int i =start; i<= end; i++) {
            if(isOdd(i)) sum+=i;
        }
        return sum;
    }
}
