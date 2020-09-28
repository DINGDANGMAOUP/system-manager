package com.moyun.sysmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author dzh
 */
@EnableTransactionManagement
@SpringBootApplication
@Controller
@EnableAsync
public class SysmanagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SysmanagerApplication.class, args);
  }



}
