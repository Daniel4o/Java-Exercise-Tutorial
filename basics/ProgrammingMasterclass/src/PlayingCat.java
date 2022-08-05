public class PlayingCat {

    public static boolean isCatPlaying(boolean summer, int temp) {
        if(summer) {
            if(temp>= 25 && temp <= 45 ) return true;
                return false;
        }
        if(temp>= 25 && temp <= 35 ) return true;
        return false;
    }
}
