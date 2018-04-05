package liul.cn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class Zuul_Reg_Exp_App {

	public static void main(String[] args) {
	    SpringApplication.run(Zuul_Reg_Exp_App.class, args);
	}
	
	  @Bean
	  public PatternServiceRouteMapper serviceRouteMapper() {//zuul正则表达式访问路径为http://localhost:8030/v12/provider-user/simple/1 服务名为provider-user-v12
	    return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
	  }

}
