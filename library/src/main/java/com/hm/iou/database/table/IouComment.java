package com.hm.iou.database.table;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Column;


/**
 * Created by hjy on 2018/5/30.
 */
public class IouComment extends SugarRecord {

    @Column(name = "comment_id", unique = true)
    @SerializedName(value = "commentId")
    private String commentId;

    private String iouId;

    private String createTime;

    private String content;

    private int commentType;    //评论类型：1-pic，2-text


    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getIouId() {
        return iouId;
    }

    public void setIouId(String iouId) {
        this.iouId = iouId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentType() {
        return commentType;
    }

    public void setCommentType(int commentType) {
        this.commentType = commentType;
    }
}
