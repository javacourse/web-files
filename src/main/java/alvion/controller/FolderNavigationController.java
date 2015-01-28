package alvion.controller;

import alvion.model.FileInfoModel;
import alvion.service.FileListService;
import alvion.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;



/**
 * Created by Odour on 28.01.2015.
 */
@Controller
@RequestMapping("/")
public class FolderNavigationController {
    @Autowired
    private FileListService fileListService;

    @Autowired
    private FolderService folderService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView init() throws UnsupportedEncodingException {
        return showIndexPage(null);
    }

    @RequestMapping(value = "list/**", method = RequestMethod.GET)
    public ModelAndView showIndexPage(HttpServletRequest request) throws UnsupportedEncodingException {
        ModelAndView model = new ModelAndView("index");
        String nextFolderPath = "";
        String curFolderPath = "";

        if (request == null) {
            nextFolderPath = "C:\\";
            curFolderPath = "";
        } else {
            curFolderPath = folderService.getCurrentFolderPath(request.getRequestURI(), "list/");
            nextFolderPath = folderService.getNextFolderPath(URLDecoder.decode(request.getRequestURI(), "UTF-8"),"list/");
        }
        try {
            List<FileInfoModel> fileList = fileListService.getFileList(nextFolderPath);
            model.addObject("fileList", fileList);
            model.addObject("prevFolder", curFolderPath);
            model.addObject("curFolder", nextFolderPath);
        } catch(Exception e) {
            model = new ModelAndView("index500");
            model.addObject("prevFolder", curFolderPath);
        }

        return model;
    }
}
