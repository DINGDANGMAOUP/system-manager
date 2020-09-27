package com.moyun.sysmanager.common.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author dzh
 */

@NoArgsConstructor
@Data
public class OrderFdDTO implements Serializable {

    /**
     * meal : null
     * order_id : YQ2020062314162018136
     * price : 0.01
     * pay_status : 1
     * pay_time : 2020-06-23 14:16:29
     * read_time : null
     * isRead : 0
     * short : null
     * phone : 13666042571
     * firstname : 尤
     * sex : 女
     * namenum : 单字
     * birthday : 公历2020-06-23
     * onlyname : null
     * address : 福建
     * showphone : null
     * ip : 59.57.162.179
     * addkf : null
     */

    private String meal;
    private String order_id;
    private String price;
    private String pay_status;
    private String pay_time;
    private String read_time;
    private String isRead;
    private String shortX;
    private String phone;
    private String firstname;
    private String sex;
    private String namenum;
    private String birthday;
    private String onlyname;
    private String address;
    private String showphone;
    private String ip;
    private String addkf;
}
