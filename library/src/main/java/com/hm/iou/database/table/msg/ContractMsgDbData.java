package com.hm.iou.database.table.msg;

import com.orm.SugarRecord;

/**
 * @author syl
 * @time 2019/4/16 3:27 PM
 */
public class ContractMsgDbData extends SugarRecord {

    /**
     * content : string
     * createTime : 2019-04-15T12:17:23.967Z
     * jumpUrl : string
     * sourceBizType : 0
     * title : string
     */
    private String createTime;
    private String title;
    private String content;
    private String jumpUrl;
    private int sourceBizType;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    @Override
    public String toString() {
        return "ContractMsgDbData{" +
                "createTime='" + createTime + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", jumpUrl='" + jumpUrl + '\'' +
                ", sourceBizType=" + sourceBizType +
                '}';
    }
}
