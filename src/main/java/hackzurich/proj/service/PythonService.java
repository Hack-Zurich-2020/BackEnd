package hackzurich.proj.service;

import hackzurich.proj.config.MainConfig;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.List;

@Service
@AllArgsConstructor
public class PythonService {
    private MainConfig mainConfig;
    private static final String INIT = "import sys";
    public static final String PYTHON = "python ";

    @PostConstruct
    public void initPythonScript() throws IOException {
        BufferedWriter out = new BufferedWriter(new FileWriter(mainConfig.getPythonDietPath()));
        out.write(INIT);
        out.close();
    }

    public String getFoodCategories(String healthParams) throws IOException {
        String command = PYTHON + mainConfig.getPythonDietPath() + " 3 4";
        Process p = Runtime.getRuntime().exec(command);
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String ret = in.readLine();
        return ret;
    }
}
