package org.lwt.mybatisspringboota.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;

@Configuration
public class ServletConfig {
  
  @Bean
  public ServletRegistrationBean statViewServlet(){
    System.err.println("注册StatViewServlet...");
    ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
    
    StatViewServlet statViewServlet = new StatViewServlet();
    servletRegistrationBean.setServlet(statViewServlet);
    Map<String, String> initParams = new HashMap<>();
    initParams.put("allow", "");
    initParams.put("deny", "");
    initParams.put("loginUsername", "root");
    initParams.put("loginPassword", "123");
    initParams.put("resetEnable", "false");
    servletRegistrationBean.setInitParameters(initParams);
    servletRegistrationBean.addUrlMappings("/druid/*");
    
    return servletRegistrationBean;
  }
}
