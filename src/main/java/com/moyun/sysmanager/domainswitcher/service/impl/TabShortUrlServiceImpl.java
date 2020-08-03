package com.moyun.sysmanager.domainswitcher.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.moyun.sysmanager.domainswitcher.entity.TabShortUrl;
import com.moyun.sysmanager.domainswitcher.mapper.TabShortUrlMapper;
import com.moyun.sysmanager.domainswitcher.service.TabShortUrlService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
@DS("DS")
public class TabShortUrlServiceImpl extends ServiceImpl<TabShortUrlMapper, TabShortUrl>
    implements TabShortUrlService {}
