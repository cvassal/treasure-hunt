package data;

import java.io.File;

public class FileUtils {
    public File getFileFromClassPath(String fileName) {
        return new File(getClass().getResource("/" + fileName).getFile());
    }
}
