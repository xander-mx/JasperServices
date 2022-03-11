package mx.com.bmv.jasperpdfservices;

import mx.com.bmv.jasperpdfservices.utils.YAMLConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
//@EnableJpaRepositories("mx.com.bmv.jasperpdfservices.repositories")
@EnableConfigurationProperties(YAMLConfig.class)
public class JasperPdfServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(JasperPdfServicesApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
