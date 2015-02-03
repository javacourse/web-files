package alvion.service.impl;

import alvion.common.FileEntry;
import alvion.service.BrowseService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Ilya Ten
 * Date: 1/27/2015
 */

@Service
public class BrowseServiceImpl implements BrowseService {
    private Set<FileEntry> entries;
    private Map<Integer,String> directories;
    private Map<String,Integer> headDirectories;
    private String currentPath;

    public BrowseServiceImpl() {
        entries = new TreeSet<>();
        directories = new HashMap<>();
        headDirectories = new LinkedHashMap<>();
    }

    @Override
    public Set<FileEntry> readDirectory(String path) {
        String cleanPath = FileEntry.cleanPath(path);

        if (cleanPath.equals(currentPath)) {
            return entries;
        }

        if (!entries.isEmpty()) {
            // reset list
            entries.clear();
        }

        Path dirToRead = Paths.get(cleanPath);
        if (dirToRead.toFile().isDirectory()) {
            setCurrentPath(cleanPath);
            Path parentPath = dirToRead.getParent();
            if (null != parentPath) {
                entries.add(new FileEntry(parentPath));
                setOnceRead(parentPath.toString());
            }
            File[] files = dirToRead.toFile().listFiles();
            if (null != files) {
                FileEntry entry;
                for (File file : files) {
                    entry = new FileEntry(file);
                    entries.add(entry);
                    if (entry.getIsDirectory()) {
                        setOnceRead(entry.getPath());
                    }
                }
            }
        }
        return entries;
    }

    @Override
    public Set<FileEntry> getDirContent(int dirCode) {
        Integer hashcode = dirCode;
        if (directories.containsKey(hashcode)) {
            readDirectory(directories.get(hashcode));
            return entries;
        }
        return new TreeSet<>();
    }

    @Override
    public Map<String,Integer> getHeadDirectories() { return headDirectories; }

    private void setOnceRead(String path) {
        String cleanPath = FileEntry.cleanPath(path);
        if (!directories.containsKey(cleanPath.hashCode())) {
            directories.put(cleanPath.hashCode(), cleanPath);
        }
    }

    private void setCurrentPath(String cleanPath) {
        currentPath = cleanPath;
        setOnceRead(currentPath);
        headDirectories.clear();
        int posFrom = 0;
        int pos;
        while(posFrom <= currentPath.length()) {
            pos = currentPath.indexOf('/', posFrom);
            if (pos < 0) {
                pos = currentPath.length();
            }
            if (pos > posFrom) {
                String pathFromRoot = currentPath.substring(0, pos);
                headDirectories.put(
                        currentPath.substring(posFrom, pos),
                        (pos < currentPath.length() ? pathFromRoot.hashCode() : 0)
                );
                setOnceRead(pathFromRoot);
            }
            posFrom = pos + 1;
        }
    }
}
