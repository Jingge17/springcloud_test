package liul.cn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@SpringBootApplication
public class Turbine_App {
//http://localhost:8020/turbine.stream?Cluster=CONSUMER-MOVIE-RIBBON 可配合dashboard使用
	public static void main(String[] args) {
	    SpringApplication.run(Turbine_App.class, args);
	}

}
