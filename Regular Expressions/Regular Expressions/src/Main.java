import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String string = "I am a string. Yes I am.";
        System.out.println(string);
        String yourString = string.replaceAll("I", "You");
       yourString = yourString.replaceAll("am","are");
        System.out.println(yourString);

        String alphanumeric = "abcDeeeF12hhiiiiijkl99z";
        // Replace all characters with Y
        System.out.println(alphanumeric.replaceAll(".","Y"));

        // Replace characters with the caret ^
        System.out.println(alphanumeric.replaceAll("^abcDeee","YYY"));

        String secondString = "abcDeeeF12GhhabcDeeeiiiiijkl99z";
        System.out.println(secondString.replaceAll("^abcDeee", "YYY"));

        // Checks if all the string matches the regex
        System.out.println(alphanumeric.matches("^abcDeee"));
        System.out.println(alphanumeric.matches("^abcDeeeF12hhiiiiijkl99z"));

        // $ match strings that end with pattern
        System.out.println(alphanumeric.replaceAll("ijkl99z$", "THE END"));

        // Replace the characters (individually) in the [] brackets with X
        System.out.println(alphanumeric.replaceAll("[aei]","X"));

        // Replace the characters (individually) if they are followed by F or j
        System.out.println(alphanumeric.replaceAll("[aei][Fj]","X"));

        // Replace the regex either if it's start with upper or lower case
        System.out.println("harry".replaceAll("[Hh]arry","Harry"));

        // Replace every letter except e and j
        String newAlphanumeric = "abcDeeeF12hhiiiiijkl99z";
        System.out.println(newAlphanumeric.replaceAll("[^ej]","X"));

        // Replace the string by te following characters
        System.out.println(newAlphanumeric.replaceAll("[abcdef345678]","X"));
        System.out.println(alphanumeric.replaceAll("[a-fA-F3-8]","X"));

        // Remove case sensitivity
        System.out.println(newAlphanumeric.replaceAll("(?i)[a-f3-8]","X"));

        // Replace the numbers with a string
        System.out.println(newAlphanumeric.replaceAll("[0-9]","X"));
        System.out.println(newAlphanumeric.replaceAll("\\d","X"));

        // Replace all non-digits
        System.out.println(newAlphanumeric.replaceAll("\\D", "X"));

        String hasWhiteSpace =  "I have blanks and\t a tab, and also a newline\n";
        System.out.println(hasWhiteSpace);

        // Remove all white space from the string
        System.out.println(hasWhiteSpace.replaceAll("\\s",""));
        System.out.println(hasWhiteSpace.replaceAll("\t",""));

        // Only Tab, Spaces & Newline characters remain
        System.out.println(hasWhiteSpace.replaceAll("\\S",""));


        // Replace a-z A-Z 0-9 with regex
        System.out.println(newAlphanumeric.replaceAll("\\w","X"));
        System.out.println(hasWhiteSpace.replaceAll("\\w","X"));

        // Adds X in the start and X in the end for each word (meaning replaces it where there is space)
        System.out.println(hasWhiteSpace.replaceAll("\\b","X"));

        String thirdAlphanumericString = "abcDeeeF12hhiiiiijkl99z";

        // Using a quantifier (specifying how often an element in regex can occur)
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{3}","YYY"));
        // + one or more e's
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe+","YYY"));

        String fourthAlphaNumericString = "abcDF12hhiiiiijkl99z";
        // * replaces even if there isn't e (optional e)
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe*","YYY"));

        // Min max number of characters that can occur
        System.out.println(thirdAlphanumericString.replaceAll("^abcDe{2,5}","YYY"));
        System.out.println(thirdAlphanumericString.replaceAll("h+i*j","Y"));

        StringBuilder htmlText = new StringBuilder("<h1>My heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = "<h2>";
        Pattern pattern  = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        matcher.reset();
        int count =0;
        while(matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " +matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while(groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);

        while(h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }

        String tvTest = "tstvtkt";
      //  String tNotVRegExp = "t[^v]";
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while(tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence: " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        String phone1 = "1234567890";
        String phone2 = "(123) 456-7890";
        String phone3 = "123 456-7890";
        String phone4 = "(123)456-7890";

        System.out.println("phone1 = " + phone1.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone2 = " + phone2.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone3 = " + phone3.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));
        System.out.println("phone4 = " + phone4.matches("^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$"));

        String visa1 = "4444444444444"; // should match
        String visa2 = "5444444444444"; // shouldn't match
        String visa3 = "4444444444444444";  // should match
        String visa4 = "4444";  // shouldn't match

        System.out.println("visa1 " + visa1.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa2 " + visa2.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa3 " + visa3.matches("^4[0-9]{12}([0-9]{3})?$"));
        System.out.println("visa4 " + visa4.matches("^4[0-9]{12}([0-9]{3})?$"));

    }
}
