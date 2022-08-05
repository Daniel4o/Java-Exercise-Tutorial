public class LargestPrime {
    public static void main(String[] args) {
        System.out.println(15%5);
    }

    public static int getLargestPrime(int num) {
        if(num < 2) return -1;
        int prime = -1;
        for(int i =1; i<=num;i++) {
            if(num%i == 0 && (num <10 || num != i)) {
                if (i == 2 || i == 3 || i == 5 || i == 7) prime = i;
                else if (i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0)
                    prime = i;
            }
        }
        if(prime == 1) return num;
        return prime;
    }
}
