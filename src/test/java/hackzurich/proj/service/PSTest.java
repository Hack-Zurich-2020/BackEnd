package hackzurich.proj.service;

import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PSTest {
    @Autowired
    private PythonService pythonService;

    @Test
    public void pyTest() throws IOException {
        String ans = pythonService.getFoodCategories("abc");
        System.out.println(ans);
    }
}
