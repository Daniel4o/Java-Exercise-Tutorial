package com.daniel._static;

// The static variable can be used to refer to the common property
// of all objects
// The static variable gets memory only once in the class area
// at the time of class loading
// Advantages: It saves memory

// The static method belongs to the class rather than the object
// of a class
// Static method can be invoked without the need for creating an
// instance of a class
// Static method can access static data member and can change
// the value of it

public class Main {
    public static void main(String[] args) {
        StaticTest firstInstance = new StaticTest("1st Instance");
        System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstances());

        StaticTest secondInstance = new StaticTest("2nd instance");
        System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstances());

        StaticTest thirdInstance = new StaticTest("3rd instance");
        // here secondInstance is used again. This is because they are all sharing
        // the same copy of instances, so it doesn't matter which
        // instance of the class we use to access a static field,
        // it's always going to return that what is then the valid number
        System.out.println(thirdInstance.getName() + " is instance number " + StaticTest.getNumInstances());
    }
}
