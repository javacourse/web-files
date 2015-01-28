package alvion.service;

import org.springframework.stereotype.Service;

/**
 * Created by Odour on 28.01.2015.
 */

public interface FolderService {
    public String getNextFolderPath(String uri, String requestMappingValue);
    public String getCurrentFolderPath(String uri, String requestMappingValue);
}
