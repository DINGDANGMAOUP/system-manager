package com.moyun.sysmanager.controller;

import com.moyun.sysmanager.common.annotation.Log;
import com.moyun.sysmanager.common.pojo.OrderDto;
import com.moyun.sysmanager.common.result.VueEnum;
import com.moyun.sysmanager.common.result.VueResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author dzh
 */
@RestController
@RequestMapping("order")
public class OrderController extends BaseController {

  //    private static final String QY="http://dictapi.quming.tech/qiyename1/qiyeOrderId?orderId=";
  private static final String QY = "http://ts.my9a.cn";
  private static final String FD = "http://fd.jm9t.top";
  @Resource
  RestTemplate restTemplate;

  /**
   * 企业订单
   *
   * @param orderId
   * @return
   */
  @Log("查询企业取名订单")
  @RequiresAuthentication
  @GetMapping("qy")
  public VueResult list(String orderId) {
    try {
      String trim = orderId.trim();
      logger.info(orderId);
      if (StringUtils.isBlank(trim)) {
        return VueResult.orderNull();
      }
      String url = QY + "/complain/detail/orderId/" + trim;
      OrderDto orderDto = restTemplate.getForObject(url, OrderDto.class);
      logger.info(orderDto.getInfo().toString());
      return VueResult.success(orderDto.getInfo());
    } catch (RestClientException e) {
      return VueResult.of(VueEnum.ORDERID_NULL);
    }
  }

  @Log("退款企业取名订单")
  @RequiresAuthentication
  @GetMapping("qy/refund")
  public VueResult Refund(@RequestParam("order_id") String orderId) {
    try {
      String trim = orderId.trim();
      String url = QY + "/complain/refund/orderId/" + trim;
      HashMap<String, String> param = new HashMap<>(5);
      param.put("orderId", orderId);
      restTemplate.put(url, param);
      logger.info("订单：" + orderId + "退款成功");
      return VueResult.success();
    } catch (RestClientException e) {
      logger.error("订单：" + orderId + ",退款失败");
      return VueResult.of(VueEnum.REFUND_FAIL);
    }
  }

  /**
   * 智能取名测名
   */
  @Log("查询智能取名订单")
  @RequiresAuthentication
  @GetMapping("fd")
  public VueResult listByFd(String orderId) {
    try {
      String trim = orderId.trim();
      logger.info(trim);
      if (StringUtils.isEmpty(trim)) {
        return VueResult.orderNull();
      }
      String url = FD + "/index.php?orderId=" + trim;
      List orderDto = restTemplate.getForObject(url, List.class);
      logger.info(orderDto.toString());
      return VueResult.success(orderDto);
    } catch (RestClientException e) {
      return VueResult.of(VueEnum.ORDERID_NULL);
    }
  }

  @Log("退款智能取名订单")
  @RequiresAuthentication
  @GetMapping("fd/refund")
  public VueResult RefundByFd(@RequestParam("order_id") String orderId) {
    try {
      String trim = orderId.trim();
      String url = FD + "/updatepay.php?orderId=" + trim + "&payStatus=0";
      restTemplate.getForObject(url, Object.class);
      logger.info("订单：" + orderId + "退款成功");
      return VueResult.success();
    } catch (RestClientException e) {
      logger.error("订单：" + orderId + ",退款失败");
      return VueResult.of(VueEnum.REFUND_FAIL);
    }
  }
}
