public class FlourPacker {

    public static boolean canPack(int bigCount, int smallCount, int goal) {
        if(bigCount<0 || smallCount<0 || goal <0) return false;
        int big = bigCount * 5;
        int sum = big + smallCount - goal;
        if(sum == 0) return true;
        if(sum>4 && bigCount >0) return true;
        if(sum>0 && smallCount>0 && goal>big) return true;
        if(sum >0 && goal>big) return true;
        return false;
    }
}
