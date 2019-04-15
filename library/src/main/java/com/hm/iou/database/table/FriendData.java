package com.hm.iou.database.table;

import com.orm.SugarRecord;
import com.orm.annotation.Unique;

/**
 * Created by hjy on 2019/4/15.
 */
public class FriendData extends SugarRecord {

    private String avatarUrl;   //头像
    private String nickName;    //昵称
    @Unique
    private String friendId;    //好友userId
    private String stageName;   //备注名
    private String showId;

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

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }
}
