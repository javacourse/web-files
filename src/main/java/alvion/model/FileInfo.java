package alvion.model;

/**
 * Created by Odour on 23.01.2015.
 */

public class FileInfo implements Comparable{

    private String fileName;
    private boolean isDir;
    private long size;
    private String path;

    public String getFileName() {
        return fileName;
    }

    public boolean isDir() {
        return isDir;
    }

    public long getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }

    public FileInfo(String fileName, boolean dirFlag, long size, String path) {
        this.fileName = fileName;
        this.isDir = dirFlag;
        this.size = size;
        this.path = path;
    }

    @Override
    public int compareTo(Object o) {
        FileInfo obj = (FileInfo) o;
        return fileName.compareTo(obj.getFileName());
    }
}
