import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40","N36",
                "B12","B6",
                "G53","G49", "G60", "G50","g64",
                "I26", "I17","I29",
                "O71"
        );

        List<String> gNumbers = new ArrayList<>();

        // Using Streams
        someBingoNumbers
                // Stream is a sequence of objects that supports various methods which can
                // be pipelined to produce desired result
                .stream()
                // Method reference :: Collection of statements that perform
                // some specific task and return the result to the caller
                // map method accepts a function (accepts one argument and returns a value)
                .map(String::toUpperCase)
                // Alternative
                // .map(s->s.toUpperCase())
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> ioNumberStream = Stream.of("I26","I17","I29","O71");
        Stream<String> inNumberStream = Stream.of("N40","N36","I26","I17","I29","O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("------------------------");
        // Count number of non-duplicate Streams
        System.out.println(concatStream.
                distinct()
                .peek(System.out::println)
                .count());

//        someBingoNumbers.forEach(number -> {
//            if(number.toUpperCase().startsWith("G")) {
//                gNumbers.add(number);
//                System.out.println(number);
//            }
//        });
//
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));

        Employee john = new Employee("John Doe",30);
        Employee jack = new Employee("Jack Hill",40);
        Employee jane = new Employee("Jane Deer",25);
        Employee snow = new Employee("Snow White",22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        departments.stream()
                // Combination of flat (method that creates array with all sub-array elements
                // concatenated into it recursively up to the specified path
                // and map (returns a stream of the results of applying the given function to
                // the elements of this stream
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        // Storing the list using the collect method
//        List<String> sortedGNumbers = someBingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());

        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                // First argument: Supplier (which creates objects)
                // Second argument: Accumulator (adding items to the ArrayList
                // Third Argument: Combiner
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

                for(String s: sortedGNumbers) {
                    System.out.println(s);
                }

                // Creating a map of lists based on age
        Map<Integer,List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

                // Reduce: combines all the items in a string into a single result
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1,e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        Stream.of("ABC","AC","BAA","CCCC","XY","ST")
                .filter(s -> {
                    // Nothing is being printed here. That's because Stream operations are lazily
                    // evaluated (i.e. nothing happens until there is a terminal operation)
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();
    }
}

