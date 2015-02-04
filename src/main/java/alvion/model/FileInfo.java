package alvion.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ragham on 1/25/15.
 */
@XmlRootElement
public class FileInfo implements Comparable<FileInfo> {
    @JsonIgnore
    private String name;
    private boolean isDir;
    private String isDirName;
    private long size;
    private String Path;

    /* @Override*/
    @Override
    public int compareTo(FileInfo other) {

        return isDirName.compareToIgnoreCase(other.isDirName);
    }

    @Override
    public String toString() {
        return "n="+name+" isDir="+isDir+ " Size= "+size +" Path=" + Path;
    }

    public FileInfo(String name, boolean isDir, long size, String Path){
        this.name = name;
        this.isDir = isDir;
        this.size = size;
        this.Path = Path;
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
    public String getPath(){
        return Path;
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
    public void setPath(String Path){
        this.Path = Path;
    }
}