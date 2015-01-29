package alvion.model;
/**
 * Created by ragham on 1/25/15.
 */
public class FileInfo implements Comparable<FileInfo> {
    private String name;
    private boolean isDir;
    private String isDirName;
    private long size;
    private String absolutePath;

    /* @Override*/
    @Override
    public int compareTo(FileInfo other) {

        return isDirName.compareToIgnoreCase(other.isDirName);
    }

    @Override
    public String toString() {
        return "n="+name+" isDir="+isDir+ " Size= "+size +" Path=" + absolutePath;
    }

    public FileInfo(String name, boolean isDir, long size, String absolutePath){
        this.name = name;
        this.isDir = isDir;
        this.size = size;
        this.absolutePath = absolutePath;
        if (isDir ==true) {
            this.isDirName = "0"+name;
        }else{
            this.isDirName = "1"+name;
        }
    }
    public String getName(){
        return name;
    }
    public boolean getIsDir(){
        return isDir;
    }
    public long getSize(){
        return size;
    }
    public String getabsolutePath(){
        return absolutePath;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setIsDir(boolean isDir){
        this.isDir = isDir;
        if (isDir ==true) {
            this.isDirName = "0"+name;
        }else{
            this.isDirName = "1"+name;
        }

    }
    public void setSize(long size){
        this.size = size;
    }
    public void setSize(String absolutePath){
        this.absolutePath = absolutePath;
    }
}