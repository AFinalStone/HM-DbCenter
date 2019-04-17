package com.hm.iou.database.table.msg;

import com.orm.SugarRecord;
import com.orm.annotation.Unique;

/**
 * @author syl
 * @time 2018/6/7 上午10:26
 */
public class HmMsgDbData extends SugarRecord {
    /**
     * contentCollectId : 0
     * imgUrl : string
     * jumpUrl : string
     * sourceBizType : 0
     * startTime : 2019-04-16T12:51:15.705Z
     * title : string
     */

    @Unique
    private String contentCollectId;
    private String imgUrl;
    private String jumpUrl;
    private int sourceBizType;   //10=广告模块，20=资讯模块, 30=意见反馈结果 100=="官方公告"
    private String startTime;
    private String title;        //标题
    private String notice;       //官方公告简介

    public String getContentCollectId() {
        return contentCollectId;
    }

    public void setContentCollectId(String contentCollectId) {
        this.contentCollectId = contentCollectId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public int getSourceBizType() {
        return sourceBizType;
    }

    public void setSourceBizType(int sourceBizType) {
        this.sourceBizType = sourceBizType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
//    @Column(name = "auto_id", unique = true)
//    @SerializedName("autoId")
//    private String autoId;
//
//    private int type;            //1=="活动",2=="广告",3=="头条",100=="官方公告"
//    private String pushDate;     //推送时间
//    private String imageUrl;     //广告，头条，活动的缩略图
//    private String title;        //标题
//    private String infoLinkUrl;  //广告，头条，活动详情页的具体链接地址
//    private String notice;       //官方公告简介

}