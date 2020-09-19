package hackzurich.proj.controller;

import hackzurich.proj.util.GenIdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest {
    private RestTemplate restTemplate;

    @Test
    public void foodInquiryTest(){
        System.out.println(GenIdUtil.genId(10));
    }
}
