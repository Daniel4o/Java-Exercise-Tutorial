public class FirstAndLastDigit {
    public static void main(String[] args) {
        System.out.println(257%10);
        System.out.println(sumFirstAndLastDigit(257));
    }

    public static int sumFirstAndLastDigit(int num) {
        if(num < 0) return -1;
        if(num <10) return num + num;
        if(num <100) return num/10 + num%10;
        int startNum = num %10;
        while(num >=10) {
            num /=10;
        }
        return startNum + num;
    }
}
