import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        Employee john = new Employee("John Doe", 30);
        Employee daniel = new Employee("Daniel G", 23);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        List<Employee> employees = new ArrayList<>();
        employees.add(john);
        employees.add(daniel);
        employees.add(jack);
        employees.add(snow);

        Function<Employee, String> getLastName = (Employee employee) -> {
            return employee.getName().substring(employee.getName().indexOf(" ") + 1);
        };

        String lastName2 = getLastName.apply(employees.get(1));
        System.out.println(lastName2);

        Function<Employee, String> getFirstName = (Employee employee) -> {
            return employee.getName().substring(0,employee.getName().indexOf(" "));
        };


        printEmployeesByAge(employees, "\nEmployees over 30", employee -> employee.getAge()>30);
        printEmployeesByAge(employees, "\nEmployees under 30", employee -> employee.getAge()<=30);
        printEmployeesByAge(employees, "\nEmployees younger than 25", new Predicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() < 25;
            }
        });

        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;
        System.out.println(greaterThan15.test(10));
        int a = 20;
        System.out.println(greaterThan15.test(a+5));

        System.out.println(greaterThan15.and(lessThan100).test(50));
        System.out.println(greaterThan15.and(lessThan100).test(15));

       // Supplier
        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for(int i=0; i<10; i++) {
            System.out.println(randomSupplier.get());
        }

        employees.forEach(employee -> {
            String lastName = employee.getName().substring(employee.getName().indexOf(" ") +1);
            System.out.println("Last Name is: " + lastName);
        });

        System.out.println("\nGetting random first names or last names:");
        Random random1 = new Random();
        for(Employee employee : employees) {
            System.out.println(getAName(getFirstName,employee));
          if(random1.nextBoolean()) {
              System.out.println(getAName(getFirstName, employee));
          } else {
              System.out.println(getAName(getLastName, employee));
          }
        }

        System.out.println("Uppercasing names in one Function then substringing first name\n " +
                "in another Function and chaining them together:");
        Function<Employee, String> upperCase = employee -> employee.getName().toUpperCase();
        Function<String, String> firstName = name -> name.substring(0, name.indexOf(" "));
        Function chainedFunction = upperCase.andThen(firstName);
        System.out.println(chainedFunction.apply(employees.get(0)));

        BiFunction<String, Employee, String> concatAge = (String name, Employee employee) -> {
            return name.concat(" " + employee.getAge());
        };

        String upperName = upperCase.apply(employees.get(0));
        System.out.println(concatAge.apply(upperName, employees.get(0)));

        IntUnaryOperator incBy5 = i -> i + 5;
        System.out.println(incBy5.applyAsInt(10));

       


        // Enhanced Loop
//        for (Employee employee : employees) {
//            if(employee.getAge() > 30) {
//                System.out.println(employee.getName());
//            }
//        }
    }

        private static String getAName(Function<Employee,String> getName, Employee employee) {
            return getName.apply(employee);
        }

    private static void printEmployeesByAge(List<Employee> employees,
                                            String ageText,
                                            Predicate<Employee> ageCondition) {
        System.out.println(ageText);
        System.out.println("=================");
        for (Employee employee : employees) {
            if (ageCondition.test(employee)) {
                System.out.println(employee.getName());

            }
        }
    }
}