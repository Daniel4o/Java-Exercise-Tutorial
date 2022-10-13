public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        String varFour = "this is private to main()";

        ScopeCheck scopeInstance = new ScopeCheck();
        scopeInstance.useInner();
        System.out.println("scopeInstance varOne is " + scopeInstance.getVarOne());
        System.out.println(varFour);

        scopeInstance.timesTwo();
        System.out.println("***********************************");
        scopeInstance.getClass();
        ScopeCheck.InnerClass innerClass =  scopeInstance.new InnerClass();
        innerClass.timesTwo();
        System.out.println("\nvarThree is not accessible here in InnerClass if it's" +
                "declared as a private " + innerClass.varThree);
    }
}

