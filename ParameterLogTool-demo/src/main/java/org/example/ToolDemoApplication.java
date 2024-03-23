package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @describe:
 * @Author Cary
 * @Date 2024/3/18
 **/
@SpringBootApplication
public class ToolDemoApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ToolDemoApplication.class);
        application.run(args);
    }

}
