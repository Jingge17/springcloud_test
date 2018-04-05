package liul.cn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication//至扫描同级包与子包
@EnableEurekaClient
@RibbonClient(name = "provider-user", configuration = RibbonRandomCfg.class)//ribbon为注册中心的provider-user提供者负载均衡策略
@ComponentScan(excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class) })//扫描排除带有@ExcludeFromComponentScan注解的类
public class C_Movie_Ribbon_App {
	  @Bean
	  @LoadBalanced//ribbon消费端负载均衡
	  public RestTemplate restTemplate() {
	    return new RestTemplate();
	  }

	  public static void main(String[] args) {
	    SpringApplication.run(C_Movie_Ribbon_App.class, args);
	  }

}
