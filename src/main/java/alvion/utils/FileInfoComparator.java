package alvion.utils;

import alvion.model.FileInfo;
import java.util.Comparator;

/**
 * Created by dma on 1/29/15.
 */
public class FileInfoComparator implements Comparator<FileInfo> {
    @Override
    public int compare(FileInfo f1, FileInfo f2) {
        int k = (f1.isDir() == f2.isDir()) ? 0 : (f1.isDir() ? 1 : -1);
        if (k == 0) {
            return f1.getFile().compareTo(f2.getFile());
        }
        return -k;
    }
}
