package alvion.service.impl;

import alvion.service.IFolderWalkerService;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystems;
import java.util.LinkedList;

/**
 * Created by dma on 1/28/15.
 */
@Service
public class FolderWalkerServiceImpl implements IFolderWalkerService{
    @Override
    public String msg() {
        return "MESSAGE....";
    }
}
