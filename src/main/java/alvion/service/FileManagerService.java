package alvion.service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Burnos
 */
public interface FileManagerService {
   /* String helloMessage();*/

    List<String> showCurrentDir();

    List<String> changeFolder(String  name);
    /*List<String> changeFolder(String name);*/
    /*String helloMessage();*/
}
