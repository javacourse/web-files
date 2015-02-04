package alvion.controller;

import alvion.model.FileInfo;
import alvion.service.FileService;
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
 * Created by ragham on 29.01.2015.
 */
    @Controller
    @RequestMapping("/")

    public class ItemController {
    public String rootFolder = "d:\\";
    @Autowired
    private FileService fileservice;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView init() throws UnsupportedEncodingException {
        ModelAndView model = new ModelAndView("listoffiles");
        model.addObject("rootFolder", rootFolder);
        try {
            List<FileInfo> fileList = fileservice.getItems(rootFolder);
            model.addObject("fileList", fileList);
        } catch(Exception e) {
            model = new ModelAndView("test");
        }
         return model;
    }

    @RequestMapping(value = "listoffiles/**", method = RequestMethod.GET)
    //@RequestMapping(value = "listoffiles/{lf}", method = RequestMethod.GET)
    public ModelAndView showIndexPage(HttpServletRequest request) throws UnsupportedEncodingException {
//public ModelAndView list(@PathVariable String lf, HttpServletRequest request) {

        String curFolderPath = "";
        String prevFolderPath = "";
        curFolderPath = URLDecoder.decode(request.getRequestURI(), "UTF-8");
        //curFolderPath = request.getRequestURI();
        StringBuilder strBuilder = new StringBuilder();
        curFolderPath =  curFolderPath.replace("/listoffiles/","");
        curFolderPath = fileservice.checkpath(curFolderPath);
        prevFolderPath = fileservice.parseStr(fileservice.checkpath(curFolderPath));

        System.out.println(fileservice.checkpath(curFolderPath));

        ModelAndView model = new ModelAndView("listoffiles");
        try {

            List<FileInfo> fileList = fileservice.getItems(rootFolder+curFolderPath);
            model.addObject("fileList", fileList);
            model.addObject("currentFolder", fileservice.checkpath(prevFolderPath));

        } catch(Exception e) {

            model = new ModelAndView("test");
        }

        return model;
    }
}
