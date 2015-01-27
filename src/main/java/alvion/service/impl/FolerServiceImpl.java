/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvion.service.impl;

import alvion.models.FileItem;
import alvion.models.FolderItem;
import alvion.service.FolderService;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 *
 * @author elazarchuk
 */
@Service
public final class FolerServiceImpl implements FolderService{
    private FolderItem folder;
    private String parentFolder;
    
    @Override
    public void setFolder(String path) throws FileNotFoundException{
        folder = new FolderItem(path);
        String[] splitedPath = path.split("/");
        if(0 == splitedPath.length){
            parentFolder = null;
        } else {
            StringBuilder tempStr = new StringBuilder("");
            for(int i = 0; i < splitedPath.length - 1; i++){
                if(!splitedPath[i].isEmpty()){
                    tempStr.append("/").append(splitedPath[i]);
                }
            }
            parentFolder = tempStr.toString();
        }
    }

    @Override
    public String getFolderName() {
        return folder.getPath();
    }

    @Override
    public List<FileItem> getFolderContent() {
        return folder.getContent();
    }

    @Override
    public String getParentFolderName() {
        return parentFolder;
    }
}
