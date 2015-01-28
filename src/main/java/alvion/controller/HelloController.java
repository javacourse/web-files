package alvion.controller;

import alvion.model.FileInfo;
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

@Controller
@RequestMapping("/")
public class HelloController {

   /* @Autowired
    private HelloService helloService;

    @RequestMapping(method = RequestMethod.GET)
	public ModelAndView printWelcome() {
        ModelAndView model = new ModelAndView("hello");
		model.addObject("message", helloService.helloMessage());
		return model;

	}

    @RequestMapping(value = "list/**", method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request) {

        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL().toString());

        ModelAndView model = new ModelAndView("list");
        List<String> list = new ArrayList<>();
        list.add("String 1");
        list.add("String 2");
        list.add("String 3");
     //   list.add(name);
        model.addObject("list", list);
        return model;

    }*/

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
          //  System.out.println(request.getRequestURI());
          //  System.out.println("Current folder " + folderService.getCurrentFolderPath(request.getRequestURI(),"list/"));
          //  System.out.println("Next folder " + folderService.getNextFolderPath(request.getRequestURI(),"list/"));
            curFolderPath = folderService.getCurrentFolderPath(request.getRequestURI(), "list/");
            nextFolderPath = folderService.getNextFolderPath(URLDecoder.decode(request.getRequestURI(), "UTF-8"),"list/");
        }
        try {
            List<FileInfo> fileList = fileListService.getFileList(nextFolderPath);
            model.addObject("fileList", fileList);
            model.addObject("prevFolder", curFolderPath);
        } catch(Exception e) {
          //  System.out.println("Here it is");
            model = new ModelAndView("index500");
            model.addObject("prevFolder", curFolderPath);
        }

        return model;
    }
}