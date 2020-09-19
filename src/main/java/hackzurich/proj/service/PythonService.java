package hackzurich.proj.service;

import hackzurich.proj.config.MainConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

@Service
@AllArgsConstructor
public class PythonService {
    private MainConfig mainConfig;
    private static final String INIT = "import sys\nprint int(sys.argv[1])+int(sys.argv[2])\n";

    @PostConstruct
    public void initPythonScript() {
/*
        BufferedWriter out = new BufferedWriter(new FileWriter());
        out.write(prg);
        out.close();
*/
    }

    public String getFoodCategories(String healthParams){
        return "1,2";
    }
}
