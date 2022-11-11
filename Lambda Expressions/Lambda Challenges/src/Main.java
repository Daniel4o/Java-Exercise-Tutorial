import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Challenge1 challenge1 = new Challenge1();
        System.out.println("Challenge 1:");
        challenge1.challenge.run();
        System.out.println("\nLambda expression solution:");
        challenge1.solution.run();

        Challenge2 challenge2 = new Challenge2();
        System.out.println("\nChallenge 2:");
        System.out.println(challenge2.solution.apply("12345678"));

        Challenge3 challenge3 = new Challenge3();
        System.out.println("\nChallenge 3:");
        System.out.println(challenge3.lambdaFunction.apply("1234567890"));

        String everySecondCharacter = challenge4(challenge3.lambdaFunction, "1234567890");
        System.out.println("\nChallenge 4:");
        System.out.println(everySecondCharacter);

        System.out.println("\nChallenge 5: ");
        Supplier<String> iLoveJava = () -> { return "I love Java"; };
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);


        // First letter to upper case
        System.out.println("\nChallenge 6: ");
        TopNames topNames = new TopNames();
        topNames.challenge6();

        // First letter to upper case using method reference
        System.out.println("\nChallenge 7:");
        topNames.challenge7();

        // First letter to upper case then sort and print the list using
        // a stream and a chain of stream operations
        System.out.println("\nChallenge 8: ");
        topNames.challenge8();

        // Print names who start with A and count the names
        System.out.println("\nChallenge 9: ");
        topNames.challenge9();

        // Peek through the list
        System.out.println("\nChallenge 10: ");
        topNames.challenge10();

    }

    public static String challenge4(Function<String, String> func, String source) {
        return func.apply(source);
    }
}

class Challenge1 {

    Runnable challenge = new Runnable() {
        @Override
        public void run() {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        }
    };

    Runnable solution = () -> {
        String myString = "Let's split this up into an array";
        String[] parts = myString.split(" ");
        for (String part : parts) {
            System.out.println(part);
        }
    };
}

class Challenge2 {

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i=0; i<source.length(); i++) {
            if(i%2 ==1) {
                returnVal.append(source.charAt(i));
            }
        }

        return returnVal.toString();
    }

    Function<String,String> solution =  source -> {
        StringBuilder returnVal = new StringBuilder();
        for (int i=0; i<source.length(); i++) {
            // Appends even numbers
            if(i%2 ==1 ) {
                returnVal.append(source.charAt(i));
            }
        }

        return returnVal.toString();
    };
}

class Challenge3 {

    Function<String, String> lambdaFunction = s -> {
        StringBuilder returnVal = new StringBuilder();
        for(int i =0; i<s.length(); i++) {
            if(i%2 == 1) {
                returnVal.append(s.charAt(i));
            }
        }

        return returnVal.toString();
    };
}

class TopNames {

    List<String> topNames2015 = Arrays.asList(
            "Amelia",
            "Olivia",
            "emily",
            "Isla",
            "Ava",
            "oliver",
            "Jack",
            "Charlie",
            "harry",
            "Jacob"
    );

        List<String> firstUpperCaseList = new ArrayList<>();
        List<String> firstUpperCaseList2 = new ArrayList<>();
        List<String> firstUpperCaseList3 = new ArrayList<>();

    public void challenge6 () {

        topNames2015.forEach(name -> {
            firstUpperCaseList.add(name.substring(0,1).toUpperCase() + name.substring(1));
            firstUpperCaseList.sort((s1,s2) -> s1.compareTo(s2));
            firstUpperCaseList.forEach(s -> System.out.println(s));
        });
    }

    public void challenge7() {
        topNames2015.forEach(name ->
            firstUpperCaseList2.add(name.substring(0,1).toUpperCase() + name.substring(1)));
            firstUpperCaseList2.sort(String::compareTo);
            firstUpperCaseList2.forEach(System.out::println);
    }

    public void challenge8() {
        topNames2015
                .stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }

    public void challenge9() {
   long namesBeginningWithA = topNames2015
                .stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .filter(s -> s.startsWith("A"))
                .count();

        System.out.println("Number of names beginning with A is: " + namesBeginningWithA);
    }

    public void challenge10 () {
        long peekNames = topNames2015
                .stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted(String::compareTo)
                .count();
    }
}

