package alvion.controller;

import alvion.service.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private FileManagerService fileManagerService;

    @RequestMapping(method = RequestMethod.GET)
	public ModelAndView printWelcome() {

        ModelAndView model = new ModelAndView("hello");
		model.addObject("fileList", fileManagerService.showCurrentDir());
		return model;

	}

    @RequestMapping(value = "/folder/{name}", method = RequestMethod.GET)
    public ModelAndView folder(@PathVariable String name) {

        ModelAndView model = new ModelAndView("hello");
        if ( name !=null && !name.isEmpty() )
        {
            fileManagerService.changeFolder( name);
        }

        model.addObject("fileList", fileManagerService.showCurrentDir());
        return model;

    }

/*
    @RequestMapping(value = "up}", method = RequestMethod.GET)
    public ModelAndView up() {

        ModelAndView model = new ModelAndView("hello");
        fileManagerService.changeFolder("..");
        model.addObject("fileList", fileManagerService.showCurrentDir());
        return model;

    }*/


    @RequestMapping(value = "list/{name}", method = RequestMethod.GET)
    public ModelAndView list(@PathVariable String name) {

        ModelAndView model = new ModelAndView("list");
        List<String> list = new ArrayList<>();
        list.add("String 1");
        list.add("String 2");
        list.add("String 3");
        list.add(name);
        model.addObject("list", list);
        return model;

    }
}