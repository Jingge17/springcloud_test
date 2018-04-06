package liul.cn.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
 
/**
 * unable to find valid certification path to requested target （jdk的ssl证书认证问题）
 * 解决方法：https://blog.csdn.net/frankcheng5143/article/details/52164939
 * 
 * 访问路径
 * 
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 * 
 * label:分支 application：文件名 profile：git仓库文件环境参数
 * 
 * ex：/{label}/{application}-{profile}.yml  --》1.http://localhost:8080/master/foobar-dev.yml  2.http://localhost:8080/master/abc-default.properties  //未找到文件如abc则使用application.yml文件
 * 
 */

@SpringBootApplication
@EnableConfigServer
public class Config_Server_App {

	public static void main(String[] args) {
	    SpringApplication.run(Config_Server_App.class, args); 
	}

}
