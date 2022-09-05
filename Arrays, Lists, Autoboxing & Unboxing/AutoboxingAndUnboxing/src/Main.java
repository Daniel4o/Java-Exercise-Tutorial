import java.util.ArrayList;

// Making an ArrayList of only integers
class IntClass {
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}

public class Main {
    public static void main(String[] args) {
       String[] strArray = new String[10];
       int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList<String>();
        strArrayList.add("Banana");

        // Cannot create ArrayList of primitive types (int)
//        ArrayList<int> intArrayList = new ArrayList<int>();

        // Creating an ArrayList of integers by wrapping it around a class
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54));
        Integer integer = new Integer(54);
        Double doubleValue = new Double(12.25);

        //AUTOBOXING
        // This is where we are creating or converting a primitive type (integer)
        // To a reference type (Integer)
        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        for(int i =0; i<= 10; i++) {
            intArrayList.add(Integer.valueOf(i));
        }

        //UNBOXING
        // We're taking from the class or from the object wrapper
        // and converting into a primitive type
        for(int i = 0; i<= 10; i++) {
            System.out.println(i + " --> " + intArrayList.get(i).intValue());
        }

        Integer myIntValue = 56;  //Integer.valueOf(56)
        int myInt = myIntValue.intValue(); // myIntValue.intValue();

        //Autoboxing
        ArrayList<Double> myDoubleValues = new ArrayList<Double>();
        for(double dbl = 0.0; dbl<= 10.0;dbl+= 0.5) {
            myDoubleValues.add(Double.valueOf(dbl)); // or myDoubleValues.add(dbl)
        }

        // Unboxing
        for(int i =0; i<myDoubleValues.size(); i++) {
            double value = myDoubleValues.get(i).doubleValue();
            System.out.println(i + " --> " + value);
        }
    }
}
