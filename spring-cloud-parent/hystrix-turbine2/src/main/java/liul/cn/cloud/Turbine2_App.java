package liul.cn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@SpringBootApplication
public class Turbine2_App {
//http://localhost:8020/turbine.stream?cluster=CONSUMER-MOVIE-RIBBON-WITH-HYSTRIX2 可配合dashboard使用
	public static void main(String[] args) {
	    SpringApplication.run(Turbine2_App.class, args);
	}

}
