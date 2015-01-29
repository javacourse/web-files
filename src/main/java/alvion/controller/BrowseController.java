package alvion.controller;

import alvion.service.BrowseService;
import alvion.service.HelloService;
import alvion.common.FileEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/")
public class BrowseController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private BrowseService browseService;

    @RequestMapping(method = RequestMethod.GET)
	public ModelAndView printWelcome() {
        String initialPath = FileEntry.cleanPath(helloService.helloMessage());
        // initial read
        browseService.readDirectory(initialPath);

        ModelAndView model = new ModelAndView("hello");
		model.addObject("message", "Directory to start browse");
        model.addObject("pathToBrowse", initialPath);

		return model;

	}

    @RequestMapping(value = "list/{code:[-]?[\\d]+}", method = RequestMethod.GET)
    public ModelAndView list(@PathVariable int code) {

        ModelAndView model = new ModelAndView("list");

        Set<FileEntry> files = browseService.getDirContent(code);
        model.addObject("list", files);

        Map<String,Integer> headDirectories = browseService.getHeadDirectories();
        model.addObject("headDirectories", headDirectories);

        return model;

    }
}