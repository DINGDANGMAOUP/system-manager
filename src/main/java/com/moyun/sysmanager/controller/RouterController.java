package com.moyun.sysmanager.controller;

import com.moyun.sysmanager.common.pojo.RoleDto;
import com.moyun.sysmanager.common.pojo.RouterDto;
import com.moyun.sysmanager.common.result.VueResult;
import com.moyun.sysmanager.domainswitcher.entity.Meta;
import com.moyun.sysmanager.domainswitcher.entity.Roles;
import com.moyun.sysmanager.domainswitcher.entity.Routers;
import com.moyun.sysmanager.domainswitcher.service.IMetaService;
import com.moyun.sysmanager.domainswitcher.service.IRolesService;
import com.moyun.sysmanager.domainswitcher.service.IRoutersService;
import org.dozer.Mapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/** @author dzh */
@RestController
@RequestMapping("router")
public class RouterController {
  @Resource IMetaService metaService;
  @Resource IRoutersService routersService;
  @Resource IRolesService rolesService;
  @Resource Mapper dozerMapper;

  @PostMapping("add")
  @Transactional
  public VueResult listRouters(@RequestBody RouterDto routerDto) {
    Routers router = dozerMapper.map(routerDto, Routers.class);
    Meta meta = dozerMapper.map(routerDto.getMeta(), Meta.class);
    List<RoleDto> list = routerDto.getMeta().getRoles();
    List<Roles> roles=new ArrayList<>();
    list.forEach(roleDto -> roles.add(dozerMapper.map(roleDto,Roles.class)));
    routersService.save(router);
    metaService.save(meta);
    rolesService.saveBatch(roles);
    return VueResult.success(router.getId());
  }
}
