package com.hm.iou.database.table;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.annotation.Column;
import com.orm.annotation.Ignore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by hjy on 2018/5/30.
 */
public class IouData extends SugarRecord {

    @Column(name = "iou_id", unique = true)
    @SerializedName("iouId")
    private String iouId;

    private int iouKind;        //借条类型

    private int iouStatus;      //借条状态

    private String borrowerName;        //借到方姓名
    private String borrowerAccount;     //借到人收款账号

    private double amount;              //总金额
    private double amountPerMonth;         //每月还款额
    private double interest;            //利息合计

    private String createTime;          //创建时间
    private String endAlertDate;        //平台借条，终止提醒日期
    private String lastModifyTime;      //修改时间

    private String loanerName;          //出借人姓名
    private String loanerAccount;       //出借人账号

    private int needAlert;              //是否需要提醒

    private String todo;                //用途
    private String memo;                //备注

    private String scheduleReturnDate;  //计划规划日期
    private String realReturnDate;      //实际归还日期
    private int returnWay;              //规划方式
    private int returnDatePerMonth;     //每月归还日

    private String opDate;              //纸质收条经手日期

    private String thingsName;          //物品名称
    private String illustrationId;      //娱乐借条插画id
    private String illustrationUrl;      //娱乐借条插画id

    private String transDeadLine;       //最晚汇出时间

    private int thingsType;             //区分钱、物

    @Ignore
    private Map<String, String> attachFileMap;  //图片

    private String fileList;            //JsonArray格式的字符串

    @Ignore
    private List<FileEntity> files;

    private String justiceId;           //电子借、收条公正id
    private String justiceOrgn;         //公正机构
    private String justiceSealId;       //公正的签章id
    private String justiceShowId;       //showId
    private String justiceTime;         //电子借/收条的存证时间
    private String sceneEvId;           //电子借/收条进行公正的出证凭证 ,
    private String shareUrl;
    private int recvWay;             //收款方式
    private String recvWayName;

    private String idCardNum;       //身份证尾号
    private int remitWay;           //汇款方式
    private String remitWayName;    //汇款方式名称
    private String othersMobile;


    private String fieldFour;      //预留字段4 平台借条为安全指数，为0的时候表示安全指数未知
    private String fieldOne;    //预留字段1 平台借条为agencyId 机构id AgencyType为1,2时关联至T_IOUAgencyPlatform 当AgencyType为3时,其为相应的枚举 ,     【资金借条】：逾期利率中文描述 ,
    private String fieldThree;     //预留字段3 平台借条为AgencyType 1-p2p 2-信用卡 3-房贷/抵押贷/信用贷 4-自定义    资金借条：为逾期利率-OverdueInterestType枚举【OverdueInterestTypeEnum】 ,
    private String fieldTwo;       //【资金借条】：上诉平台名称-LawPlatform

    public String getIouId() {
        return iouId;
    }

    public void setIouId(String iouId) {
        this.iouId = iouId;
    }

    public int getIouKind() {
        return iouKind;
    }

    public void setIouKind(int iouKind) {
        this.iouKind = iouKind;
    }

    public int getIouStatus() {
        return iouStatus;
    }

    public void setIouStatus(int iouStatus) {
        this.iouStatus = iouStatus;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
    }

    public String getBorrowerAccount() {
        return borrowerAccount;
    }

