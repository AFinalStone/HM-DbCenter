package com.hm.iou.database.table.msg;

/**
 * @author syl
 * @time 2019/4/16 3:27 PM
 */
public class AliPayMsgDbData extends BaseMsgDbData {

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

    @Override
    public String toString() {
        return super.toString() + "AliPayMsgDbData{" +
                "createTime='" + createTime + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", jumpUrl='" + jumpUrl + '\'' +
                '}';
    }
}
