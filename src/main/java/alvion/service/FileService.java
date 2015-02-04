package alvion.service;

import alvion.model.FileInfo;

import java.util.List;

/**
 * Created by ragham on 29.01.2015.
 */
public interface FileService {
    public List<FileInfo> getItems(String pathname) throws Exception;
    public String checkpath(String str);
    public String parseStr(String str);
}

