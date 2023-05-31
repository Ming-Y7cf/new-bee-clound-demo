package ltd.newbee.cloud.web;

import ltd.newbee.cloud.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tangYz
 * 2023/5/29
 */
@RestController
public class HelloServiceController {
    @Resource
    private HelloService helloService;

    @GetMapping("/hello")
    public String hello() {
        return helloService.getName();
    }
}
