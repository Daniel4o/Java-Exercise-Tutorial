import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Daniel", 54.96);
        Customer anotherCustomer;
        anotherCustomer= customer;
        anotherCustomer.setBalance(12.18);
        // Prints out 12.18 because when we do the assignment anotherCustomer = customer
        // Java is assigning the second customer to class to point to the
        // first class in other words it just saved the memory address
        // it didn't create a class
        System.out.println("Balance for customer " + customer.getName() + " is " + customer.getBalance());

        ArrayList<Integer> intList = new ArrayList<Integer>();

        intList.add(1);
        intList.add(3);
        intList.add(4);

        for(int i =0; i<intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }

        intList.add(1,2);

        for(int i =0; i<intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }
    }
}
