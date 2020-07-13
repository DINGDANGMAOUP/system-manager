package com.moyun.sysmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SysmanagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SysmanagerApplication.class, args);
  }

}
