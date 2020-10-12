package com.moyun.sysmanager.utils;

import com.moyun.sysmanager.common.pojo.Tree;
import com.moyun.sysmanager.domainswitcher.entity.Routers;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/** @author dzh */
@Slf4j
public class TreeBuilderUtil {
  public static List<Tree> builder(
      List<Routers> parentNode, List<Routers> childNode, List<Tree> trees) {
    // TODO: 2020/9/8 遍历子路由
    childNode.forEach(
        // TODO: 2020/9/8 遍历父级路由，并将相应的子路由对应
        routers -> {
          parentNode.forEach(
              routersChild -> {
                if (StringUtils.equals(routers.getParentId(), routersChild.getId())) {
                  /// TODO: 2020/9/8 构建树
                  ArrayList<Tree> child = new ArrayList<>();

                  child.add(
                      new Tree()
                          .setId(routers.getId())
                          .setPath(routers.getPath())
                          .setComponent(routers.getComponent())
                          .setName(routers.getName())
                          .setMetaId(routers.getMetaId())
                          .setHidden(routers.getHidden())
                          .setRedirect(routers.getRedirect())
                          .setAlwaysShow(routers.getAlwaysShow()));
                  trees.add(
                      new Tree()
                          .setId(routersChild.getId())
                          .setPath(routersChild.getPath())
                          .setComponent(routersChild.getComponent())
                          .setName(routersChild.getName())
                          .setMetaId(routersChild.getMetaId())
                          .setHidden(routersChild.getHidden())
                          .setRedirect(routersChild.getRedirect())
                          .setAlwaysShow(routersChild.getAlwaysShow())
                          .setChildren(child));
                }
                log.info(routers.toString());
                log.info(routersChild.toString());
                log.info("success");
                log.info(trees.toString());
              });
        });
    return trees;
  }
}
