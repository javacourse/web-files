package alvion.controller;


import alvion.dto.FileDto;
import alvion.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

@Controller
@RequestMapping("/rest")
public class FileBrowserRESTController {

    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/files/**", method = RequestMethod.GET)
    public  @ResponseBody
    List<FileDto> printFiles(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestedUrl = URLDecoder.decode(request.getRequestURI(),"UTF-8");
        List<FileDto> files = null;

        try {
            files = fileService.getFiles(requestedUrl.replace("/rest/files", ""));
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }

        return files;
    }


}
