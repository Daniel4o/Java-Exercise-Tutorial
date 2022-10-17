public class Main {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover));
        System.out.println(rover.equals(rover2));
        // Output:
        // true
        // false

        // Labrador is an instance of dog but dog isn't instance of labrador
        // The best way to fix this is to not Override the equals method in labrador
        // To make sure that equals method cannot be Overridden we use the final keyword
    }
}

