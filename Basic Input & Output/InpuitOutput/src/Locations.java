import java.io.*;
import java.util.*;

public class Locations implements Map<Integer,Location> {
    private static Map<Integer, Location> locations = new HashMap<Integer,Location>();

    public static void main(String[] args) throws IOException {

        //Try with resources
        try(FileWriter locFile = new FileWriter("locations.txt");
            FileWriter dirFile = new FileWriter("directions.txt")) {
            for(Location location : locations.values()) {
                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
                for(String direction : location.getExits().keySet()) {
                    dirFile.write(location.getLocationID() + "," + direction + "," + location.getExits().get(direction) + "\n");
                }
            }
        }

//        FileWriter locFile = null;
//        try {
//            locFile = new FileWriter("locations.txt");
//            for (Location location : locations.values()) {
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//            }
//        } finally {
//            System.out.println("In finally block");
//                if(locFile != null) {
//                    locFile.close();
//                    System.out.println("Attempting to close locfile");
//                }
//        }
    }

    // Buffer Reader reads text from the input stream and buffer the characters into
    // a character array

    static {
        Scanner scanner = null;
        try {
           scanner = new Scanner(new FileReader("locations.txt"));
           // Tells the scanner that the information is separated by comma
           scanner.useDelimiter(",");
           while(scanner.hasNextLine()) {
               int loc = scanner.nextInt();
               // Skip over the comma to move to the next section
               scanner.skip(scanner.delimiter());
               String description = scanner.nextLine();
               System.out.println("Imported loc: " + loc + ": " + description);
                Map<String, Integer> tempExit = new HashMap<>();
                locations.put(loc, new Location(loc,description, tempExit));
           }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(scanner != null)
                // When closing Scanner the close method also takes care of closing any readable
                // that it was using, that the readable object implements the closable interface
                // The method close() in Scanner checks if it's source is instacnceof
                scanner.close();
        }

        // Now read the exits
      try {
          scanner = new Scanner(new BufferedReader(new FileReader("directions.txt")));
          scanner.useDelimiter(",");
          while(scanner.hasNextLine()) {
//              int loc = scanner.nextInt();
//              String direction = scanner.next();
//              scanner.skip(scanner.delimiter());
              // Reading the final number as a string using nextLine()
              // Because there's no comma delimiter to tell the scanner to stop reading it
              String input = scanner.nextLine();
              String[] data = input.split(",");
              int loc = Integer.parseInt(data[0]);
              String direction = data[1];
              int destination = Integer.parseInt(data[2]);

              System.out.println(loc + ": " + direction + ": " + destination);
              Location location = locations.get(loc);
              location.addExit(direction,destination);
          }
          } catch(IOException e) {
          e.printStackTrace();
      } finally {
          if(scanner !=null) scanner.close();
      }

//        Map<String,Integer> tempExit = new HashMap<String,Integer>();
//        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",tempExit));
//
//        tempExit = new HashMap<String,Integer>();
//        tempExit.put("W",2);
//        tempExit.put("E", 3);
//        tempExit.put("S", 4);
//        tempExit.put("N", 5);
//        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building",tempExit));
//
//        tempExit = new HashMap<String,Integer>();
//        tempExit.put("N", 5);
//        locations.put(2, new Location(2, "You are at the top of a hill",tempExit));
//
//        tempExit = new HashMap<String,Integer>();
//        tempExit.put("W", 1);
//        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring",tempExit));
//
//        tempExit = new HashMap<String,Integer>();
//        tempExit.put("N", 1);
//        tempExit.put("W", 2);
//        locations.put(4, new Location(4, "You are in a valley beside a stream",tempExit));
//
//        tempExit = new HashMap<String,Integer>();
//        tempExit.put("S", 1);
//        tempExit.put("W", 2);
//        locations.put(5, new Location(5, "You are in the forest",tempExit));
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key,value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
