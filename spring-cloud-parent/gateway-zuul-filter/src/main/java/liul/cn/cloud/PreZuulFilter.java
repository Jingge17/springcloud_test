package liul.cn.cloud;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreZuulFilter  extends ZuulFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(PreZuulFilter.class);

	  @Override
	  public boolean shouldFilter() { //是否使用该过滤器
	    return true;
	  }

	  @Override
	  public Object run() {//过滤器主方法
	    HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
	    String host = request.getRemoteHost();
	    PreZuulFilter.LOGGER.info("请求的host:{}", host);
	    return null;
	  }

	  @Override
	  public String filterType() { //过滤器类型有 pre post等
	    return "pre";
	  }

	  @Override
	  public int filterOrder() {//过滤器优先级
	    return 1;
	  }
}
