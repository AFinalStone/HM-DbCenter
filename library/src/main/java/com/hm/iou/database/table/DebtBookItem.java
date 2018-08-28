package com.hm.iou.database.table;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Column;

/**
 * @author syl
 * @time 2018/6/7 上午10:26
 * 记债本内容
 */
public class DebtBookItem extends SugarRecord {


    /**
     * autoId : 0
     * content : string
     * createTime : 2018-08-28T05:43:42.747Z
     * debtTime : 2018-08-28T05:43:42.747Z
     * ifAddStar : 0
     * ifHaveImg : 0
     * locationInfo : string
     * type : 0
     */
    @Column(name = "auto_id", unique = true)
    @SerializedName("autoId")
    private String autoId;
    private String content;
    private String createTime;
    private String debtTime;//债务的日期时间
    private int ifAddStar;//是否加星、1=有，0=无
    private int ifHaveImg;//是否有图片、1=有，0=无
    private String locationInfo;
    private int type;//0 = 随手记、1 =人情债、2=亲情债、3=金钱债

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

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

    public String getDebtTime() {
        return debtTime;
    }

    public void setDebtTime(String debtTime) {
        this.debtTime = debtTime;
    }

    public int getIfAddStar() {
        return ifAddStar;
    }

    public void setIfAddStar(int ifAddStar) {
        this.ifAddStar = ifAddStar;
    }

    public int getIfHaveImg() {
        return ifHaveImg;
    }

    public void setIfHaveImg(int ifHaveImg) {
        this.ifHaveImg = ifHaveImg;
    }

    public String getLocationInfo() {
        return locationInfo;
    }

    public void setLocationInfo(String locationInfo) {
        this.locationInfo = locationInfo;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DebtBookItem{" +
                "autoId='" + autoId + '\'' +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", debtTime='" + debtTime + '\'' +
                ", ifAddStar=" + ifAddStar +
                ", ifHaveImg=" + ifHaveImg +
                ", locationInfo='" + locationInfo + '\'' +
                ", type=" + type +
                '}';
    }
}