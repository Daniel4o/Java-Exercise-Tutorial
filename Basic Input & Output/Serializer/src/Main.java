import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

public class Main {
    public static void main(String[] args) throws IOException {

        // Serialization:   The process of converting an object into a byte stream.
        // Deserialization: The reverse process of converting a byte into an object.

        // serialVersionUID:    Unique ID that functions like a version number and it
        // verifies that the sender and receiver of a serialized object, have loaded
        // classes for that object that match Ensures object will be compatible between machines
        // Number must match otherwise this will cause InvalidClasException.
        // A SerialVersionUID will be calculated based on class properties, members, etc.
        // A serializable class can declare its own serialVersionUID explicitly (recommended).

        User user = new User();

        user.name = "User";
        user.password = "123";

        FileOutputStream fileOut = new FileOutputStream("UserInfo.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(user);
        out.close();
        fileOut.close();

        System.out.println("Object info saved");

        long serialVersionUID = ObjectStreamClass.lookup(user.getClass()).getSerialVersionUID();
        System.out.println(serialVersionUID);
    }
}
