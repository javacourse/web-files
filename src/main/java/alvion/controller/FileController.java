package alvion.controller;

import alvion.service.FolderService;
import java.io.FileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dirviewer/")
public class FileController {

    @Autowired
    private FolderService folderService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("dirviewer");
        try {
            folderService.setFolder("/home/elazarchuk");
            model.addObject("parentFolder", folderService.getParentFolderName());
            model.addObject("currentFolder", folderService.getFolderName());
            model.addObject("folderContent", folderService.getFolderContent());
        } catch (FileNotFoundException ex) {
            model.setViewName("dirviewer404");
        }
		return model;
	}
    
    @RequestMapping(value = "list/{dir}", method = RequestMethod.GET)
    public ModelAndView list(@PathVariable String dir) {
        ModelAndView model = new ModelAndView("dirviewer");
        try {
            folderService.setFolder(dir.isEmpty() ? "/" : dir);
            model.addObject("parentFolder", folderService.getParentFolderName());
            model.addObject("currentFolder", folderService.getFolderName());
            model.addObject("folderContent", folderService.getFolderContent());
        } catch (FileNotFoundException ex) {
            model.setViewName("dirviewer404");
        }
		return model;
	}
}