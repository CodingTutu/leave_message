package cn.tycoding.pojo;

import java.io.Serializable;

/**
 * 管理人员信息
 * @author TyCoding
 * @date 18-4-26下午9:14
 */
public class Admin implements Serializable {

    // ID编号
    private int a_id;
    // 用户名
    private String a_name;
    // 密码
    private String a_password;
    // 联系电话
    private String a_telephone;
    // 注册日期
    private String a_date;
    // 身份
    private String a_identity;
    // 身份对应的id -->  1：管理员   2：录入员   3：审核员   4：普通用户
    private int a_identity_id;

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_name() {
        return a_name;
    }

    public void setA_name(String a_name) {
        this.a_name = a_name;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    public String getA_telephone() {
        return a_telephone;
    }

    public void setA_telephone(String a_telephone) {
        this.a_telephone = a_telephone;
    }

    public String getA_identity() {
        return a_identity;
    }

    public void setA_identity(String a_identity) {
        this.a_identity = a_identity;
    }

    public int getA_identity_id() {
        return a_identity_id;
    }

    public void setA_identity_id(int a_identity_id) {
        this.a_identity_id = a_identity_id;
    }

    public String getA_date() {
        return a_date;
    }

    public void setA_date(String a_date) {
        this.a_date = a_date;
    }
}
