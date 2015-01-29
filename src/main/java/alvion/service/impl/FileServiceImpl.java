package alvion.service.impl;

import alvion.dto.FileDto;
import alvion.service.FileService;
import alvion.utils.FileManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public List<FileDto> getFiles(String path) throws Exception {
        FileManager fileManager = new FileManager(path);
        return fileManager.getDirectoryInfo();
    }
}
