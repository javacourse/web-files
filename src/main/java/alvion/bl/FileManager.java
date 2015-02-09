package alvion.bl;

import alvion.dto.FileInfoDto;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mbondar on 1/27/2015.
 */
public class FileManager
{
    private String upPattern = "...";
/*    public String currPath;*/
    public ArrayList<String> pathList;


    public FileManager(String initPath)
    {
       /* currPath = initPath;*/
        pathList = new ArrayList<>();

        pathList.add(initPath);
    }


    public List<String> changeCurrentDir( String folderName)
    {
        String temp = null;
        if (folderName.equals(upPattern))
        {
            if (pathList.size() != 1)
            {
                pathList.remove(pathList.size()-1);
            }
        }
        else
        {
         /*   temp = currPath + "//"+ folderName;*/
            pathList.add(folderName);
        }

        File path =  new File(joinArrayWithChar(pathList, "//"));
        if (path.exists() && path.isDirectory())
        {
            return pathList;
        }
        else
        {
            if (pathList.size() != 1)
            {
                pathList.remove(pathList.size()-1);
            }
            return pathList;
        }
    }

    public List<FileInfoDto> showFolderContentForPath(String path)
    {
        List<FileInfoDto> result = new ArrayList<>();

        for (FileInfoDto file : getFiles(getFolderContentWithPath(path), false))
        {
            /*System.out.println(file.getName());*/
            if(null != file)
                result.add(file);
        }

        for (FileInfoDto file : getFiles(getFolderContentWithPath(path), true))
        {
            if(null != file)
                result.add(file);
        }
        return result;
    }



    public List<String> showFolderContent()
    {
        List<String> result = new ArrayList<>();
        result.add(upPattern);
        for (FileInfoDto file : getFiles(getFolderContent(pathList), false))
        {
            /*System.out.println(file.getName());*/
            result.add(file.getName());
        }

        for (FileInfoDto file : getFiles(getFolderContent(pathList), true))
        {
            result.add(file.getName());
        }
        return result;
    }

    private List<FileInfoDto> getFiles(List<FileInfoDto> files, boolean isFile)
    {
        if (files == null)
            return new ArrayList<>();
        ArrayList<FileInfoDto> resultFiles = new ArrayList<FileInfoDto>();

        for (FileInfoDto fileInfo: files)
        {
            if (fileInfo.isFile == isFile)
                resultFiles.add(fileInfo);
        }
        Collections.sort(resultFiles);
        return resultFiles;
    }

    private List<FileInfoDto> getFolderContent(List<String> pathList)
    {
        ArrayList<FileInfoDto> result = new ArrayList<FileInfoDto>();

        String path =  joinArrayWithChar(pathList, "//");
        File file =  new File(path);
        if (!file.exists())
            return null;
        if (file.isFile())
            return null;

        if (file.isDirectory())
        {
            File[] files =  file.listFiles();

            for ( File item : files){

                FileInfoDto fileInfo = new FileInfoDto();
                fileInfo.name =  item.getName();
                fileInfo.size = item.getUsableSpace();
                fileInfo.isFile = item.isFile();
                result.add(fileInfo);
            }
        }

        return result;
    }


    private List<FileInfoDto> getFolderContentWithPath(String path)
    {
        ArrayList<FileInfoDto> result = new ArrayList<FileInfoDto>();

        File file =  new File(path);
        if (!file.exists())
            return null;
        if (file.isFile())
            return null;

        if (file.isDirectory())
        {
            File[] files =  file.listFiles();

            for ( File item : files){

                FileInfoDto fileInfo = new FileInfoDto();
                fileInfo.name =  item.getName();
                fileInfo.size = item.getUsableSpace();
                fileInfo.isFile = item.isFile();
                result.add(fileInfo);
            }
        }

        return result;
    }

    private String joinArrayWithChar(List<String> arr, String pattern)
    {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.size(); i++) {
            builder.append(arr.get(i));
            if (i != arr.size()- 1)
            {
                builder.append(pattern);
            }
        }
        if (arr.size()==1)
        {
            builder.append(pattern);
        }

        return builder.toString();
    }

}
