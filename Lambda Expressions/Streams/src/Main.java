import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                .stream()
                // :: method reference
                // map method accepts a function (accepts one argument and returns a value)
                .map(String::toUpperCase)
                // Alternative
                // .map(s->s.toUpperCase())
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);


//        someBingoNumbers.forEach(number -> {
//            if(number.toUpperCase().startsWith("G")) {
//                gNumbers.add(number);
//                System.out.println(number);
//            }
//        });
//
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));
    }
}

// For tomorrow
// Google Streams
// Google Method reference
