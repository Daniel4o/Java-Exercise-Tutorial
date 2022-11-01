import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOperations {

    public static void main(String[] args) {
        try {

            // DELETE FILE
            Path fileToDelete = FileSystems.getDefault().getPath("Examples","Dir1","file1copy.txt");
            Files.deleteIfExists(fileToDelete);
             //COPY FILE
//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1Copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
              // MOVE
//            Path fileToMove = FileSystems.getDefault().getPath("Examples","file1.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples","file2.txt");
//            Files.move(fileToMove,destination);

            // COPY DIRECTORY
//            sourceFile = FileSystems.getDefault().getPath("Examples","Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples","Dir4");
//            Files.copy(sourceFile,copyFile,StandardCopyOption.REPLACE_EXISTING);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
