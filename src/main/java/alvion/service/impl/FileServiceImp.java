package alvion.service.impl;

import alvion.model.FileInfo;
import alvion.service.FileService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

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
            String getPath ="";
            getPath = f.getPath().toString().replace("d:\\","");
            getPath = getPath.replace("\\","/");
            FileInfo fObj = new FileInfo(f.getName(), f.isDirectory(),f.length(),getPath);
            fO.add(fObj);
        }
        Collections.sort(fO);
        return fO;
    }

    @Override
    public String checkpath(String str) {
            String getPath ="";
            getPath = str.toString().replace("d:\\","");
            getPath = str.replace("\\","/");

        return getPath;
    }

    @Override
    public String parseStr(String str) {
        String s ="";
        StringTokenizer stk = new StringTokenizer(str,"/");
        ArrayList<String> list = new ArrayList<String>();
        String []ar = new String[stk.countTokens()];
        int i = 0;
            while (i < ar.length - 1) {
                s = s + "/" + stk.nextToken();
                i++;
            }
        //System.out.println ("str1:  \\:"  +ss);
        return s;
    }
}

