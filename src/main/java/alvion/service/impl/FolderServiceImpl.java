package alvion.service.impl;

import alvion.service.FolderService;
import org.springframework.stereotype.Service;

/**
 * Created by Odour on 28.01.2015.
 */
@Service
public class FolderServiceImpl implements FolderService {
    @Override
    public String getNextFolderPath(String uri, String requestMappingValue) {
        String[] folderPathArray = uri.split(requestMappingValue);
        return folderPathArray[1];
    }

    @Override
    public String getCurrentFolderPath(String uri, String requestMappingValue) {
        StringBuilder strBuilder = new StringBuilder();
        String[] folderPathArray = uri.split(requestMappingValue);
        String[] actualFolderPath = folderPathArray[1].split("/");

        for (int i = 0; i < actualFolderPath.length - 1; i++) {
            strBuilder.append(actualFolderPath[i]).append('/');
        }

        return  strBuilder.toString();
    }
}
