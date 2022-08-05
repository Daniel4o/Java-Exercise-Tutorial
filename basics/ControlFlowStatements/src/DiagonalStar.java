public class DiagonalStar {

    public static void printSquareStar(int num) {
        if(num<5) System.out.println("Invalid Value");
        else
        for(int i =0; i< num;i++) {
            for(int j=0;j< num;j++) {
                if(i==0 || j==0 || i==j || i== num -1
                        || j == num-1 || i+j == num-1)
                    System.out.println("*");
                else System.out.println(" ");
            }
            System.out.println();
        }
    }
}
