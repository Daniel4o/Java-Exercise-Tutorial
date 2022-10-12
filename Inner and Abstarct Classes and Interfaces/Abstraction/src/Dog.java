public class Dog extends Animal{

    public Dog(String name) {
        super(name);
    }

    public void eat() {
        System.out.println(getName() + " is eating");
    }

    public void breathe() {
        System.out.println("Breathing in, breathe out, repeat");
    }
}
