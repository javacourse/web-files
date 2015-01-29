package alvion.service;

import alvion.dto.FileDto;

import java.util.List;


public interface FileService {
    List<FileDto> getFiles(String path) throws Exception;

}
