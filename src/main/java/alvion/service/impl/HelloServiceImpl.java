package alvion.service.impl;

import alvion.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String helloMessage(){
        return "Spring MVC Hello World.";
    }
}
