import java.util.ArrayList;

public class Banking {
    private String name;
    private ArrayList<Branch> branches;

    public Banking(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String name) {
        if(findBranch(name) == null) {
            branches.add(new Branch(name));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.newCustomer(customerName,transaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double transaction) {
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addCustomerTransaction(customerName, transaction);
        }
        return false;
    }

   private Branch findBranch(String name) {
       for(int i =0; i< branches.size(); i++) {
           Branch branch = branches.get(i);
           if(branch.getName() == name) return branch;
       }
    return null;
    }

    public boolean listCustomers(String name, boolean transaction) {
        Branch branch = findBranch(name);
        if(branch != null) {
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(int i =0; i< branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
                if(transaction) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for(int j =0; j<transactions.size(); j++) {
                        System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        }
        else return false;
    }
}
