package alvion.controller;


import alvion.dto.FileDto;
import alvion.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/files/**")
public class FileBrowserController {

    @Autowired
    private FileService fileService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView printFiles(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ModelAndView model = new ModelAndView("files");
        String requestedUrl = request.getServletPath();
        List<FileDto> files = null;

        try {
            files = fileService.getFiles(requestedUrl.replace("/files", ""));
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

        if (requestedUrl.endsWith("/")) {
            requestedUrl = requestedUrl.substring(0, requestedUrl.length() - 1);
        }

        model.addObject("files", files);
        model.addObject("currentUrl", requestedUrl);
        return model;
    }


}
