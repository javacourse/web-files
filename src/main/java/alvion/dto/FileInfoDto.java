package alvion.dto;

/**
 * Created by mbondar on 1/27/2015.
 */
public class FileInfoDto implements Comparable<FileInfoDto>
{

    public String name;
    public long size;
    public boolean isFile;

    /* @Override*/
    public int compareTo(FileInfoDto other) {
        return name.compareTo(other.name);
    }

    public String getName()
    {
        if (isFile)
            return ".." + name;
        else
            return name;
    }
}