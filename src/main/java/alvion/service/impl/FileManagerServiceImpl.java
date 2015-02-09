package alvion.service.impl;

import alvion.bl.FileManager;
import alvion.dto.FileInfoDto;
import alvion.service.FileManagerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileManagerServiceImpl implements FileManagerService {

    private FileManager fileManager;

    public FileManagerServiceImpl()
    {
        fileManager = new FileManager("C:");
    }

    @Override
    public List<String> showCurrentDir()
    {

        return fileManager.showFolderContent();
    }

    @Override
    public List<FileInfoDto> showContentOfDir(String path) {

        return fileManager.showFolderContentForPath(path);
    }


    @Override
    public List<String> changeFolder( String  name)
    {
        fileManager.changeCurrentDir(name);
        return  fileManager.showFolderContent();
    }

}
