package com.springcloud.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xieshuai
 */
@SpringBootApplication
@MapperScan(basePackages={"com.springcloud.provider.**.dao"})
public class ProviderApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProviderApplication.class, args);
  }

}
