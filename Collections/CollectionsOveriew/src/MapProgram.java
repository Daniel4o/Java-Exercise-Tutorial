import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapProgram {
    public MapProgram() {
    }

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap();
        if (languages.containsKey("Java")) {
            System.out.println("Java already exists");
        } else {
            languages.put("Java", "a compiled high level, object-oriented, platform independent language");
            System.out.println("Java added successfully");
        }

        languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        // Returns null
        System.out.println((String)languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code"));
        System.out.println((String)languages.put("Lisp", "Therein lies madness"));
        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "this course is about Java");
        }

        System.out.println("================================================");
        if (languages.remove("Algol", "an algorithmic language")) {
            System.out.println("Algol removed");
        } else {
            System.out.println("Algol not removed, key/value pair not found");
        }

        if (languages.replace("Lisp", "Therein lies madness", "a functional programming language with imperative features")) {
            System.out.println("Lisp replaced");
        } else {
            System.out.println("Lisp was not replaced");
        }

        Iterator var2 = languages.keySet().iterator();

        while(var2.hasNext()) {
            String key = (String)var2.next();
            System.out.println(key + " : " + (String)languages.get(key));
        }

    }
}
