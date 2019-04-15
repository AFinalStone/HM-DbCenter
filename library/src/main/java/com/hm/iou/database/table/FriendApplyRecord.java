package com.hm.iou.database.table;

import com.orm.SugarRecord;
import com.orm.annotation.Unique;

/**
 * Created by hjy on 2019/4/15.
 */

public class FriendApplyRecord extends SugarRecord {

    @Unique
    private String friendId;
    private String applyId;
    private String avatarUrl;
    private String nickName;
    private String applyMsg;
    private int status;                 //状态 0 待同意 1已同意 3已过期
    private String applyTime;

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getApplyMsg() {
        return applyMsg;
    }

    public void setApplyMsg(String applyMsg) {
        this.applyMsg = applyMsg;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }
}
