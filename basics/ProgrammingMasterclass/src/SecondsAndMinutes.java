public class SecondsAndMinutes {
    public static void main(String[] args) {
        System.out.println(getDurationString(65,45));
        System.out.println(getDurationString(3945L));
    }
    public static String getDurationString(long minutes, long seconds) {
        if (minutes < 0 || seconds < 0 || seconds > 59 ) {
            return "Invalid value!";
        }
        long hours = minutes/60;
        long remainingMinutes = minutes % 60;
        if(hours < 10 && remainingMinutes<10)
        return "0"+minutes/60+"h "+"0"+minutes%60 + "m "+ seconds +"s";
        else if(hours <10 )
            return "0"+minutes/60+"h "+minutes%60 + "m "+ seconds +"s";
        else if(remainingMinutes <10)
            return minutes/60+"h "+"0"+minutes%60 + "m "+ seconds +"s";
            else
        return minutes/60+"h "+minutes%60 + "m "+ seconds +"s";

    }

    public static String getDurationString(long seconds) {
        if(seconds <0) return "Invalid value";
        long minutes = seconds / 60;
        long remainingSeconds = seconds % 60;
        return getDurationString(minutes,remainingSeconds);
    }
}
