package startup;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@SpringBootApplication
@ComponentScan({"com.yzd.shiro.web.api","com.yzd.shiro.db","com.yzd.shiro.service"})
@MapperScan("com.yzd.shiro.db.dao.mapper")
public class Application4WebApi {

    public static void main(String[] args) {
        SpringApplication.run(Application4WebApi.class, args);
    }
}