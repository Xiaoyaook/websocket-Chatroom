package com.xiaoyaook.chatroom.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * created by xiaoyaook on 18-10-2
 */
public class UserInfo {

    private Long id;
    private String nickname;
    private String username;
    private String password;
    private String avatarUrl;
    private String discreption;
    private String salt;

    private Date createBy;
    private Date modifiedBy;

    public Long getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getAvatarUrl() {
        return avatarUrl;
    }
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDiscreption() {
        return discreption;
    }

    public void setDiscreption(String discreption) {
        this.discreption = discreption;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreateBy() {
        return createBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    public Date getModifiedBy() {
        return modifiedBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", discreption='" + discreption + '\'' +
                ", salt='" + salt + '\'' +
                ", createBy=" + createBy +
                ", modifiedBy=" + modifiedBy +
                '}';
    }
}
