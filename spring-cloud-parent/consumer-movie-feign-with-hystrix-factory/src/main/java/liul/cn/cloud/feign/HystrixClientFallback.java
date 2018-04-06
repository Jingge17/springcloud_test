package liul.cn.cloud.feign;

import org.springframework.stereotype.Component;

import liul.cn.cloud.entity.User;
//UserFeignClient的fallback
@Component
public class HystrixClientFallback implements UserFeignClient {

  @Override
  public User findById(Long id) {
    User user = new User();
    user.setId(0L);
    return user;
  }
}
