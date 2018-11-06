package com.hm.iou.database.table;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.annotation.Column;

/**
 * @author syl
 * @time 2018/6/7 上午10:26
 */
public class MsgCenterDbData extends SugarRecord {

    @Column(name = "auto_id", unique = true)
    @SerializedName("autoId")
    private String autoId;

    private int type;            //1=="活动",2=="广告",3=="头条",100=="官方公告"
    private String pushDate;     //推送时间
    private String imageUrl;     //广告，头条，活动的缩略图
    private String title;        //标题
    private String infoLinkUrl;  //广告，头条，活动详情页的具体链接地址
    private String notice;       //官方公告简介
    private boolean isRead = false;//是否阅览过

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPushDate() {
        return pushDate;
    }

    public void setPushDate(String pushDate) {
        this.pushDate = pushDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfoLinkUrl() {
        return infoLinkUrl;
    }

    public void setInfoLinkUrl(String infoLinkUrl) {
        this.infoLinkUrl = infoLinkUrl;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    @Override
    public String toString() {
        return "MsgCenterDbData{" +
                "autoId='" + autoId + '\'' +
                ", type=" + type +
                ", pushDate='" + pushDate + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", infoLinkUrl='" + infoLinkUrl + '\'' +
                ", notice='" + notice + '\'' +
                ", isRead=" + isRead +
                '}';
    }
}