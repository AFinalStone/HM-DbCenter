package com.hm.iou.database.table;

import com.orm.SugarRecord;

public class BorrowSquareContentData extends SugarRecord {

    public String squareApplyId;
    public String borrowPeriod;
    public String interest;

    //类型，1：诚心借款，2：AA借款，3：随缘借款
    public int publishType;

    public String publishTypeDesc;

    //显示状态，0：空白，1：我的单，2：待通过，3：已完成，4：过期下架，5：主动下架，6：在线
    public int showStatus;
    public String showStatusDesc;
    public String title;

    public String part;

    public boolean selectMe;

    public String avatar;

    public String getSquareApplyId() {
        return squareApplyId;
    }

    public void setSquareApplyId(String squareApplyId) {
        this.squareApplyId = squareApplyId;
    }

    public String getBorrowPeriod() {
        return borrowPeriod;
    }

    public void setBorrowPeriod(String borrowPeriod) {
        this.borrowPeriod = borrowPeriod;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public int getPublishType() {
        return publishType;
    }

    public void setPublishType(int publishType) {
        this.publishType = publishType;
    }

    public String getPublishTypeDesc() {
        return publishTypeDesc;
    }

    public void setPublishTypeDesc(String publishTypeDesc) {
        this.publishTypeDesc = publishTypeDesc;
    }

    public int getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(int showStatus) {
        this.showStatus = showStatus;
    }

    public String getShowStatusDesc() {
        return showStatusDesc;
    }

    public void setShowStatusDesc(String showStatusDesc) {
        this.showStatusDesc = showStatusDesc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public boolean isSelectMe() {
        return selectMe;
    }

    public void setSelectMe(boolean selectMe) {
        this.selectMe = selectMe;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
