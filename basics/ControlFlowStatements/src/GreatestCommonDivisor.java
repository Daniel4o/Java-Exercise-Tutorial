public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(32%16);
    }
    public static int getGreatestCommonDivisor(int first, int second) {
       int sum =0;
        if (first < 10 || second < 10) return -1;

        if (first > second) {
            for (int i = 1; i <= first; i++) {
                if (second % i == 0 && first % i == 0) sum = i;
            }
            return sum;
        } else if(second >first){
            for (int j = 1; j <= first; j++) {
                if (first % j == 0 && second % j == 0) sum = j;
            }
            return sum;
        }
        return -1;
    }
}
