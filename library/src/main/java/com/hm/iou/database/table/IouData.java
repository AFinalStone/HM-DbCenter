package com.hm.iou.database.table;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.Ignore;

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
    private int amountPerMonth;         //每月还款额
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

    private String transDeadLine;       //最晚汇出时间

    private int thingsType;             //区分钱、物

    @Ignore
    private Map<String, String> attachFileMap;  //图片

    private String fileList;            //JsonArray格式的字符串

    @Ignore
    private List<FileEntity> files;

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

    public int getAmountPerMonth() {
        return amountPerMonth;
    }

    public void setAmountPerMonth(int amountPerMonth) {
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
                for (int i = 0; i<arr.length(); i++) {
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