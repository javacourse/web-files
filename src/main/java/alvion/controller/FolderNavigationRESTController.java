package alvion.controller;

import alvion.model.FileInfoModel;
import alvion.service.FileListService;
import alvion.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Odour on 03.02.2015.
 */
@Controller
@RequestMapping("/rest")
public class FolderNavigationRESTController {
    @Autowired
    private FileListService fileListService;

    @Autowired
    private FolderService folderService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<FileInfoModel> init() throws UnsupportedEncodingException {
        return showIndexPage(null);
    }

    @RequestMapping(value = "/list/**", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<FileInfoModel> showIndexPage(HttpServletRequest request) throws UnsupportedEncodingException {

        String nextFolderPath = "";
        List<FileInfoModel> fileList = new ArrayList<>();

        if (request == null) {
            nextFolderPath = "C:\\";
        } else {
            nextFolderPath = folderService.getNextFolderPath(URLDecoder.decode(request.getRequestURI(), "UTF-8"), "list/");
        }
        try {
            fileList = fileListService.getFileList(nextFolderPath);

        } catch(Exception e) {
            System.out.println("Failed trying to read requested folder path");
        } finally {
            return fileList;
        }
    }
}
