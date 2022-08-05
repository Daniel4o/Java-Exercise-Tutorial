public class MinutesToYearsDaysCalculator {

    public static void printYearsAndDays(long min) {
        if(min<0) System.out.println("Invalid Value");
        else {
            long hours = min / 60;
            long days = 0;
            long years = 0;
            if (hours / 24 > 0) days = hours / 24;
            if (days / 365 > 0) {
                years = days / 365;
                days %=365;
            }
            System.out.println(min + " min = " + years + " y and " + days + " d");
        }
    }
}
