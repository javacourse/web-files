package alvion.dto;

/**
 * Created by Toshiba on 22.01.2015.
 */
public class FileDto {
    private String  name;
    private long size;
    private boolean isDir;


    public FileDto(String name, boolean isDir, long size) {
        this.name = name;
        this.isDir = isDir;
        this.size = size;
    }

    public FileDto(String name, boolean directory) {
        this.name = name;
        this.isDir = directory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public boolean isDir() {
        return isDir;
    }

    public void setDir(boolean isDir) {
        this.isDir = isDir;
    }

    @Override
    public String toString(){
        return this.getName() + " | " + this.getSize() + " | " + this.isDir();
    }

}
