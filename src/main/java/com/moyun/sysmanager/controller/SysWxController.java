package com.moyun.sysmanager.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.moyun.sysmanager.common.annotation.Log;
import com.moyun.sysmanager.common.pojo.*;
import com.moyun.sysmanager.common.result.Result;
import com.moyun.sysmanager.common.result.VueResult;
import com.moyun.sysmanager.domainswitcher.entity.TabDomain;
import com.moyun.sysmanager.domainswitcher.entity.TabDomainInUse;
import com.moyun.sysmanager.domainswitcher.service.*;
import com.moyun.sysmanager.exception.CustmerException;
import com.moyun.sysmanager.utils.ObjToMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("sysWx")
@Validated
public class SysWxController extends BaseController {

  private static final String WXURLRE = "http://ha.quming.online/dws/domain/domains/inside";
  //  private static final String WXURLUP = "http://mytest.my9v.top/wechatrobot/wx/domain/update";
  private static final String WXURLUP = "http://mdk.ufuns.cn/wxserver/wx/domain/update";
  //  private static final String WXURLUPBAK = "http://my9f.top/shortLink/updateDomainName";
  private static final String WXURLUPBAK = "http://mdk.ufuns.cn/shortLink/updateDomainName";
  // 使用中的域名表
  @Resource TabDomainInUseService TDIService;
  // 域名表
  @Resource TabDomainService TDService;
  @Autowired
  RestTemplate restTemplate;

@GetMapping("list")
public VueResult findAll(@RequestParam(value = "serviceTypeId", defaultValue = "1") Integer serviceTypeId){
  UsingDomain uDomain = TDIService.findByUsing(serviceTypeId);
  uDomain.setUsing(true);
  List<UsingDomain> Domains = TDService.findBySpare(serviceTypeId, uDomain.getId());
  Domains.forEach(usingDomain -> usingDomain.setUsing(false));
  ArrayList<UsingDomain> result = new ArrayList<>();
  result.add(uDomain);
  result.addAll(Domains);
  return VueResult.success(result);
}
  @RequiresAuthentication
  @Log("微信高可用：启用域名")
  @ResponseBody
  @PostMapping("/enable")
  @Transient
  public VueResult enable(@RequestBody UsingDomain usingDomain) {

    TabDomain tabDomain = new TabDomain();
    tabDomain.setId(usingDomain.getId());
    tabDomain.setState(1);
    TDService.updateById(tabDomain);
    return VueResult.success();
  }
  @RequiresAuthentication
  @Log("微信高可用：停止域名")
  @ResponseBody
  @PostMapping("/disable")
  @Transient
  public VueResult disable(@RequestBody UsingDomain usingDomain) {
    TabDomain tabDomain = new TabDomain();
    tabDomain.setId(usingDomain.getId());
    tabDomain.setState(0);
    TDService.updateById(tabDomain);
    return VueResult.success();
  }

