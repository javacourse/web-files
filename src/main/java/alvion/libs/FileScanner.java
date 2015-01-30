package alvion.libs;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

public class FileScanner {

    public static Set<FileInfo> scan(String path, String relativePath) {
        File pathName = new File(path);
        Set<FileInfo> fileSet = new TreeSet(new FileComparator());

        if(pathName.exists()) {
            String[] files = pathName.list();
            for(String i : files) {
                File f = new File(pathName.getPath(), i);
                FileInfo fileObject = new FileInfo(f.getAbsolutePath().replaceFirst("^" + relativePath, ""), f.getName(), f.isDirectory());

                fileSet.add(fileObject);
            }
        }
        return fileSet;
    }
}