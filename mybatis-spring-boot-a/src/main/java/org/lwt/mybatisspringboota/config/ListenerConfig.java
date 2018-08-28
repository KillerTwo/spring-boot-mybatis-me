package org.lwt.mybatisspringboota.config;

import javax.servlet.ServletContextListener;

import org.lwt.mybatisspringboota.listener.MyListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfig {
  @Bean
  public ServletListenerRegistrationBean<ServletContextListener> myListener(){
    System.out.println("添加一个监听器。。。");
    return new ServletListenerRegistrationBean<>(new MyListener());
  }
}
