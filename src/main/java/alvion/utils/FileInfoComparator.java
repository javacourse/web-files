package alvion.utils;

import alvion.model.FileInfo;

import java.util.Comparator;

/**
 * Created by dma on 1/29/15.
 */
public class FileInfoComparator implements Comparator<FileInfo> {
    @Override
    public int compare(FileInfo f1, FileInfo f2) {
        int k = ((Boolean) f1.isDir()).compareTo(f2.isDir());
        if (k == 0) {
            return f1.getFile().compareTo(f2.getFile());
        }
        return -k;
    }
}
