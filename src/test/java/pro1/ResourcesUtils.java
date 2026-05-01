package pro1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class ResourcesUtils {
    public static String readResourceFile(String path){
        try {
            return Files.readString(Paths.get("src","test", "resources", path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
