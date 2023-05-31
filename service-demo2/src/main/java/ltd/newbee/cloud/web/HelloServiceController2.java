package ltd.newbee.cloud.web;

import ltd.newbee.cloud.service.HelloService2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tangYz
 * 2023/5/29
 */
@RestController
public class HelloServiceController2 {
    @Resource
    private HelloService2 helloService2;

    @GetMapping("/hello")
    public String hello() {
        return helloService2.getName();
    }
}
