package alvion.service;

import alvion.dto.FileInfoDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Burnos
 */
public interface FileManagerService {
   /* String helloMessage();*/

    List<String> showCurrentDir();

    List<FileInfoDto> showContentOfDir(String path);

    List<String> changeFolder(String  name);
    /*List<String> changeFolder(String name);*/
    /*String helloMessage();*/
}
