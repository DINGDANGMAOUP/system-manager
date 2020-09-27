package com.moyun.sysmanager.controller;

import com.moyun.sysmanager.common.pojo.RoleDTO;
import com.moyun.sysmanager.common.pojo.RouterDTO;
import com.moyun.sysmanager.common.pojo.Tree;
import com.moyun.sysmanager.common.result.VueResult;
import com.moyun.sysmanager.domainswitcher.entity.Meta;
import com.moyun.sysmanager.domainswitcher.entity.Roles;
import com.moyun.sysmanager.domainswitcher.entity.Routers;
import com.moyun.sysmanager.domainswitcher.service.IMetaService;
import com.moyun.sysmanager.domainswitcher.service.IRolesService;
import com.moyun.sysmanager.domainswitcher.service.IRoutersService;
import com.moyun.sysmanager.utils.TreeBuilderUtil;
import org.dozer.Mapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dzh
 */
@RestController
@RequestMapping("router")
public class RouterController extends BaseController {
    @Resource
    IMetaService metaService;
    @Resource
    IRoutersService routersService;
    @Resource
    IRolesService rolesService;
    @Resource
    Mapper dozerMapper;

    @PostMapping("add")
    @Transactional
    public VueResult createRouters(@RequestBody RouterDTO routerDto) {
        Routers router = dozerMapper.map(routerDto, Routers.class);
        Meta meta = dozerMapper.map(routerDto.getMeta(), Meta.class);
        List<RoleDTO> list = routerDto.getMeta().getRoles();
        List<Roles> roles = new ArrayList<>();
        list.forEach(roleDto -> roles.add(dozerMapper.map(roleDto, Roles.class)));
        routersService.save(router);
        metaService.save(meta);
        rolesService.saveBatch(roles);
        return VueResult.success(router.getId());
    }
  @PostMapping("list")
  @Transactional
  public VueResult listRouters() {
    List<Routers> routers = routersService.list();
    List<Routers> parentNode = routers.stream().filter(routers1 -> routers1.getParentId() == null).collect(Collectors.toList());
    List<Routers> childNode = routers.stream().filter(routers1 -> routers1.getParentId() != null).collect(Collectors.toList());
    List<Tree> trees = new ArrayList<>();
    trees= TreeBuilderUtil.builder(parentNode,childNode,trees);


    return VueResult.success(trees);
  }
}
