public class Main {
    public static void main(String[] args) {
        BankAccount bobsAccount = new BankAccount("12234",
                0.00, "Bob Brown",
                "mymail@gmail.com", "0987654321");


        bobsAccount.deposit(50.0);
        bobsAccount.withdrawal(100.0);

        bobsAccount.deposit(51.0);
        bobsAccount.withdrawal(100.0);

    BankAccount daniel4oAccount = new BankAccount("Daniel","my@gmail.com","12345");
        System.out.println(daniel4oAccount.getAccountNumber() + " name " + daniel4oAccount.getCustomerName());

   VipCustomer person1 = new VipCustomer();
        System.out.println(person1.getName());
        VipCustomer person2 = new VipCustomer("Bob", 2500.00);
        System.out.println(person2.getName());

        VipCustomer person3 = new VipCustomer("Da", 100.00,"@gmail.com");
        System.out.println(person3.getName());
    }

}
