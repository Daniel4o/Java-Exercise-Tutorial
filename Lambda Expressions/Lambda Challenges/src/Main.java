import java.util.ArrayList;
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

//        Challenge5 challenge5 = new Challenge5();
//        System.out.println("\nChallenge 5: ");
//        System.out.println(challenge5.);


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

class Challenge5 {
    Supplier<String> iLoveJava = () -> { return "I love Java"; };
}


