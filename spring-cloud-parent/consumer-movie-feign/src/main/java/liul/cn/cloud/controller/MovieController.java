package liul.cn.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import liul.cn.cloud.entity.User;
import liul.cn.cloud.feign.UserFeignClient;

@RestController
public class MovieController {
	  @Autowired
	  private UserFeignClient userFeignClient;

	  @GetMapping("/movie/{id}")
	  public User findById(@PathVariable Long id) {
		  return this.userFeignClient.findById(id);
	  }
}
