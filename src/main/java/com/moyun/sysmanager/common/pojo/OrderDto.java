package com.moyun.sysmanager.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author dzh
 */
public class OrderDto implements Serializable {

    /**
     * code : 0
     * errMsg :
     * data : {"birthday":"1977-01-31 00:00:00","company_type":"有限责任公司","city":"广州","link":"http://gs.quming8.vip/?qyqmType=QY","trans_id":"2020082422001424520592267690","ua":"Mozilla/5.0 (Linux; Android 10; HMA-AL00; HMSCore 5.0.1.313; GMSCore 20.15.16) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 HuaweiBrowser/10.1.4.301 Mobile Safari/537.36","type":"智能","is_read":1,"pay_status":1,"price":66.8,"first_time":"2020-08-24T17:22:42.000+00:00","channel_no":"2020082422001424520592267690","guide_time":"2020-08-24T16:49:01.000+00:00","fortunetelling_info_id":179,"pay_type":"alipay","id":420,"keyword":"","name_type":"企业","ip":"59.57.163.228","pay_time":"2020-08-24T16:48:45.000+00:00","trade":"广告","read_time":"2020-08-25T15:30:34.000+00:00","wx_oa":"yu517878","phone":"13063086287","addtime":1598258911,"wherefrom":"","phone_time":"2020-08-24T16:49:28.000+00:00","namenum":"三字","fullname":"张文辉","order_id":"QY2020082416483116433","add_time":"2020-08-24T16:48:31.000+00:00"}
     */

    private int code;
    private String errMsg;
    private Data data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @lombok.Data
    public static class Data {
        /**
         * birthday : 1977-01-31 00:00:00
         * company_type : 有限责任公司
         * city : 广州
         * link : http://gs.quming8.vip/?qyqmType=QY
         * trans_id : 2020082422001424520592267690
         * ua : Mozilla/5.0 (Linux; Android 10; HMA-AL00; HMSCore 5.0.1.313; GMSCore 20.15.16) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.108 HuaweiBrowser/10.1.4.301 Mobile Safari/537.36
         * type : 智能
         * is_read : 1
         * pay_status : 1
         * price : 66.8
         * first_time : 2020-08-24T17:22:42.000+00:00
         * channel_no : 2020082422001424520592267690
         * guide_time : 2020-08-24T16:49:01.000+00:00
         * fortunetelling_info_id : 179
         * pay_type : alipay
         * id : 420
         * keyword :
         * name_type : 企业
         * ip : 59.57.163.228
         * pay_time : 2020-08-24T16:48:45.000+00:00
         * trade : 广告
         * read_time : 2020-08-25T15:30:34.000+00:00
         * wx_oa : yu517878
         * phone : 13063086287
         * addtime : 1598258911
         * wherefrom :
         * phone_time : 2020-08-24T16:49:28.000+00:00
         * namenum : 三字
         * fullname : 张文辉
         * order_id : QY2020082416483116433
         * add_time : 2020-08-24T16:48:31.000+00:00
         */

        private String birthday;
        private String company_type;
        private String city;
        private String link;
        private String trans_id;
        private String ua;
        private String type;
        private int is_read;
        private int pay_status;
        private BigDecimal price;
        private String first_time;
        private String channel_no;
        private String guide_time;
        private int fortunetelling_info_id;
        private String pay_type;
        private int id;
        private String keyword;
        private String name_type;
        private String ip;
        private String pay_time;
        private String trade;
        private String read_time;
        private String wx_oa;
        private String phone;
        private int addtime;
        private String wherefrom;
        private String phone_time;
        private String namenum;
        private String fullname;
        private String order_id;
        private String add_time;

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getCompany_type() {
            return company_type;
        }

        public void setCompany_type(String company_type) {
            this.company_type = company_type;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getTrans_id() {
            return trans_id;
        }

        public void setTrans_id(String trans_id) {
            this.trans_id = trans_id;
        }

        public String getUa() {
            return ua;
        }

        public void setUa(String ua) {
            this.ua = ua;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getIs_read() {
            return is_read;
        }

        public void setIs_read(int is_read) {
            this.is_read = is_read;
        }

        public int getPay_status() {
            return pay_status;
        }

        public void setPay_status(int pay_status) {
            this.pay_status = pay_status;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getFirst_time() {
            return first_time;
        }

        public void setFirst_time(String first_time) {
            this.first_time = first_time;
        }

        public String getChannel_no() {
            return channel_no;
        }

        public void setChannel_no(String channel_no) {
            this.channel_no = channel_no;
        }

        public String getGuide_time() {
            return guide_time;
        }

        public void setGuide_time(String guide_time) {
            this.guide_time = guide_time;
        }

        public int getFortunetelling_info_id() {
            return fortunetelling_info_id;
        }

        public void setFortunetelling_info_id(int fortunetelling_info_id) {
            this.fortunetelling_info_id = fortunetelling_info_id;
        }

        public String getPay_type() {
            return pay_type;
        }

        public void setPay_type(String pay_type) {
            this.pay_type = pay_type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getKeyword() {
            return keyword;
        }

        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public String getName_type() {
            return name_type;
        }

        public void setName_type(String name_type) {
            this.name_type = name_type;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getPay_time() {
            return pay_time;
        }

        public void setPay_time(String pay_time) {
            this.pay_time = pay_time;
        }

        public String getTrade() {
            return trade;
        }

        public void setTrade(String trade) {
            this.trade = trade;
        }

        public String getRead_time() {
            return read_time;
        }

        public void setRead_time(String read_time) {
            this.read_time = read_time;
        }

        public String getWx_oa() {
            return wx_oa;
        }

        public void setWx_oa(String wx_oa) {
            this.wx_oa = wx_oa;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getAddtime() {
            return addtime;
        }

        public void setAddtime(int addtime) {
            this.addtime = addtime;
        }

        public String getWherefrom() {
            return wherefrom;
        }

        public void setWherefrom(String wherefrom) {
            this.wherefrom = wherefrom;
        }

        public String getPhone_time() {
            return phone_time;
        }

        public void setPhone_time(String phone_time) {
            this.phone_time = phone_time;
        }

        public String getNamenum() {
            return namenum;
        }

        public void setNamenum(String namenum) {
            this.namenum = namenum;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }
    }
}
