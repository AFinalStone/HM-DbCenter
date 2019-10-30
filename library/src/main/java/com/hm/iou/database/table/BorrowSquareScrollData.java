package com.hm.iou.database.table;

import com.orm.SugarRecord;

/**
 * 借款广场滚动列表数据
 */
public class BorrowSquareScrollData extends SugarRecord {

    public int sort;
    public String squareApplyId;
    public String firstHeadUrl;
    public String secondHeadUrl;
    public int type;        //1：刚刚发布，2：当日发布，3：近期发布，4：诚意用户，5：被TA查看，6：添加好友，7：在线等待 8：签署完成
    public String title;
    public String content;
    public int btnType;  //1：截单  2：查看（自己发布的，显示查看，不是截单） 3：回顾

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getSquareApplyId() {
        return squareApplyId;
    }

    public void setSquareApplyId(String squareApplyId) {
        this.squareApplyId = squareApplyId;
    }

    public String getFirstHeadUrl() {
        return firstHeadUrl;
    }

    public void setFirstHeadUrl(String firstHeadUrl) {
        this.firstHeadUrl = firstHeadUrl;
    }

    public String getSecondHeadUrl() {
        return secondHeadUrl;
    }

    public void setSecondHeadUrl(String secondHeadUrl) {
        this.secondHeadUrl = secondHeadUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBtnType() {
        return btnType;
    }

    public void setBtnType(int btnType) {
        this.btnType = btnType;
    }
}
