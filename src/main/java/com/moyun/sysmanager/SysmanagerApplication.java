package com.moyun.sysmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dzh
 */
@EnableTransactionManagement
@SpringBootApplication
@Controller
public class SysmanagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SysmanagerApplication.class, args);
  }



}
