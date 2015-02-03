package alvion.controller;

import alvion.common.FileEntry;
import alvion.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Set;

/**
 * Created by Ilya Ten
 * Date: 1/30/2015
 */

@Controller
@RequestMapping("/rest")
public class BrowseRestController {
    @Autowired
    private BrowseService browseService;

    @RequestMapping (value = "/**", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody Set<FileEntry> getDirectoryContent(HttpServletRequest request) throws UnsupportedEncodingException {
        String url = request.getRequestURI();
        String pathToDirectory = URLDecoder.decode(url, "UTF-8").substring(6); // removing beginning part of url "/rest/"

        return browseService.readDirectory(pathToDirectory);
    }
}
