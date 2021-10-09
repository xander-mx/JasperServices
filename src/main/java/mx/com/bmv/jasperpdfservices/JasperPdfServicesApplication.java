package mx.com.bmv.jasperpdfservices;

import mx.com.bmv.jasperpdfservices.utils.YAMLConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(YAMLConfig.class)
public class JasperPdfServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(JasperPdfServicesApplication.class, args);
    }

}
