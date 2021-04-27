package com.moyun.sysmanager;

import com.alibaba.fastjson.JSONObject;
import com.moyun.sysmanager.domainswitcher.entity.TabDomain;
import com.moyun.sysmanager.utils.ReplacePrefixUtil;
import com.moyun.sysmanager.utils.RestTemplateUtil;
import java.awt.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static com.moyun.sysmanager.Constants.*;


@Slf4j
public class SysmanagerApplicationTest {


    @Test
    public void test() {
    //        log.info("操作时间({})--菜单域名更新成功（切换操作）",
    // DateUtil.formatFullTime(LocalDateTime.now(),FULL_TIME_SPLIT_PATTERN));
    //        String orderId="asdasdasdas";
    //
    // log.info("订单：{}-退款失败-{}",orderId,DateUtil.formatFullTime(LocalDateTime.now(),FULL_TIME_SPLIT_PATTERN));
    //        RestTemplateUtil.getRequest(link_1).getString("shortUrl")
    //        RestTemplate template = new RestTemplate();
    //        String
    // link_1="http://27.159.82.162:10135/dws/domain/createWxShortUrl?url=http://olrs.jm9l.top";
    //        Map map = new HashMap<>();
    //        map.put("url","http://olrs.jm9l.top");
    //        ShortUrlDTO object = template.getForObject(link_1, ShortUrlDTO.class);
    //        log.info(object.toString());
    //        TabDomain domain = tabDomainService.getById(usingIdDto.getId());
    //        JSONObject request = RestTemplateUtil.getRequest(GET_RESULTS_PAGE);
    //        JSONObject object = RestTemplateUtil.getPostJsonRequest(request, UPDATE_RESULTS_PAGE);
    //        log.info(object.toJSONString());
    //        log.info(request);
        ArrayList<LocalDateTime> yes1 = new ArrayList<>();
        ArrayList<LocalDateTime> yes2 = new ArrayList<>();
        ArrayList<LocalDateTime> yes3 = new ArrayList<>();
        ArrayList<LocalDateTime> no = new ArrayList<>();
    for (int i =0 ; i < 24; i++) {
      //
      for (int j = 0; j < 60; j++) {
        //
          LocalDateTime now = LocalDateTime.of(2021,2,24,i,j);
          int hour = now.getHour();
          int minute = now.getMinute();
//          System.out.println(now);
          if (hour==9&&minute>=30){
              yes1.add(now);
          }else if (hour>9&&hour<21){
              yes2.add(now);
          } else if (hour==21&&minute<=30){
              yes3.add(now);
          }else {
             no.add(now);
          }
      }
    }
        log.info("=========================yes1,star==================================");
    yes1.forEach(localDateTime -> log.info(String.valueOf(localDateTime)));
    log.info("=========================yes1,end==================================");
        log.info("=========================yes2,star==================================");
    yes2.forEach(localDateTime -> log.info(String.valueOf(localDateTime)));
    log.info("=========================yes2,end==================================");
        log.info("=========================yes3,star==================================");
        yes3.forEach(localDateTime -> log.info(String.valueOf(localDateTime)));
        log.info("=========================yes3,end==================================");
        log.info("=========================no,star==================================");
    no.forEach(localDateTime -> log.info(String.valueOf(localDateTime)));
        log.info("=========================no,end==================================");
//        LocalDateTime now = LocalDateTime.of(2021,2,24,8,30);
//        int hour = now.getHour();
//        int minute = now.getMinute();
//    System.out.println(now);
//        if (hour>=9&&hour<21&&minute>=30){
//            System.out.println("yes1");
//        }else if (hour==21&&minute<=30){
//            System.out.println("yes2");
//        }else {
//
//            System.out.println("no");
//        }
//    System.out.println(LocalDateTime.now().getHour());
//    System.out.println(LocalDateTime.now().getMinute());
    }

    @Test
    void flag(){
    System.out.println(true&&true&&!true);
    }
}
