package com.moyun.sysmanager.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

import static com.moyun.sysmanager.utils.DateUtil.FULL_TIME_SPLIT_PATTERN;

/**
 * @author dzh
 */
@Slf4j
public class RestTemplateUtil {
  @Resource
  private static RestTemplate restTemplate = new RestTemplate();

  public static JSONObject getRequest(String url) {

    ResponseEntity<JSONObject> responseEntity = restTemplate.getForEntity(url, JSONObject.class);
    // 判断服务器返回状态码
    serverIsRight(responseEntity);
    return responseEntity.getBody();
  }

  public static JSONObject getPostJsonRequest(JSONObject param, String url) {

    // 设置提交json格式数据
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<JSONObject> request = new HttpEntity<>(param, headers);
    ResponseEntity<JSONObject> responseEntity =
            restTemplate.postForEntity(url, request, JSONObject.class);
    // 判断服务器返回状态码
    serverIsRight(responseEntity);
    return responseEntity.getBody();
  }

  public static JSONObject getPostFormRequest(MultiValueMap param, String url) {

    // 设置表单提交
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(param, headers);
    ResponseEntity<JSONObject> responseEntity =
            restTemplate.postForEntity(url, request, JSONObject.class);
    // 判断服务器返回状态码
    serverIsRight(responseEntity);
    return responseEntity.getBody();
  }

  public static void serverIsRight(ResponseEntity responseEntity) {
    if (responseEntity.getStatusCodeValue() == 200) {
      log.info("服务器请求成功：{}--时间（{}）", responseEntity.getStatusCodeValue(), DateUtil.now(FULL_TIME_SPLIT_PATTERN));
    } else {
      log.info("服务器请求异常：{}--时间（{}）", responseEntity.getStatusCodeValue(), DateUtil.now(FULL_TIME_SPLIT_PATTERN));
    }
  }
}
