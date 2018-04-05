package liul.cn.cloud;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class ZullFallBack implements ZuulFallbackProvider{
	@Override
	  public String getRoute() {//调用的服务名
	    return "provider-user";
	  }

	  @Override
	  public ClientHttpResponse fallbackResponse() {//该服务名所对应的fallback方法
	    return new ClientHttpResponse() {
	      @Override
	      public HttpStatus getStatusCode() throws IOException {//状态码 三个是一类东西
	        return HttpStatus.BAD_REQUEST;
	      }

	      @Override
	      public int getRawStatusCode() throws IOException {
	        return HttpStatus.BAD_REQUEST.value();
	      }

	      @Override
	      public String getStatusText() throws IOException {
	        return HttpStatus.BAD_REQUEST.getReasonPhrase();
	      }

	      @Override
	      public void close() {
	      }

	      @Override
	      public InputStream getBody() throws IOException {//内容
	        return new ByteArrayInputStream(("fallback" + ZullFallBack.this.getRoute()).getBytes());
	      }

	      @Override
	      public HttpHeaders getHeaders() {//响应头
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        return headers;
	      }
	    };
	  }
}
