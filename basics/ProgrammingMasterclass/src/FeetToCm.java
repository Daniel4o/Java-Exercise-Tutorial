
public class FeetToCm {
    public static void main(String[] args) {
      double centimeters = calcFeetAndInchesToCentimeters(6,10 );
        if(centimeters <0.0) {
            System.out.println("Invalid cm");
        }

        calcFeetAndInchesToCentimeters(100);
    }
        public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if(feet < 0 || inches < 0 || inches >12)  return -1;
        double centimeters =2.54 * feet * 12 + (2.54* inches);
        System.out.println(feet + " feet " + inches + " inches = " + centimeters + " cm");
        return  centimeters;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if(inches < 0) return -1;
        double feet = (int) inches/12;
        double remainingInches = (int) inches % 12;
        System.out.println(inches + " inches is equal to " + feet + " feet and " + remainingInches);
        return calcFeetAndInchesToCentimeters(feet,remainingInches );
    }
}
