package alvion.service;

import alvion.model.FileInfoModel;

import java.util.List;

/**
 * Created by Odour on 28.01.2015.
 */
public interface FileListService {
    public List<FileInfoModel> getFileList(String pathname);
}
