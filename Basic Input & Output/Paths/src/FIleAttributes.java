import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class FIleAttributes {

    public static void main(String[] args) {
        try {

            // CREATING FILE AND DIRECTORY
//            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "createdFile.txt");
//            Files.createFile(fileToCreate);

//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.createDirectory(dirToCreate);

//            Path dirToCreate = FileSystems.getDefault().getPath("Examples","Dir2/Dir3/Dir4/Dir5/Dir6");
//            Files.createDirectories(dirToCreate);

            Path filePath = FileSystems.getDefault().getPath("Examples/Dir1/file1.txt");
            long size = Files.size(filePath);
            System.out.println("Size = " + size);
            System.out.println("Last Modified = " + Files.getLastModifiedTime(filePath));

            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size = " + attrs.size());
            System.out.println("Last modified " + attrs.size());
            System.out.println("Is directory " + attrs.isDirectory());
            System.out.println("Is regular file = " + attrs.isRegularFile());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
