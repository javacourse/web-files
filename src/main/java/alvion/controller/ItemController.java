package alvion.controller;

import alvion.model.FileInfo;
import alvion.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by ragham on 29.01.2015.
 */
    @Controller
    @RequestMapping("/")
    public class ItemController {

        @Autowired
        private FileService fileservice;

        @RequestMapping(method = RequestMethod.GET)
        public ModelAndView init() throws UnsupportedEncodingException {
            ModelAndView model = new ModelAndView("listoffiles");
            String rootFolder = "d://";
            model.addObject("rootFolder", rootFolder);
            try {
                List<FileInfo> fileList = fileservice.getItems(rootFolder);
                model.addObject("fileList", fileList);
                //model.addObject("test", true);
                for (FileInfo s : fileList) {
                    System.out.println(s.toString());
                }
            } catch(Exception e) {
                model = new ModelAndView("test");
            }
            return model;
        }

        @RequestMapping(value = "/listoffiles/{lf}", method = RequestMethod.GET)
        public ModelAndView list(@PathVariable String lf, HttpServletRequest request) {

            //System.out.println("1= " + request.getRequestURI());
            System.out.println("2= " + request.getRequestURL().toString());
            System.out.println(lf.toString());
            ModelAndView model = new ModelAndView("listoffiles");
            //String rootFolder = "d://";
            model.addObject("lf", lf);
            //model.addObject("test", true);
            model.addObject("rootFolder", lf);
            try {
                String otherFolder = "d://1/";
                model.addObject("otherFolder", otherFolder);
                List<FileInfo> fileList = fileservice.getItems(otherFolder);
                model.addObject("fileList", fileList);
                for (FileInfo s : fileList) {
                    System.out.println(s.toString());
                }
            } catch(Exception e) {
                model = new ModelAndView("test");
            }


            /*List<String> list = new ArrayList();
            list.add("c://");
            list.add("d://");
            list.add("String 3");
            list.add(path);
            model.addObject("list", list);*/
            return model;

        }
    }
//----------------------------------
//----------------------------------

