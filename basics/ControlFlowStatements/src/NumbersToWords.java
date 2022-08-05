public class NumbersToWords {
    public static void main(String[] args) {
        int a = 10;
        String str = Integer.toString(a);
        System.out.println(str.length()-1);
    }

        public static void numberToWords(int num) {
            if (num < 0) System.out.println("Invalid Value");
            if (num ==0) System.out.println("Zero");
            else {
                int reversed = reverse(num);
                int numDig = getDigitCount(num);
                        for(int i =0; i<numDig;i++) {
                    int lastDigit = reversed % 10;
                    switch (lastDigit) {
                        case 0:
                            System.out.println("Zero");
                            break;
                        case 1:
                            System.out.println("One");
                            break;
                        case 2:
                            System.out.println("Two");
                            break;
                        case 3:
                            System.out.println("Three");
                            break;
                        case 4:
                            System.out.println("Four");
                            break;
                        case 5:
                            System.out.println("Five");
                            break;
                        case 6:
                            System.out.println("Six");
                            break;
                        case 7:
                            System.out.println("Seven");
                            break;
                        case 8:
                            System.out.println("Eight");
                            break;
                        case 9:
                            System.out.println("Nine");
                            break;
                    }
                    reversed /=10;
                }
            }
        }

        public static int reverse(int num) {
            int duplicate = num;
            num = Math.abs(num);
            int reversed = 0;
            while(num>0) {
                reversed = reversed * 10 + num %10;
                num /=10;
            }
            if(duplicate<0) return reversed *-1;
            return reversed;
        }

        public static int getDigitCount(int num) {
            if(num <0) return -1;
            if(num == 0) return 1;
            int sumDigits =0;
            while(num >0) {
                sumDigits++;
                num /=10;
            }
            return sumDigits;
        }
    }

