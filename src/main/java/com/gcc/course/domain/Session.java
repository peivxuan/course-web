package com.gcc.course.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by WangZK on 2017/3/20.
 */
@Entity
public class Session {

    @Id
    @GeneratedValue(generator = "UUID2_GENERATOR")
    private String id;
    private String name;
    private String description; //描述
    private String imgUrl; //相关图片路径

    private int sort_order ; //排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数

    @Column(columnDefinition = "INT default 0")
    private String parent_id; //父节点，如果为0，则为1级目录

    @Column(columnDefinition = "INT default 0")
    private int is_parent; //是否有父节点，1为true，0为false

    @Column(columnDefinition = "INT default 0")
    private int is_deleted; //是否被删除，1为true，0为false

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDateTime addTime; //添加时间

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime deletedTime; //删除时间

    @OneToMany
    private List<Article> articles;

    public Session() {
        this.parent_id = "0";
        this.is_parent = 0;
        this.is_deleted = 0;
        this.addTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getSort_order() {
        return sort_order;
    }

    public void setSort_order(int sort_order) {
        this.sort_order = sort_order;
    }

    public String getParent_id() {
        return parent_id;
    }

    public void setParent_id(String parent_id) {
        this.parent_id = parent_id;
    }

    public int getIs_parent() {
        return is_parent;
    }

    public void setIs_parent(int is_parent) {
        this.is_parent = is_parent;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public LocalDateTime getDeletedTime() {
        return deletedTime;
    }

    public void setDeletedTime(LocalDateTime deletedTime) {
        this.deletedTime = deletedTime;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
