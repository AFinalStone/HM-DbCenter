package com.hm.iou.database;

import android.content.Context;
import android.text.TextUtils;

import com.hm.iou.database.table.FriendApplyRecord;
import com.hm.iou.database.table.FriendData;
import com.hm.iou.database.table.IouData;
import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by hjy on 2019/4/15.
 */

public class FriendDbUtil {

    /**
     * 删除所有的好友信息
     */
    public static synchronized void deleteAllFriendData() {
        SugarRecord.deleteAll(FriendData.class);
        SugarRecord.deleteAll(FriendApplyRecord.class);
    }

    /**
     * 保存或更新好友列表数据
     *
     * @param list
     */
    public static synchronized void saveOrUpdateFriendList(List<FriendData> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        SugarRecord.saveInTx(list);
    }

    /**
     * 保存或更新好友申请记录列表
     *
     * @param list
     */
    public static synchronized void saveOrUpdateFriendApplyRecordList(List<FriendApplyRecord> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        SugarRecord.saveInTx(list);
    }

    /**
     * 根据好友用户id删除
     *
     * @param userId
     */
    public static synchronized int deleteFriendByUserId(String userId) {
        return SugarRecord.deleteAll(FriendData.class, "friend_id = ?", new String[]{userId});
    }

    /**
     * 删除好友申请记录
     *
     * @param userId
     */
    public static synchronized int deleteFriendApplyRecordByUserId(String userId) {
        return SugarRecord.deleteAll(FriendApplyRecord.class, "friend_id = ?", new String[]{userId});
    }

    public static synchronized int deleteFriendApplyRecordByApplyId(String applyId) {
        return SugarRecord.deleteAll(FriendApplyRecord.class, "apply_id = ?", new String[]{applyId});
    }

    /**
     * 获取所有的好友列表
     *
     * @return
     */
    public static synchronized List<FriendData> getFriendList() {
        List<FriendData> list = SugarRecord.listAll(FriendData.class);
        return list;
    }

    /**
     * 获取所有的好友申请记录列表
     *
     * @param orderByTime "desc"：根据时间降序排列，"asc"：根据时间升序排列
     * @return
     */
    public static synchronized List<FriendApplyRecord> getApplyRecordList(String orderByTime) {
        String orderBy = null;
        if (TextUtils.isEmpty(orderByTime)) {
            orderBy = null;
        } else {
            if ("desc".equals(orderByTime)) {
                orderBy = "apply_time desc";
            } else if ("asc".equals(orderByTime)) {
                orderBy = "apply_time asc";
            }
        }
        List<FriendApplyRecord> list = SugarRecord.listAll(FriendApplyRecord.class, orderBy);
        return list;
    }

}