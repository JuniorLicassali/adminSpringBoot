package com.news.login.servico.autenticacao;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class LoginInterceptorAppConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LoginInterceptor())
        .excludePathPatterns(
        
         "/registrar",
         "/registrar/criar",
         "/login",
         "/error",
         "/logar",
         "/img/**",
         "/vendor/**",
         "/js/**",
         "/favicon.ico",
         "/css/**"
        );
  }
}
