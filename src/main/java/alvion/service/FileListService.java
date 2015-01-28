package alvion.service;

import alvion.model.FileInfo;

import java.util.List;

/**
 * Created by Odour on 28.01.2015.
 */
public interface FileListService {
    public List<FileInfo> getFileList(String pathname);
}
