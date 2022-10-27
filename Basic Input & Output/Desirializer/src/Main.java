import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Serialization:   The process of converting an object into a byte stream.
        // Deserialization: The reverse process of converting a byte into an object.

        // serialVersionUID:    Unique ID that functions like a version number and it
        // verifies that the sender and receiver of a serialized object, have loaded
        // classes for that object that match Ensures object will be compatible between machines
        // Number must match otherwise this will cause InvalidClasException.
        // A SerialVersionUID will be calculated based on class properties, members, etc.
        // A serializable class can declare its own serialVersionUID explicitly (recommended).

        User user = null;

        FileInputStream fileIn = new FileInputStream("C:\\Java\\projects\\tutorial\\Basic Input & Output\\Serializer\\UserInfo.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        user = (User) in.readObject();
        in.close();
        fileIn.close();

        System.out.println(user.name);
        System.out.println(user.password);
        user.sayHello();

        long serialVersionUID = ObjectStreamClass.lookup(user.getClass()).getSerialVersionUID();
        System.out.println(serialVersionUID);
    }
}
