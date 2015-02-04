package alvion.controller;

import alvion.service.FolderService;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/dirviewer/")
public class FileController {

    @Autowired
    private FolderService folderService;
    
    @RequestMapping(value = "**", method = RequestMethod.GET)
    public ModelAndView list(HttpServletRequest request) throws UnsupportedEncodingException {
        String dir = request.getRequestURI();
        dir = URLDecoder.decode(dir, "UTF-8");
        dir = dir.substring(21);
        
        ModelAndView model = new ModelAndView("dirviewer");
        try {
            folderService.setFolder("/".concat(dir));
            model.addObject("parentFolder", folderService.getParentFolderName());
            model.addObject("currentFolder", folderService.getFolderName());
            model.addObject("folderContent", folderService.getFolderContent());
        } catch (FileNotFoundException ex) {
            model.setViewName("dirviewer404");
        }
		return model;
	}
}