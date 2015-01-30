package alvion.controller;

import alvion.model.FolderWalker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by dma on 1/28/15.
 */
@Controller
@RequestMapping("/")
public class FolderWalkerController {
    private FolderWalker folderWalker;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView init() {
        if (folderWalker == null) {
            folderWalker = new FolderWalker("C:\\");
        }
        return new ModelAndView("folders").addObject("fw", folderWalker);
    }

    @RequestMapping(value = "item", method = RequestMethod.GET)
    public ModelAndView list(@RequestParam(value = "folder") String folder) {
        folderWalker.walkInto(folder);
        return new ModelAndView("folders").addObject("fw", folderWalker);
    }

    @RequestMapping(value = "back", method = RequestMethod.GET)
    public ModelAndView back() {
        folderWalker.walkUp();
        return new ModelAndView("folders").addObject("fw", folderWalker);
    }

    @RequestMapping(value = "curr", method = RequestMethod.GET)
    public ModelAndView moveTo(@RequestParam(value = "idx") int idx) {
        folderWalker.walkTo(idx);
        return new ModelAndView("folders").addObject("fw", folderWalker);
    }

}
