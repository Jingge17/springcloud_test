package liul.cn.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import liul.cn.cloud.entity.User;

@RestController
public class MovieController {
	  @Autowired
	  private RestTemplate restTemplate;

	  @GetMapping("/movie/{id}")
	//hystrix断路器超时调用findByIdFallback方法,隔离级别有两种分别是semaphore和thread，当超时时semaphore会在同一个线程中执行超时方法，thread会新启一个线程处理
	  @HystrixCommand(fallbackMethod = "findByIdFallback", commandProperties = @HystrixProperty(name = "execution.isolation.strategy", value = "SEMAPHORE"))
	  public User findById(@PathVariable Long id) {
		    return this.restTemplate.getForObject("http://provider-user/simple/" + id, User.class);
		  }
	  

	  public User findByIdFallback(Long id) {//请求超时访问这个方法
	    User user = new User();
	    user.setId(0L);
	    return user;
	  }
}
