package liul.cn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * config-client从config-server中拉取配置信息
 * 
 * bootstrap.yml优先级比application.yml高（先加载启动配置再加载应用配置），并且bootstrap的配置不能被application所覆盖（相同配置以bootstrap为准）
 * 
 * 
 */
@SpringBootApplication
public class Config_Client_App{
  public static void main(String[] args) {
    SpringApplication.run(Config_Client_App.class, args);
  }
}
