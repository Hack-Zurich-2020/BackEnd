package hackzurich.proj.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class MainConfig {
    @Value("${max-distance-km}")
    private int maxDistanceKm;
    @Value("${estimated-time}")
    private int estimatedTime;
    @Value("${python-diet-path}")
    private String pythonDietPath;
}
