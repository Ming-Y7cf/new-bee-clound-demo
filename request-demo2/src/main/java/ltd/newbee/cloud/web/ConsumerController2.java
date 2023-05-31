package ltd.newbee.cloud.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author tangYz
 * 2023/5/29
 */

@RestController
public class ConsumerController2 {

    private final String SERVICE_URL = "http://localhost:8081";
    //private final String SERVICE_URL = "http://localhost:8082";

    private WebClient webClient = WebClient.builder()
            .baseUrl(SERVICE_URL)
            .build();

    /**
     * 使用WebClient处理http请求
     * @return
     */
    @GetMapping("/webClientTest")
    public String webClientTest() {
        Mono<String> mono = webClient
                .get() // GET 请求方式
                .uri("/hello")  // 请求地址
                .retrieve() // 获取响应结果
                .bodyToMono(String.class); //响应结果转换

        mono.subscribe(System.out::println);
        return "请求成功";
    }
}
