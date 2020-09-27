package com.moyun.sysmanager;

/**
 * @author dzh
 */
public final class Constants {

    public static final String ENCODING = "UTF-8";
    public static final String SERVICE_ID = "sysmamnger";
    /**
     * 创建短链api
     */
    public static final String CREATE_SHORT_CHAIN = "http://ha.quming.online/dws/domain/createWxShortUrl?url={::domain::}";
    public static final String CREATE_SHORT_CHAIN_BAK = "http://27.159.82.162:10135/dws/domain/createWxShortUrl?url={::domain::}";
    /**
     * 获取结果页域名
     *
     * @return
     */
    public static final String GET_RESULTS_PAGE = "http://ha.quming.online/dws/domain/domains/inside";
    /**
     * 更新结果页
     */
    public static final String UPDATE_RESULTS_PAGE = "http://wechatrobot.quming.online/wxserver/wx/domain/update";
    /**
     * 菜单域名高可用更新
     */
    public static final String UPDATE_MENU_PAGE = "http://my9f.top/shortLink/updateDomainName";
    /**
     * 企业投诉订单查询
     */
    public static final String QY = "http://ts.my9a.cn";
    /**
     * 智能取名投诉订单查询
     */
    public static final String FD = "http://fd.jm9t.top";
    private Constants() {
        throw new IllegalStateException("Utility class");
    }
}
