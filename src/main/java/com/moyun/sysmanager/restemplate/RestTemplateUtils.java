package com.moyun.sysmanager.restemplate;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class RestTemplateUtils {
  public static final RestTemplate REST_TEMPLATE;
  /** json */
  private static final HttpHeaders HEADERSJ;
  /** form-data */
  private static final HttpHeaders HEADERSF;

  static {
    HttpComponentsClientHttpRequestFactory httpRequestFactory =
        new HttpComponentsClientHttpRequestFactory(
            HttpClientBuilder.create().setMaxConnTotal(200).setMaxConnPerRoute(100).build());
    httpRequestFactory.setConnectionRequestTimeout(100000);
    httpRequestFactory.setConnectTimeout(100000);
    httpRequestFactory.setReadTimeout(100000);
    REST_TEMPLATE = new RestTemplate(httpRequestFactory);

    HEADERSJ = new HttpHeaders();
    HEADERSJ.setContentType(MediaType.APPLICATION_JSON_UTF8);

    HEADERSF = new HttpHeaders();
    HEADERSF.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
  }

  public static String get(String url) {
    return REST_TEMPLATE.getForObject(url, String.class);
  }

  public static String request(String url, HttpMethod method) {
    return REST_TEMPLATE
        .exchange(url, method, new HttpEntity<String>(HEADERSJ), String.class)
        .getBody();
  }

  /**
   * header为：json
   *
   * @param url
   * @param requestParams
   * @return
   * @throws Exception
   */
  public static String postForJSON(String url, Object requestParams) throws Exception {
    HttpEntity<Object> formEntity =
        new HttpEntity<>(JSONObject.toJSONString(requestParams), HEADERSJ);
    String responseJson;
    try {
      responseJson = REST_TEMPLATE.postForObject(url, formEntity, String.class);
    } catch (Exception e) {
      throw e;
    }
    return responseJson;
  }

  /**
   * post表单请求
   *
   * @param url
   * @param map
   * @return
   */
  public static String postFormData(String url, Map<String, String> map) {
    MultiValueMap<String, String> reqMap = new LinkedMultiValueMap<>();
    for (Map.Entry<String, String> entry : map.entrySet()) {
      reqMap.add(entry.getKey(), entry.getValue());
    }
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    String res;
    try {
      HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(reqMap, headers);
      ResponseEntity<String> response = REST_TEMPLATE.postForEntity(url, request, String.class);
      res = response.getBody();
    } catch (Exception e) {
      throw e;
    }
    return res;
  }

  /**
   * header为：form-data
   *
   * @param url
   * @param requestParams
   * @return
   * @throws Exception
   */
  public static JSONObject postForForm(String url, Map<String, ? extends Object> requestParams)
      throws Exception {
    LinkedMultiValueMap body = new LinkedMultiValueMap();
    for (String key : requestParams.keySet()) {
      body.add(key, requestParams.get(key));
    }
    HttpEntity<String> entity = new HttpEntity(body, HEADERSF);
    JSONObject responseJson;
    try {
      responseJson = REST_TEMPLATE.postForObject(url, entity, JSONObject.class);
    } catch (Exception e) {
      throw e;
    }
    return responseJson;
  }
}
