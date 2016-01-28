package data;

import java.io.File;

public class FileUtils extends ClassLoader {

    public File getFileFromClassPath(String fileName) {
        return new File(getResource(fileName).getFile());
    }
}