  @RequiresAuthentication
  @Log("微信高可用：切换域名")
  @ResponseBody
  @PostMapping("/switch")
  @Transient
  public VueResult BySwitch(@RequestBody UsingDomain usingDomain) {
//    String url1="http://27.159.82.162:10135/dws/domain/createWxShortUrl?url="+usingDomain.getDomain();
//    String url2=url1+"/qm/pay.php";
//    ShortUrlDto shortUrlDto1 = restTemplate.getForObject(url1, ShortUrlDto.class);
//    ShortUrlDto shortUrlDto2 = restTemplate.getForObject(url2, ShortUrlDto.class);
    Integer serviceTypeId = usingDomain.getServiceTypeId();
    UsingIdDto usingIdDto = TDService.findByUsingId(serviceTypeId);
    TabDomainInUse inUse = new TabDomainInUse();
    inUse.setId(usingIdDto.getId());
    inUse.setDomainId(usingDomain.getId());
    TabDomain tabDomain = new TabDomain();
    tabDomain.setId(usingDomain.getId());
    tabDomain.setState(1);
//    tabDomain.setWxShortUrl(shortUrlDto1.getShortUrl());
//    tabDomain.setWxShortUrlTwo(shortUrlDto2.getShortUrl());
    if (serviceTypeId==1||serviceTypeId==5||serviceTypeId==6){
      RestemplateDto forObject = restTemplate.getForObject(WXURLRE, RestemplateDto.class);
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      JSONObject obj = new JSONObject();
      obj.putAll(ObjToMap.change(forObject));
      HttpEntity<JSONObject> httpEntity = new HttpEntity<>(obj,headers);
      restTemplate.exchange(WXURLUP, HttpMethod.POST,httpEntity,JSONObject.class);
    }
    if (serviceTypeId==3||serviceTypeId==4){
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
      MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
      DomainUsDto domainUsDto= TDIService.findUsingAtDomain(usingDomain.getServiceTypeId());
      params.add("oldDomainName",domainUsDto.getDomain());
      params.add("newDomainName",usingDomain.getDomain());
      HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(params,headers);
      restTemplate.exchange(WXURLUPBAK, HttpMethod.POST,httpEntity,String.class);
    }
    TDIService.updateById(inUse);
    TDService.updateById(tabDomain);
    return VueResult.success();
  }
  @RequiresAuthentication
  @Log("微信高可用：新增域名")
  @PostMapping("/create")
  @ResponseBody
  @Transactional
  public VueResult createTab(@RequestBody @Valid UsingDomain usingDomain) throws CustmerException {
    try {
      String url1="http://27.159.82.162:10135/dws/domain/createWxShortUrl?url="+usingDomain.getDomain();
      String url2="http://ha.quming.online/dws/domain/createWxShortUrl?url="+usingDomain.getDomain();
      ShortUrlDto shortUrlDto = restTemplate.getForObject(url2, ShortUrlDto.class);
      if (shortUrlDto.getShortUrl().equals(null)){
      shortUrlDto=restTemplate.getForObject(url1, ShortUrlDto.class);
      }
      TabDomain tabDomain = new TabDomain();
      tabDomain.setState(usingDomain.getState());
      tabDomain.setDomain(usingDomain.getDomain());
      tabDomain.setServiceTypeId(usingDomain.getServiceTypeId());
      tabDomain.setWxShortUrl(shortUrlDto.getShortUrl());
      TDService.save(tabDomain);
      if (usingDomain.isUsing()) {
        UsingIdDto usingId = TDService.findByUsingId(usingDomain.getServiceTypeId());
        TabDomainInUse inUse = new TabDomainInUse();
        inUse.setId(usingId.getId());
        inUse.setDomainId(tabDomain.getId());
        TDIService.updateById(inUse);
      }
    } catch (Exception e) {
      throw new CustmerException("参数异常");
    }
    return VueResult.success();
  }

  /**
   * 更新或添加域名，也可启用或停止
   * @param tabDomain
   * @return
   */
  @PostMapping
  public Result update(@RequestBody  @Valid TabDomain tabDomain){
    TDService.saveOrUpdate(tabDomain);
  return Result.success();
  }
  /**
   * 切换正在使用的域名
   */
  @Transient
  public Result cutover(@RequestParam String oldDomain,@RequestParam String newDomain){
    //正在使用的域名
    TabDomain oldDm = TDService
        .getOne(Wrappers.<TabDomain>lambdaQuery().select().eq(TabDomain::getDomain, oldDomain));
    //备用域名
    TabDomain newDm = TDService
        .getOne(Wrappers.<TabDomain>lambdaQuery().select().eq(TabDomain::getDomain, newDomain));

    //切换
    TDIService.update(Wrappers.<TabDomainInUse>lambdaUpdate().set(TabDomainInUse::getDomainId,newDm.getId()).eq(TabDomainInUse::getDomainId,oldDm.getId()));


    return Result.success();
  }
}
