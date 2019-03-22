package com.hm.iou.database.table;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.annotation.Column;

/**
 * @author syl
 * @time 2018/6/7 上午10:26
 * 占用签章列表
 */
public class LockSignDbData extends SugarRecord {

    @Column(name = "justice_id", unique = true)
    @SerializedName("justiceId")
    private String justiceId;//合同id
    private String content;//名称
    private String endDateStr;//占用的截止时间
    private String genDateStr;//生成时间
    private int lockedStatus;   //1-签署中，2-未签退回，3-签完已付
    private int signNum;//占用的签章数量

    public String getJusticeId() {
        return justiceId;
    }

    public void setJusticeId(String justiceId) {
        this.justiceId = justiceId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEndDateStr() {
        return endDateStr;
    }

    public void setEndDateStr(String endDateStr) {
        this.endDateStr = endDateStr;
    }

    public String getGenDateStr() {
        return genDateStr;
    }

    public void setGenDateStr(String genDateStr) {
        this.genDateStr = genDateStr;
    }

    public int getLockedStatus() {
        return lockedStatus;
    }

    public void setLockedStatus(int lockedStatus) {
        this.lockedStatus = lockedStatus;
    }

    public int getSignNum() {
        return signNum;
    }

    public void setSignNum(int signNum) {
        this.signNum = signNum;
    }
}