package liul.cn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy //enablezuulserver是纯净的zuul没有添加任何filter 所有功能都得自己实现
public class Zuul_App {

	public static void main(String[] args) {
	    SpringApplication.run(Zuul_App.class, args);
	}
	  @Bean
	  public PreZuulFilter preZuulFilter() {
	    return new PreZuulFilter();
	  }
}
