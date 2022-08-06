public class Dog extends Animal {

    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

    public Dog(String name, int size, int weight, int eyes,
    int legs, int tail, int teeth, String coat) {

        // super: calls the constructor that is for the class
        // that we're extending from (superclass is Animal)
        super(name, 1, 1, size, weight);
        this.eyes =eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth =teeth;
        this.teeth = teeth;
    }

    private void chew() {
        System.out.println("Dog.chew() called");
    }

    @Override
    // Overriding
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
        super.eat();
    }

    public void walk() {
        System.out.println("Dog.walk() called");
        // super calls the method from parent Animal not Dog!
        super.move(5);
    }

    public void run() {
        System.out.println("Dog.run() called");
        // calls move method. If there is not any provided it calls the
        // method from the parent i.e. Animal (i.e. move becomes super.move)
        move(10);
    }

    private void moveLegs(int speed) {
        System.out.println("Dog.moveLegs() called");

    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called");
        moveLegs(speed);
        super.move(speed);
    }
}

