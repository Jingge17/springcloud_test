package liul.cn.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import feign.Param;
import feign.RequestLine;
import liul.cn.cloud.entity.User;
import liul.cn.config.Configuration1;

@FeignClient(name="provider-user", configuration = Configuration1.class, fallback = HystrixClientFallback.class)
public interface UserFeignClient {
	  @RequestLine("GET /simple/{id}")
	  public User findById(@Param("id") Long id);
}
