package alvion.service.impl;

import alvion.model.FileInfo;
import alvion.service.FileService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ragham on 29.01.2015.
 */
@Service
public class FileServiceImp implements FileService{

    @Override
    public List<FileInfo> getItems(String pathname) throws Exception {
        ArrayList<FileInfo> fO = new ArrayList<FileInfo>();
        File dir = new File(pathname);
        File[] fList = dir.listFiles();
        for(File f: fList) {
            FileInfo fObj = new FileInfo(f.getName(), f.isDirectory(),f.length(),f.getAbsolutePath());
            fO.add(fObj);
        }
        Collections.sort(fO);
        return fO;
    }
}
