package com.moyun.sysmanager.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** @author kueoneko */
public class ObjToMap {

  public static Map<String, Object> change(Object obj) {
    return Arrays.stream(BeanUtils.getPropertyDescriptors(obj.getClass()))
        .filter(pd -> !"class".equals(pd.getName()))
        .collect(
            HashMap::new,
            (map, pd) ->
                map.put(pd.getName(), ReflectionUtils.invokeMethod(pd.getReadMethod(), obj)),
            HashMap::putAll);
  }
}
