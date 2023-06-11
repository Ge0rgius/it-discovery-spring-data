package it.discovery.persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@SpringBootApplication
@EnableJdbcAuditing
public class JDBCApplication {

    public static void main(String[] args) {
        SpringApplication.run(JDBCApplication.class, args);
    }
}
