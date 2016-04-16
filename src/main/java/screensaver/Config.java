package screensaver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
import java.util.Random;

/**
 * Spring Java configuration.
 *
 * Created by dkorolev on 4/16/2016.
 */
@Configuration
@ComponentScan(basePackages = "screensaver")
public class Config {

    @Bean
    public Color color() {
        Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
}
