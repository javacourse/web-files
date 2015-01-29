package alvion.service.impl;

import alvion.controller.BrowseController;
import alvion.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String helloMessage()
    {
        String appPath = BrowseController.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        StringBuilder testPath = new StringBuilder(appPath.substring(0, appPath.indexOf("target")));
        // removing possible leading slash
        while(testPath.toString().indexOf('/')==0) testPath.deleteCharAt(0);
        return testPath.toString();
    }
}
