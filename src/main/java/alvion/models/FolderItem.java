/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvion.models;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author elazarchuk
 */
public final class FolderItem {
    private String path;
    private List<FileItem> content;
    
    public FolderItem(String path) throws FileNotFoundException{
        this.setPath(path);
    }

    public String getPath(){
        return this.path;
    }
    
    public void setPath(String path) throws FileNotFoundException{
        this.path = path;
        this.setContent();
    }
    
    public List<FileItem> getContent(){
        return this.content;
    }
    
    private void setContent(){
        this.content = new ArrayList<>();
        File file = new File(this.path);
        for (String item :file.list()){
            try {
                this.addToContent(new FileItem(this.path,item));
            } catch (FileNotFoundException e) {
                //looks like file was deleted between operations so just skeep it
            }
        }
    }
    
    private void addToContent(FileItem file){
        boolean isAdded = false;
        
        for(int i = 0; i < this.content.size(); i++){
            if(!this.isGreater(file, this.content.get(i))){
                this.content.add(i, file);
                isAdded = true;
                break;
            }
        }
        
        if(!isAdded){
            this.content.add(file);
        }
    }
    
    private boolean isGreater(FileItem first, FileItem second){
        if(first.isDirectory() && !second.isDirectory()){
            return false;
        }
        
        if(!first.isDirectory() && second.isDirectory()){
            return true;
        }
        
        return first.getName().compareTo(second.getName()) >= 0;
    }
    
}
