package com.hm.iou.database.table.msg;

/**
 * @author syl
 * @time 2019/4/16 3:27 PM
 */
public class SimilarityContractMsgDbData extends BaseMsgDbData {

    /**
     * amount : string
     * borrowerName : string
     * createTime : 2019-04-24T01:50:35.106Z
     * iouKind : 0
     * iouStatus : 0
     * jumpUrl : string
     * loanerName : string
     * returnDate : 2019-04-24T01:50:35.106Z
     * returnWayDesc : string
     * title : string
     */
    private String amount;
    private String borrowerName;
    private String createTime;
    private int iouKind;
    private int iouStatus;//1=草稿, 2=正式/已签署完, Del(3), Close(4), 5=已结清，12=等待确认，13=超时未签 ,
    private String jumpUrl;
    private String loanerName;
    private String returnDate;
    private String returnWayDesc;
    private String title;


    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName;
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

    public int getIouStatus() {
        return iouStatus;
    }

    public void setIouStatus(int iouStatus) {
        this.iouStatus = iouStatus;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public String getLoanerName() {
        return loanerName;
    }

    public void setLoanerName(String loanerName) {
        this.loanerName = loanerName;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnWayDesc() {
        return returnWayDesc;
    }

    public void setReturnWayDesc(String returnWayDesc) {
        this.returnWayDesc = returnWayDesc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
