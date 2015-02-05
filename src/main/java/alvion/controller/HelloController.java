package alvion.controller;

import alvion.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(method = RequestMethod.GET)
	public ModelAndView printWelcome() {
        ModelAndView model = new ModelAndView("hello");
		model.addObject("message", helloService.helloMessage());
		return model;

	}

    @RequestMapping(value = "list/**", method = RequestMethod.GET)
    public ModelAndView list(@PathVariable String name, HttpServletRequest request) {

        ModelAndView model = new ModelAndView("list");
        List<String> list = new ArrayList<>();
        list.add("String 1");
        list.add("String 2");
        list.add("String 3");
        list.add(name);
        model.addObject("list", list);
        return model;

    }

    @RequestMapping(value = "rest", method = RequestMethod.GET)
    public @ResponseBody String restString(HttpServletRequest request) {
        String message = "Hello REST";
        return message;
    }

    @RequestMapping(value = "rest/json", method = RequestMethod.GET)
    public @ResponseBody List<JsonObject> restJson(HttpServletRequest request) {

        List<JsonObject> objects = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            JsonObject obj = new JsonObject();
            obj.setName("Joe" + i);
            obj.setValue(33 + i);
            objects.add(obj);
        }

        return objects;
    }

}