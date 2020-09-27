package com.moyun.sysmanager.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author dzh
 */


@Data
public class OrderDTO implements Serializable {

    /**
     * code : 1
     * info : {"order_id":"PP2020090916510112778","name_type":"品牌","trade":"火锅","company_type":"","namenum":"未知","birthday":"2020-09-09 01:00:00","add_time":"2020-09-09 16:51:01","is_urgent":0,"price":"0.01","pay_status":1,"pay_time":"2020-09-09 16:51:56","guide_time":"2020-09-09 16:53:49","phone":"","first_time":null,"read_time":null,"link":"http://gstest.quming6.cn/"}
     * message :
     */

    private int code;
    private List<Info> info;
    private String message;


    @Data
    public static class Info implements Serializable {
        /**
         * order_id : PP2020090916510112778
         * name_type : 品牌
         * trade : 火锅
         * company_type :
         * namenum : 未知
         * birthday : 2020-09-09 01:00:00
         * add_time : 2020-09-09 16:51:01
         * is_urgent : 0
         * price : 0.01
         * pay_status : 1
         * pay_time : 2020-09-09 16:51:56
         * guide_time : 2020-09-09 16:53:49
         * phone :
         * first_time : null
         * read_time : null
         * link : http://gstest.quming6.cn/
         */

        private String order_id;
        private String name_type;
        private String trade;
        private String company_type;
        private String namenum;
        private String birthday;
        private String add_time;
        private int is_urgent;
        private String price;
        private int pay_status;
        private String pay_time;
        private String guide_time;
        private String phone;
        private String first_time;
        private String read_time;
        private String link;
    }
}
