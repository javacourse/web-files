package alvion.service.impl;

import alvion.dto.FileDto;
import alvion.service.FileService;
import alvion.utils.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileManager fileManager;

    @Override
    public List<FileDto> getFiles(String path) throws Exception {
        fileManager.init(path);
        return fileManager.getDirectoryInfo();
    }
}
