package alvion.model;

import alvion.utils.FileInfoComparator;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

/**
 * Created by dma on 1/29/15.
 */
public class FolderWalker {
    private String rootFolder;
    private List<String> folders = new ArrayList<>();

    public FolderWalker(String rootFolder){
        this.rootFolder = rootFolder;
    }

    public void setRootFolder(String rootFolder) {
        this.rootFolder = rootFolder;
        folders.clear();
    }

    public String getRootFolder() {
        return rootFolder;
    }

    public void walkRoot() {
        folders.clear();
    }


    public void walkUp() {
        if (folders.size() > 0) {
            folders.remove(folders.size() - 1);
        }
    }

    public void walkInto(String val) {
        folders.add(val);
    }

    public void walkTo(int idx) {
        folders.subList(idx + 1, folders.size()).clear();
    }

    public boolean canWalkUp() {
        return folders.size() > 0;
    }

    public String getFolder() {
        StringBuilder result = new StringBuilder();
        String separator = FileSystems.getDefault().getSeparator();
        result.append(rootFolder);
        for (String s : folders) {
            result.append(separator).append(s);
        }
        return result.toString();
    }

    public List<String> getFolders() {
        List<String> result = new ArrayList<>();
        String separator = FileSystems.getDefault().getSeparator();
        StringBuilder sb = new StringBuilder(rootFolder);
        result.add(rootFolder);
        for (String s : folders) {
            sb.append(separator).append(s);
            result.add(sb.toString());
        }

        return result;
    }

    public Set<FileInfo> getFolderContent() {
        String path = this.getFolder();
        Set<FileInfo> result = new TreeSet<>(new FileInfoComparator());
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(path))) {
            for (Path file: stream) {
                result.add(new FileInfo(file.toFile()));
            }
            return result;
        } catch (IOException | DirectoryIteratorException e) {
            System.err.println(e);
            return result;
        }
    }

    public List<String> getCurrentFolders() {
        return folders;
    }


}
