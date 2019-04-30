package startup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ComponentScan({"com.yzd.shiro.web"})
public class Application4Web {

    public static void main(String[] args) {
        SpringApplication.run(Application4Web.class, args);
    }
}