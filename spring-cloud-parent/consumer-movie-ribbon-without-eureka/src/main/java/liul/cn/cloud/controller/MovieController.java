package liul.cn.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import liul.cn.cloud.entity.User;

@RestController
public class MovieController {
	  @Autowired
	  private RestTemplate restTemplate;
	  @Autowired
	  private LoadBalancerClient loadBalancerClient;
	  @GetMapping("/movie/{id}")
	  public User findById(@PathVariable Long id) {
		    ServiceInstance serviceInstance = this.loadBalancerClient.choose("provider-user");
		    System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
	    return this.restTemplate.getForObject("http://provider-user/simple/"+ id, User.class);//负载均衡获取提供者数据
	  }

}
