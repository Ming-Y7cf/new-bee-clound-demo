package ltd.newbee.cloud.web;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author tangYz
 * 2023/5/29
 */
@RestController
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    private final String SERVICE_URL = "http://localhost:8081";
    //private final String SERVICE_URL = "http://localhost:8082";

    /**
     * 使用HttpClient来处理http请求
     */
    @GetMapping("/httpClientTest")
    public String httpClientTest() {
        CloseableHttpResponse response;
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(SERVICE_URL + "/hello");
            // 执行请求
            response = httpClient.execute(httpGet);
            // 判断返回状态码
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                // 打印请求结果
                System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "请求成功";
    }

    @GetMapping("/restTemplateTest")
    public String restTemplateTest() {
        // 打印请求结果
        System.out.println(restTemplate.getForObject(SERVICE_URL + "/hello", String.class));
        return "请求成功";
    }
}
