package com.hm.iou.database.table.msg;

import com.orm.SugarRecord;

public class RemindBackMsgDbData extends SugarRecord {
    /**
     * createTime : 2019-04-24T01:50:35.115Z
     * iouKind : 0
     * jumpUrl : string
     * repayDateTime : 2019-04-24T01:50:35.115Z
     * repayThing : string
     * thingsType : 0
     * title : string
     */

    /**
     * repayAmount : 0
     * title : string
     */

    private String createTime;
    private int iouKind;//借条类型: 1:资金借条, 3:娱乐借条, 4:娱乐借条插画,5:平台借条,7:纸质借条,8:纸质收条,9:电子收条,11:资金借条V2 ,
    private String jumpUrl;
    private String repayDateTime;
    private String repayThing;
    private int thingsType;// 物品类别:0=物品，1=资金 ,
    private String title;

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

    public String getRepayDateTime() {
        return repayDateTime;
    }

    public void setRepayDateTime(String repayDateTime) {
        this.repayDateTime = repayDateTime;
    }

    public String getRepayThing() {
        return repayThing;
    }

    public void setRepayThing(String repayThing) {
        this.repayThing = repayThing;
    }

    public int getThingsType() {
        return thingsType;
    }

    public void setThingsType(int thingsType) {
        this.thingsType = thingsType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
