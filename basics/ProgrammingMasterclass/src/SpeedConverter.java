public class SpeedConverter {

    public static long toMilesPerHour(double kmPerHour) {
        if (kmPerHour < 0) {
            return -1;
        }
            long milesPerHour = Math.round(kmPerHour / 1.609);
            return milesPerHour;
    }

    public static void printConversion(double kmPerHour) {
        if (kmPerHour < 0) {
            System.out.println("Invalid value");
        }
        else {
            long milesPerHour = Math.round(kmPerHour / 1.609);
            System.out.println(kmPerHour + " km/h = " + milesPerHour + " mi/h");
        }
    }
}

