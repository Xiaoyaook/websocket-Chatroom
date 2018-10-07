package com.xiaoyaook.chatroom.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * created by xiaoyaook on 18-10-2
 *
 * 群组信息实体类
 */
public class GroupInfo {
    private Long id;
    private String groupName;
    private String avatarUrl;
    private String discreption;

    private Date createBy;
    private Date modifiedBy;

    public Long getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupAvatarUrl() {
        return avatarUrl;
    }

    public void setGroupAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getDiscreption() {
        return discreption;
    }

    public void setDiscreption(String discreption) {
        this.discreption = discreption;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
