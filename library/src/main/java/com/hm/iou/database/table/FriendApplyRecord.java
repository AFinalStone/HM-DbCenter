package com.hm.iou.database.table;

import com.orm.SugarRecord;
import com.orm.annotation.Unique;

/**
 * Created by hjy on 2019/4/15.
 */

public class FriendApplyRecord extends SugarRecord {


    /**
     * applyId : 173
     * friendId : 1425
     * applyMsg : 我是云之雅
     * avatarUrl : https://iou-test.oss-cn-shanghai.aliyuncs.com/img/18/2019/04/201904221530515190.jpg?1555918232000
     * nickName : 云之雅
     * status : 1
     * applyTime : 2019-07-15 18:46:30
     * sex : 1
     */
    @Unique
    private String friendId;            //好友id
    private String applyId;     //申请记录id
    private String avatarUrl;           //头像
    private String nickName;            //昵称
    private String applyMsg;            //申请记录的附件信息
    private String stageName;           //对方为自己设置的备注名称
    private int status;                 //状态 0 待同意 1已同意 3已过期
    private String applyTime;           //申请时间
    private int sex;                //0==女，1=男，3==未知

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }
}
