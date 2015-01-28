package alvion.model;

/**
 * Created by Odour on 23.01.2015.
 */

public class FileInfoModel implements Comparable{

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

    public FileInfoModel(String fileName, boolean dirFlag, long size, String path) {
        this.fileName = fileName;
        this.isDir = dirFlag;
        this.size = size;
        this.path = path;
    }

    @Override
    public int compareTo(Object o) {
        FileInfoModel obj = (FileInfoModel) o;
        return fileName.compareToIgnoreCase(obj.getFileName());
    }
}
