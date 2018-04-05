package liul.cn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class P_User_App {

	  public static void main(String[] args) {
	    SpringApplication.run(P_User_App.class, args);
	  }
	
}
