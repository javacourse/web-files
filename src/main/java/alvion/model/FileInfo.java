package alvion.model;

import java.io.File;

/**
 * Created by dma on 1/28/15.
 */
public class FileInfo {
    private String name;
    private boolean isDir;
    private long size;
    private File file;

    public FileInfo(File file) {
        this.file = file;
        this.name = file.getName();
        this.isDir = file.isDirectory();
        this.size = file.length();
    }

    public String getName() {
        return name;
    }

    public boolean isDir() {
        return isDir;
    }

    public long getSize() {
        return size;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        if (isDir) {
            return "\\" + name;
        } else {
            return " " + name + " (" + size + ") bytes";
        }
    }

}
