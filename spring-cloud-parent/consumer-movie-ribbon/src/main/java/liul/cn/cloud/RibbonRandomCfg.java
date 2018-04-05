package liul.cn.cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
@ExcludeFromComponentScan//自定义注解 用于排除@SpringBootApplication的扫描，导致全局ribbon策略相同
public class RibbonRandomCfg {
	  @Bean//ribbon负载均衡策略
	  public IRule ribbonRule() {
	    return new RandomRule();
	  }
}
