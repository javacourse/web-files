package alvion.controller;

import alvion.model.FileInfo;
import alvion.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ragham on 29.01.2015.
 */
    @Controller
    @RequestMapping("/rest/")
    //@Produces({"application/xml","application/json"});

    public class ItemControllerRest {
    public String rootFolder = "d:\\";
    @Autowired
    private FileService fileservice;

    //@RequestMapping(method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET, produces = {"application/json"})//MediaType.APPLICATION_JSON_VALUE
    public  List<FileInfo> init() throws UnsupportedEncodingException {
        List<FileInfo> fileList = new ArrayList();
        System.out.println(fileservice.checkpath(rootFolder));

        try {

            fileList = fileservice.getItems(rootFolder);

        } catch(Exception e) {
            System.out.println("xxx");
        }

        return fileList;
    }

    @RequestMapping(value = "/listoffiles/**",method = RequestMethod.GET, produces = {"application/json"})//MediaType.APPLICATION_JSON_VALUE)
        public @ResponseBody List<FileInfo> showIndexPage(HttpServletRequest request) throws UnsupportedEncodingException{
        String curFolderPath = "";
        String prevFolderPath = "";
        curFolderPath = URLDecoder.decode(request.getRequestURI(), "UTF-8");
        //curFolderPath = request.getRequestURI();
        StringBuilder strBuilder = new StringBuilder();
        curFolderPath = curFolderPath.replace("/rest/listoffiles/","");
        curFolderPath = fileservice.checkpath(curFolderPath);
        prevFolderPath = fileservice.parseStr(fileservice.checkpath(curFolderPath));
        List<FileInfo> fileList = new ArrayList();
        System.out.println("abcd");
        System.out.println(rootFolder+curFolderPath);

        try {

            fileList = fileservice.getItems(rootFolder+curFolderPath);

        } catch(Exception e) {
            System.out.println("xxx");
        }

        return fileList;
    }
}
