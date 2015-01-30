package alvion.controller;

import alvion.libs.FileInfo;
import alvion.libs.FileScanner;
import alvion.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.io.File;

import java.util.Set;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
        return new ModelAndView("redirect:/path/");
	}

    @RequestMapping(value = "/path/**", method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request) {
        String url = request.getRequestURI().toString();

        String urlParams = url.substring(6); //path without '/path' string
        String userHomeDirectory = System.getProperty("user.home");
        String folderPath = userHomeDirectory.toString() + "/" + urlParams;

        Set<FileInfo> files = FileScanner.scan(folderPath, userHomeDirectory);
        File parentFolder = new File(folderPath.replaceFirst("^" + userHomeDirectory, ""));
        String parentPath = parentFolder.getParent();

        ModelAndView model = new ModelAndView("list");

        model.addObject("files", files);
        model.addObject("parent", parentPath);
        model.addObject("homePath", userHomeDirectory.toString());
        model.addObject("h", urlParams);
        return model;
    }

}