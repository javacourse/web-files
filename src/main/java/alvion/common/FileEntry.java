package alvion.common;

import java.io.File;
import java.nio.file.Path;

/**
 * Created by Ilya Ten
 * Date: 1/27/2015
 */
public class FileEntry implements Comparable<FileEntry>{
    private String name;
    private boolean isDirectory;
    private long size;
    private String path;

    public FileEntry(File file) {
        name = file.getName();
        isDirectory = file.isDirectory();
        size = file.length();
        path = cleanPath(file.getPath());
    }

    public FileEntry(Path parentDirectory) {
        name = "..";
        isDirectory = true;
        size = 0;
        path = cleanPath(parentDirectory.toString());
    }

    public static String cleanPath(String path) {
        String result = path.replaceAll("\\\\", "/");
        return (result.endsWith("/") ? result.substring(0, result.length()-1) : result);
    }

    public String getName () {
        return name;
    }

    public boolean getIsDirectory () {
        return isDirectory;
    }

    public long getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return (isDirectory ? "\\" : "") + name + (isDirectory ? "" : ", " + Long.toString(getSize()));
    }

    @Override
    public int compareTo (FileEntry fileEntry){
        if (isDirectory != fileEntry.getIsDirectory()) {
            if (isDirectory) {
                return -1; // directories are always in the top
            }
            return 1;
        }

        return String.CASE_INSENSITIVE_ORDER.compare(name, fileEntry.getName());
    }

}
