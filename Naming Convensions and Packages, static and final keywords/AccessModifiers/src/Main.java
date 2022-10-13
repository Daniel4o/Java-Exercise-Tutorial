public class Main {
    public static void main(String[] args) {
      Account userAccount = new Account("User");
      userAccount.deposit(1000);
      userAccount.withdraw(500);
      userAccount.withdraw(-200);
      userAccount.deposit(-20);
      userAccount.calculateBalance();

        System.out.println("Balance on account is " + userAccount.getBalance());
    }
}
