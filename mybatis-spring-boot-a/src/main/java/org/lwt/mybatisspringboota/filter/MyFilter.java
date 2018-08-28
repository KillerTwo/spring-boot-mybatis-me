package org.lwt.mybatisspringboota.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.druid.util.PatternMatcher;
import com.alibaba.druid.util.ServletPathMatcher;

public class MyFilter implements Filter {
  protected PatternMatcher   pathMatcher                       = new ServletPathMatcher();

  private Set<String>        excludesPattern;
  private String contextPath;
  
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println(">>自定义FIlter 的名称是： "+ filterConfig.getFilterName());
    String exclusions = filterConfig.getInitParameter("exclusions");
    excludesPattern = new HashSet<String>(Arrays.asList(exclusions.split("\\s*,\\s*")));
    //System.out.println(excludesPattern);
    
    //System.out.println("不拦截的资源>>"+args);
    //System.out.println("不拦截的资源："+exclusions);
  }
  
  private boolean isExclusion(String requestURI) {
    /*if (contextPath != null && requestURI.startsWith(contextPath)) {
      requestURI = requestURI.substring(contextPath.length());
      if (!requestURI.startsWith("/")) {
          requestURI = "/" + requestURI;
      }
    }*/
    for (String pattern : excludesPattern) {
     // System.out.println("pattern:"+pattern);
      //System.out.println("requestURI"+requestURI);
      if (pathMatcher.matches(pattern, requestURI)) {
          return true;
      }
    }
    return false;
  }
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
     //System.out.println("》》进入filter过滤。。。");
     String requestUrl = httpServletRequest.getRequestURI();
     //requestUrl = requestUrl.substring(1, requestUrl.length());
     //System.out.println("请求地址是："+requestUrl);
     contextPath = httpServletRequest.getContextPath();
     //System.out.println("contextPath:"+contextPath);
     if(isExclusion(requestUrl)) {
       //System.out.println("请求的路径是不需要拦截的。。。");
       chain.doFilter(request, response);
     }
     return ;
  }

  @Override
  public void destroy() {
   

  }

}
