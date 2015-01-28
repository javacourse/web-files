package alvion.service.impl;

import alvion.model.FileInfo;
import alvion.service.FileListService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Odour on 23.01.2015.
 */
@Service
public class FileListServiceImpl implements FileListService {

    public List<FileInfo> getFileList(String pathname) {
        File rootDir = new File(pathname);
        List<FileInfo> foundFiles = new ArrayList<>();
        List<FileInfo> files = new ArrayList<>();
        List<FileInfo> dirs = new ArrayList<>();

        if (rootDir.isDirectory()) {
            File[] filesArray = rootDir.listFiles();
            for (File curFile: filesArray) {
                if (curFile.isFile() && !curFile.isHidden()) {
                    FileInfo file = new FileInfo(curFile.getName(), curFile.isDirectory(), curFile.length(), curFile.getPath());
                    files.add(file);
                } else if (curFile.isDirectory()&& !curFile.isHidden()) {
                    FileInfo file = new FileInfo(curFile.getName(), curFile.isDirectory(), 0, curFile.getPath());
                    dirs.add(file);
                }
            }

        }

        Collections.sort(files);
        Collections.sort(dirs);

        foundFiles.addAll(dirs);
        foundFiles.addAll(files);

        return foundFiles;
    }
}
