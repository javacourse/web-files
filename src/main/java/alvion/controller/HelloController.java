package alvion.controller;

import alvion.libs.FileInfo;
import alvion.libs.FileScanner;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.io.File;

import java.io.UnsupportedEncodingException;
import java.util.Set;
import java.net.URLDecoder;

@Controller
@RequestMapping("/")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
        return new ModelAndView("redirect:/path/");
	}

    @RequestMapping(value = "/path/**", method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request) throws UnsupportedEncodingException {
        String url = request.getRequestURI().toString();
        url = URLDecoder.decode(url, "UTF-8");

        String urlParams = url.substring(6); //path without '/path/' string
        String userHomeDirectory = System.getProperty("user.home");
        String folderPath = userHomeDirectory.toString() + "/" + urlParams;

        Set<FileInfo> files = FileScanner.scan(folderPath, userHomeDirectory);
        File parentFolder = new File(folderPath.replaceFirst("^" + userHomeDirectory, ""));
        String parentPath = parentFolder.getParent();

        Boolean pathExists = new File(folderPath).exists();

        ModelAndView model = new ModelAndView("list");
        model.addObject("files", files);
        model.addObject("parentPath", parentPath);
        model.addObject("homePath", userHomeDirectory.toString());
        model.addObject("urlParams", urlParams);
        model.addObject("pathExists", pathExists);
        return model;
    }

}