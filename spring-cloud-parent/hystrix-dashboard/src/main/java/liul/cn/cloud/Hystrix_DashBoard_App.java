package liul.cn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringBootApplication
public class Hystrix_DashBoard_App {
//http://localhost:8010/hystrix   用于将单个服务hystrix.stream页面转为可视化页面 或是和turbine配合可视化服务集群运行情况
	public static void main(String[] args) {
	    SpringApplication.run(Hystrix_DashBoard_App.class, args);
	}

}
