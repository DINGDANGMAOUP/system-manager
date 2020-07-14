package com.moyun.sysmanager.domainswitcher.service.impl;

import com.moyun.sysmanager.domainswitcher.entity.DSTabShortUrl;
import com.moyun.sysmanager.domainswitcher.mapper.DSTabShortUrlMapper;
import com.moyun.sysmanager.domainswitcher.service.DSTabShortUrlService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/** @author kuroneko */
@Service
public class DSTabShortUrlServiceImpl extends ServiceImpl<DSTabShortUrlMapper, DSTabShortUrl>
    implements DSTabShortUrlService {}
