package com.hm.iou.database;


import com.hm.iou.database.table.msg.AliPayMsgDbData;
import com.hm.iou.database.table.msg.ContractMsgDbData;
import com.hm.iou.database.table.msg.HmMsgDbData;
import com.hm.iou.database.table.msg.RemindBackMsgDbData;
import com.orm.SugarRecord;

import java.util.List;

/**
 * @author syl
 * @time 2018/6/7 上午10:26
 */
public class MsgCenterDbHelper {

    /**
     * 保存或更新合同消息列表
     *
     * @param list
     */
    public static synchronized void saveOrUpdateContractMsgList(List<ContractMsgDbData> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        SugarRecord.saveInTx(list);
    }

    /**
     * 获取所有的合同消息列表
     *
     * @return
     */
    public static synchronized List<ContractMsgDbData> getContractMsgList() {
        List<ContractMsgDbData> list = SugarRecord.listAll(ContractMsgDbData.class);
        return list;
    }

    /**
     * 保存或更新提心归还消息列表
     *
     * @param list
     */
    public static synchronized void saveOrUpdateRemindBackMsgList(List<RemindBackMsgDbData> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        SugarRecord.saveInTx(list);
    }

    /**
     * 获取所有的提心归还消息列表
     *
     * @return
     */
    public static synchronized List<RemindBackMsgDbData> getRemindBackMsgList() {
        List<RemindBackMsgDbData> list = SugarRecord.listAll(RemindBackMsgDbData.class);
        return list;
    }

    /**
     * 保存或更新条管家消息列表
     *
     * @param list
     */
    public static synchronized void saveOrUpdateHmMsgList(List<HmMsgDbData> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        SugarRecord.saveInTx(list);
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
        dbData.setContentCollectId(noticeId);
        dbData.setStartTime(pushDate);
        dbData.setNotice(notice);
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
        List<HmMsgDbData> list = SugarRecord.find(HmMsgDbData.class, "content_collect_id = ?", noticeId);
        if (list == null || list.isEmpty())
            return false;
        return true;
    }

    /**
     * 获取所有的条管家消息列表
     *
     * @return
     */
    public static synchronized List<HmMsgDbData> getHmMsgList() {
        List<HmMsgDbData> list = SugarRecord.find(HmMsgDbData.class,
                null, null, null, "datetime(start_time) asc", null);
        return list;
    }


    /**
     * 保存更新支付宝回单消息列表
     *
     * @param list
     */
    public static synchronized void saveOrUpdateAliPayMsgList(List<AliPayMsgDbData> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        SugarRecord.saveInTx(list);
    }

    /**
     * 获取支付宝回单消息列表
     *
     * @return
     */
    public static synchronized List<AliPayMsgDbData> getAliPayMsgList() {
        List<AliPayMsgDbData> list = SugarRecord.listAll(AliPayMsgDbData.class);
        return list;
    }


    /**
     * 删除所有的消息中心数据
     *
     * @return
     */
    public static synchronized void deleteMsgCenterAllListData() {
        SugarRecord.deleteAll(ContractMsgDbData.class);
        SugarRecord.deleteAll(HmMsgDbData.class);
        SugarRecord.deleteAll(RemindBackMsgDbData.class);
    }


}