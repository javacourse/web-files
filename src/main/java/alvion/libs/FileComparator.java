package alvion.libs;

import java.util.Comparator;

public class FileComparator implements Comparator<FileInfo> {

    @Override
    public int compare(FileInfo o, FileInfo t1) {
        if (!o.getIsDirectory()) {
            return 1;
        }
        return -1;
    }
}