    public void setBorrowerAccount(String borrowerAccount) {
        this.borrowerAccount = borrowerAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmountPerMonth() {
        return amountPerMonth;
    }

    public void setAmountPerMonth(double amountPerMonth) {
        this.amountPerMonth = amountPerMonth;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getEndAlertDate() {
        return endAlertDate;
    }

    public void setEndAlertDate(String endAlertDate) {
        this.endAlertDate = endAlertDate;
    }

    public String getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(String lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getLoanerName() {
        return loanerName;
    }

    public void setLoanerName(String loanerName) {
        this.loanerName = loanerName;
    }

    public String getLoanerAccount() {
        return loanerAccount;
    }

    public void setLoanerAccount(String loanerAccount) {
        this.loanerAccount = loanerAccount;
    }

    public int getNeedAlert() {
        return needAlert;
    }

    public void setNeedAlert(int needAlert) {
        this.needAlert = needAlert;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getScheduleReturnDate() {
        return scheduleReturnDate;
    }

    public void setScheduleReturnDate(String scheduleReturnDate) {
        this.scheduleReturnDate = scheduleReturnDate;
    }

    public String getRealReturnDate() {
        return realReturnDate;
    }

    public void setRealReturnDate(String realReturnDate) {
        this.realReturnDate = realReturnDate;
    }

    public int getReturnWay() {
        return returnWay;
    }

    public void setReturnWay(int returnWay) {
        this.returnWay = returnWay;
    }

    public int getReturnDatePerMonth() {
        return returnDatePerMonth;
    }

    public void setReturnDatePerMonth(int returnDatePerMonth) {
        this.returnDatePerMonth = returnDatePerMonth;
    }

    public String getOpDate() {
        return opDate;
    }

    public void setOpDate(String opDate) {
        this.opDate = opDate;
    }

    public String getThingsName() {
        return thingsName;
    }

    public void setThingsName(String thingsName) {
        this.thingsName = thingsName;
    }

    public String getIllustrationId() {
        return illustrationId;
    }

    public void setIllustrationId(String illustrationId) {
        this.illustrationId = illustrationId;
    }

    public String getIllustrationUrl() {
        return illustrationUrl;
    }

    public void setIllustrationUrl(String illustrationUrl) {
        this.illustrationUrl = illustrationUrl;
    }

    public String getTransDeadLine() {
        return transDeadLine;
    }

    public void setTransDeadLine(String transDeadLine) {
        this.transDeadLine = transDeadLine;
    }

    public Map<String, String> getAttachFileMap() {
        return attachFileMap;
    }

    public void setAttachFileMap(Map<String, String> attachFileMap) {
        this.attachFileMap = attachFileMap;
    }

    public int getThingsType() {
        return thingsType;
    }

    public void setThingsType(int thingsType) {
        this.thingsType = thingsType;
    }

    public String getFileList() {
        if (TextUtils.isEmpty(fileList) && attachFileMap != null) {
            convertFileMapToJson();
        }
        return fileList;
    }

    public void setFileList(String fileList) {
        this.fileList = fileList;
    }

    public String getJusticeId() {
        return justiceId;
    }

    public void setJusticeId(String justiceId) {
        this.justiceId = justiceId;
    }

    public String getJusticeOrgn() {
        return justiceOrgn;
    }

    public void setJusticeOrgn(String justiceOrgn) {
        this.justiceOrgn = justiceOrgn;
    }

    public String getJusticeSealId() {
        return justiceSealId;
    }

    public void setJusticeSealId(String justiceSealId) {
        this.justiceSealId = justiceSealId;
    }

    public String getJusticeShowId() {
        return justiceShowId;
    }

    public void setJusticeShowId(String justiceShowId) {
        this.justiceShowId = justiceShowId;
    }

    public String getJusticeTime() {
        return justiceTime;
    }

    public void setJusticeTime(String justiceTime) {
        this.justiceTime = justiceTime;
    }

    public String getSceneEvId() {
        return sceneEvId;
    }

    public void setSceneEvId(String sceneEvId) {
        this.sceneEvId = sceneEvId;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public int getRecvWay() {
        return recvWay;
    }

    public void setRecvWay(int recvWay) {
        this.recvWay = recvWay;
    }

    public String getRecvWayName() {
        return recvWayName;
    }

    public void setRecvWayName(String recvWayName) {
        this.recvWayName = recvWayName;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public int getRemitWay() {
        return remitWay;
    }

    public void setRemitWay(int remitWay) {
        this.remitWay = remitWay;
    }

    public String getRemitWayName() {
        return remitWayName;
    }

    public void setRemitWayName(String remitWayName) {
        this.remitWayName = remitWayName;
    }

    public String getOthersMobile() {
        return othersMobile;
    }

    public void setOthersMobile(String othersMobile) {
        this.othersMobile = othersMobile;
    }

    public String getFieldFour() {
        return fieldFour;
    }

    public void setFieldFour(String fieldFour) {
        this.fieldFour = fieldFour;
    }

    public String getFieldOne() {
        return fieldOne;
    }

    public void setFieldOne(String fieldOne) {
        this.fieldOne = fieldOne;
    }

    public String getFieldThree() {
        return fieldThree;
    }

    public void setFieldThree(String fieldThree) {
        this.fieldThree = fieldThree;
    }

    public String getFieldTwo() {
        return fieldTwo;
    }

    public void setFieldTwo(String fieldTwo) {
        this.fieldTwo = fieldTwo;
    }

    /**
     * 图片map转换为json
     */
    public void convertFileMapToJson() {
        if (attachFileMap != null && !attachFileMap.isEmpty()) {
            try {
                JSONArray arr = new JSONArray();
                for (Map.Entry<String, String> entry : attachFileMap.entrySet()) {
                    JSONObject obj = new JSONObject();
                    obj.put("id", entry.getKey());
                    obj.put("value", entry.getValue());
                    arr.put(obj);
                }
                String jsonArr = arr.toString();
                this.fileList = jsonArr;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public List<FileEntity> getImageFiles() {
        if (files == null) {
            files = parseFileJsonArr();
        }
        return files;
    }

    private List<FileEntity> parseFileJsonArr() {
        if (!TextUtils.isEmpty(fileList)) {
            try {
                JSONArray arr = new JSONArray(fileList);
                List<FileEntity> list = new ArrayList<>();
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);
                    FileEntity entity = new FileEntity();
                    entity.id = obj.getString("id");
                    entity.value = obj.getString("value");
                    list.add(entity);
                }
                return list;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static class FileEntity {
        public String id;
        public String value;
    }

}