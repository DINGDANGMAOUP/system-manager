package com.moyun.sysmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableTransactionManagement
@SpringBootApplication
@Controller
public class SysmanagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SysmanagerApplication.class, args);
  }
  @RequestMapping("index")
  public String index(Model model){
    model.addAttribute("welcome","Hello world! 666");
    return "index";
  }
}
