package alvion.service.impl;

import alvion.dto.FileDto;
import alvion.repository.FileRepository;
import alvion.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileRepository fileRepository;

    @Override
    public List<FileDto> getFiles(String path) throws Exception {
        return fileRepository.getDirectoryInfo(path);
    }
}
