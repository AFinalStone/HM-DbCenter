package com.hm.iou.database.table.msg;

import com.orm.SugarRecord;

public class RemindBackMsgDbData extends SugarRecord {

    /**
     * content : string
     * createTime : 2019-04-15T12:17:23.987Z
     * iouKind : 0
     * jumpUrl : string
     * repayAmount : 0
     * repayDateTime : 2019-04-15T12:17:23.988Z
     * title : string
     */

    private String content;
    private String createTime;
    private int iouKind;
    private String jumpUrl;
    private int repayAmount;
    private String repayDateTime;
    private String title;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getIouKind() {
        return iouKind;
    }

    public void setIouKind(int iouKind) {
        this.iouKind = iouKind;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public int getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(int repayAmount) {
        this.repayAmount = repayAmount;
    }

    public String getRepayDateTime() {
        return repayDateTime;
    }

    public void setRepayDateTime(String repayDateTime) {
        this.repayDateTime = repayDateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
