//package com.moyun.sysmanager.restemplate;
//
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Map.Entry;
//import javax.annotation.Resource;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//@Component
//public class RestTemplateClient {
//
//  @Resource private RestTemplate restTemplate;
//
//  @Async
//  public String get(String requestUrl, Map<String, Object> dataValue) {
//    Iterator<Entry<String, Object>> iterator = dataValue.entrySet().iterator();
//    StringBuffer sb = new StringBuffer();
//    sb.append("?");
//    while (iterator.hasNext()) {
//      Map.Entry<String, Object> e = iterator.next();
//      String key = e.getKey();
//      String value = e.getValue() == null ? "" : e.getValue().toString();
//      sb.append(key + "=").append(value).append("&");
//    }
//    String url = sb.toString();
//    url = url.substring(0, url.length() - 1);
//    url = requestUrl + url;
//    return restTemplate.getForObject(url, String.class);
//  }
//}
