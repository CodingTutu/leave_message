package cn.tycoding.pojo;

import java.io.Serializable;

/**
 * 文章信息
 * @author TyCoding
 * @date 18-4-26下午9:37
 */
public class Article implements Serializable {

    // 文章编号
    private int r_id;
    // 文章作者
    private String r_author;
    // 文章简介
    private String r_summary;
    // 文章内容
    private String r_content;
    // 文章创建日期
    private String r_date;
    // 文章审核 --> 0：未审核   1：已审核
    private int r_verify;
    // 文章发表 --> 0：未发表   1：未发表
    private int r_publish;
    // 文章状态 --> 0：存在    1：已删除
    private int r_status;

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_author() {
        return r_author;
    }

    public void setR_author(String r_author) {
        this.r_author = r_author;
    }

    public void setR_summary(String r_summary) {
        this.r_summary = r_summary;
    }

    public String getR_summary() {
        return r_summary;
    }

    public String getR_content() {
        return r_content;
    }

    public void setR_content(String r_content) {
        this.r_content = r_content;
    }

    public String getR_date() {
        return r_date;
    }

    public void setR_date(String r_date) {
        this.r_date = r_date;
    }

    public int getR_verify() {
        return r_verify;
    }

    public void setR_verify(int r_verify) {
        this.r_verify = r_verify;
    }

    public int getR_publish() {
        return r_publish;
    }

    public void setR_publish(int r_publish) {
        this.r_publish = r_publish;
    }

    public int getR_status() {
        return r_status;
    }

    public void setR_status(int r_status) {
        this.r_status = r_status;
    }

}
