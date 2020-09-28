package com.moyun.sysmanager;

/**
 * @author dzh
 */
public final class Constants {


    public static final String ENCODING = "UTF-8";
    public static final String SERVICE_ID = "sysmamnger";
    /**
     * 日期格式
     */
    public static final String FULL_TIME_PATTERN = "yyyyMMddHHmmss";
    public static final String FULL_TIME_SPLIT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /**
     * 响应状态码
     */
    public static final int CODE_SUCCESS=200;
    /**
     * 服务对应serviceTypeId
     * 取名-RESURL:1
     * 取名菜单-OLQM:3
     * 大师菜单-MSTR:4
     * 大师-NEWONLINEMASTER:5
     * 测名-TESTURL:6
     */
    public static final int RESURL = 1;
    public static final int OLQM = 3;
    public static final int MSTR = 4;
    public static final int NEWONLINEMASTER = 5;
    public static final int TESTURL = 6;
    /**
     * 取名测名结果页前缀
     * OLRSO：olrso.ha.my9b.cn [125.77.158.157]
     * OLRS：olrs.ha.my9b.cn [117.24.13.147]
     */
    public static final String OLRSO = "olrso";
    public static final String OLRS = "olrs";
    /**
     * 创建短链api
     */
    public static final String CREATE_SHORT_CHAIN = "http://ha.quming.online/dws/domain/createWxShortUrl?url={::domain::}";
    public static final String CREATE_SHORT_CHAIN_BAK = "http://27.159.82.162:10135/dws/domain/createWxShortUrl?url={::domain::}";
    /**
     * 获取结果页域名
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
    /**
     * 正则匹配
     * DOMAIN:域名正则
     * PHONE:手机号正则
     */
    public static final String DOMAIN="^(?=^.{3,255}$)(http(s)?:\\/\\/)?(www\\.)?[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+(:\\d+)*(\\/\\w+\\.\\w+)*$";
    public static final String PHONE="^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";
    private Constants() {
        throw new IllegalStateException("Utility class");
    }
}
