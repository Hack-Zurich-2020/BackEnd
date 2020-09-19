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
}
