
public class ByteShortIntLong {

    public static void main(String[] args) {
        byte bait = 10;
        short kus = 25;
        int fint = 50;
        long dulug = 50000 + 10 * (bait + kus + fint);
        System.out.println(dulug);

        short shortTotal = (short)(1000+10*(bait+kus+fint));
        System.out.println(shortTotal);

        float myFloatVal = 5/3;
        double myDoubleVal = 5f/3f;
        System.out.println(myDoubleVal);
    }
}
