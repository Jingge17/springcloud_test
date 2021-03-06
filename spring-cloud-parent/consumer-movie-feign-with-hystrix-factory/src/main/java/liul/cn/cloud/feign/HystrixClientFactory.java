package liul.cn.cloud.feign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;
import liul.cn.cloud.entity.User;
//UserFeignClient的fallbackfactory
@Component
public class HystrixClientFactory implements FallbackFactory<UserFeignClient> {

  private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFactory.class);

  @Override
  public UserFeignClient create(Throwable cause) {
    HystrixClientFactory.LOGGER.info("fallback; reason was: {}", cause.getMessage());
    return new UserFeignClientWithFactory() {
      @Override
      public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        return user;
      }
    };
  }
}
