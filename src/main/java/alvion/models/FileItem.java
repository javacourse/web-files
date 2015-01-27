/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alvion.models;

import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author elazarchuk
 */
public final class FileItem {
    private final String location;
    private final String name;
    private final boolean isDirectory;
    private final long size;

    public FileItem(String location, String name) throws FileNotFoundException{
        this.name = name;
        this.location = location;
        File file = new File(this.getFullPath());
        if(!file.exists()){
            throw new FileNotFoundException();
        }
        this.isDirectory = file.isDirectory();
        this.size = file.length();
    }
    
    public String getLocation(){
        return this.location;
    }
    
    public String getName(){
        return this.name;
    }
    
    public boolean isDirectory(){
        return this.isDirectory;
    }
    
    public long getSize(){
        return this.size;
    }
    
    public String getFullPath(){
        return this.location.concat("/".concat(this.name));
    }
}
