package com.jaken.psall.mybatisgen;

import java.util.Date;

public class TArticle {
    private String id;

    private String title;

    private String isStar;

    private String categoryId;

    private Date createTime;

    private String userId;

    private String userUd;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIsStar() {
        return isStar;
    }

    public void setIsStar(String isStar) {
        this.isStar = isStar == null ? null : isStar.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserUd() {
        return userUd;
    }

    public void setUserUd(String userUd) {
        this.userUd = userUd == null ? null : userUd.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}