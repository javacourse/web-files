package alvion.service;

import alvion.common.FileEntry;

import java.util.Map;
import java.util.Set;

/**
 * Created by Ilya Ten
 * Date: 1/27/2015
 */
public interface BrowseService {
    void readDirectory(String path);
    Set<FileEntry> getDirContent(int dirCode);
    Map<String, Integer> getHeadDirectories();
}
