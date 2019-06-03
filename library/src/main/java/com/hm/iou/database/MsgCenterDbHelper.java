package com.hm.iou.database;


import com.hm.iou.database.table.msg.AliPayMsgDbData;
import com.hm.iou.database.table.msg.BaseMsgDbData;
import com.hm.iou.database.table.msg.ContractMsgDbData;
import com.hm.iou.database.table.msg.HmMsgDbData;
import com.hm.iou.database.table.msg.RemindBackMsgDbData;
import com.hm.iou.database.table.msg.SimilarityContractMsgDbData;
import com.orm.SugarRecord;

import java.util.List;

/**
 * @author syl
 * @time 2018/6/7 上午10:26
 */
public class MsgCenterDbHelper {


    /**
     * 保存更新消息列表
     *
     * @param list
     */
    public static synchronized <T extends BaseMsgDbData> void saveOrUpdateMsgList(List<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        SugarRecord.saveInTx(list);
    }

    /**
     * 保存更新消息列表条目
     *
     * @param dbData
     */
    public static synchronized <T extends BaseMsgDbData> void saveOrUpdateMsg(T dbData) {
        if (dbData == null) {
            return;
        }
        SugarRecord.saveInTx(dbData);
    }

    /**
     * 获取消息中心列表
     *
     * @return
     */
    public static synchronized <T extends BaseMsgDbData> List<T> getMsgList(Class<T> classOfT) {
        return SugarRecord.listAll(classOfT);
    }

    /**
     * 获取消息中心列表
     *
     * @return
     */
    public static synchronized <T extends BaseMsgDbData> List<T> getMsgList(Class<T> classOfT, String whereClause, String... whereArgs) {
        return SugarRecord.find(classOfT, whereClause, whereArgs);
    }

    /**
     * 根据msgId获取消息中心消息
     *
     * @return
     */
    public static synchronized <T extends BaseMsgDbData> T getMsgByMsgId(Class<T> classOfT, String msgId) {
        List<T> list = SugarRecord.find(classOfT, "msg_id = ?", msgId);
        if (list == null || list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    /**
     * 获取消息中心消息数量
     *
     * @return
     */
    public static synchronized <T extends BaseMsgDbData> long getMsgNum(Class<T> classOfT) {
        return SugarRecord.count(classOfT);
    }

    /**
     * 获取消息中心未读消息数量
     *
     * @return
     */
    public static synchronized <T extends BaseMsgDbData> long getMsgUnReadNum(Class<T> classOfT) {
        return SugarRecord.count(classOfT, "is_have_read = ?", new String[]{"0"});
    }

    /**
     * 新增或者更新官方公告到消息中心
     *
     * @param noticeId
     * @param pushDate
     * @param notice
     */
    public static synchronized void addOrUpdateNoticeToCache(String noticeId, String pushDate, String notice) {
        HmMsgDbData dbData = new HmMsgDbData();
        noticeId = "notice_" + noticeId;//防止和消息中心其他类型的id重复
        dbData.setMsgId(noticeId);
        dbData.setStartTime(pushDate);
        dbData.setNotice(notice);
        dbData.setHaveRead(true);
        dbData.setSourceBizType(100);
        SugarRecord.saveInTx(dbData);
    }

    /**
     * 根据官方公告id查询官方公告
     *
     * @param noticeId 官方公告id
     * @return
     */
    public static synchronized boolean queryNoticeById(String noticeId) {
        noticeId = "notice_" + noticeId;//防止和消息中心其他类型的id重复
        List<HmMsgDbData> list = SugarRecord.find(HmMsgDbData.class, "msg_id = ?", noticeId);
        if (list == null || list.isEmpty())
            return false;
        return true;
    }


    /**
     * 根据疑似合同公证id删除疑似合同数据
     *
     * @param justId
     */
    public static synchronized int deleteSimilarityContractByJustId(String justId) {
        return SugarRecord.deleteAll(SimilarityContractMsgDbData.class, "justice_id = ?", new String[]{justId});
    }

    /**
     * 删除所有的消息中心数据
     *
     * @return
     */
    public static synchronized void deleteMsgCenterAllListData() {
        SugarRecord.deleteAll(AliPayMsgDbData.class);
        SugarRecord.deleteAll(ContractMsgDbData.class);
        SugarRecord.deleteAll(HmMsgDbData.class);
        SugarRecord.deleteAll(RemindBackMsgDbData.class);
        SugarRecord.deleteAll(SimilarityContractMsgDbData.class);
    }


}