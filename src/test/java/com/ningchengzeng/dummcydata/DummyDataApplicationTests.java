package com.ningchengzeng.dummcydata;

import com.ningchengzeng.dummydata.DummyDataApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = DummyDataApplication.class)
public class DummyDataApplicationTests {

    @Test
    public void contextLoads() {
        Mono<String> resp = WebClient.create()
                .get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("http")
                        .host("www.baidu.com")
                        .path("/s")
                        .queryParam("wd", "北京天气")
                        .queryParam("other", "test")
                        .build())
                .retrieve()
                .bodyToMono(String.class);
        System.out.println();
    }
}
