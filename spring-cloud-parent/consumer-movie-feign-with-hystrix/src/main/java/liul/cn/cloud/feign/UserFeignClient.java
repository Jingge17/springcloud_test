package liul.cn.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import liul.cn.cloud.entity.User;

@FeignClient(name="provider-user", fallback = HystrixClientFallback.class)
public interface UserFeignClient {
  @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
  public User findById(@PathVariable("id") Long id); // 1. @GetMapping不支持   2. @PathVariable得设置value
  // 3. 只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求,可以将对象属性拿出来发送。

}
