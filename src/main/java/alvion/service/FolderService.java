/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvion.service;

import alvion.models.FileItem;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author elazarchuk
 */
public interface FolderService {
    void setFolder(String path)  throws FileNotFoundException;
    String getFolderName();
    List<FileItem> getFolderContent();
    String getParentFolderName();
}
