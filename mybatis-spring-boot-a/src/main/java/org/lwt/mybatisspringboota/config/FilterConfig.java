package org.lwt.mybatisspringboota.config;

import java.util.ArrayList;
import java.util.List;

import org.lwt.mybatisspringboota.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.WebStatFilter;
/**
 * 添加第三方Filter
 * @author Administrator
 *
 */
@Configuration
public class FilterConfig {
  
  /*@Bean
  public FilterRegistrationBean myFilter() {
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    MyFilter myFilter = new MyFilter();
    filterRegistrationBean.setFilter(myFilter);
    List<String> urls = new ArrayList<>();
    urls.add("/*");
    filterRegistrationBean.setUrlPatterns(urls);
    filterRegistrationBean.addInitParameter("exclusions", "/*.js,/*.gif,/*.jpg,/*.bmp,/*.png,/*.css,/*.ico,/druid/*");
    filterRegistrationBean.setName("myfilter..");
    return filterRegistrationBean;
  }*/
  
  @Bean
  public FilterRegistrationBean webStatFilter() {
    System.err.println("注册webStatFilter...");
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    WebStatFilter webStatFilter = new WebStatFilter();
    filterRegistrationBean.setFilter(webStatFilter);
    List<String> urls = new ArrayList<>();
    urls.add("/*");
    filterRegistrationBean.setUrlPatterns(urls);
    filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
    filterRegistrationBean.setName("webStatFilter");
    return filterRegistrationBean;
  }
}
