package com.hm.iou.database;

import com.hm.iou.database.table.msg.ContractMsgDbData;
import com.hm.iou.database.table.msg.HmMsgDbData;
import com.hm.iou.database.table.msg.RemindBackMsgDbData;
import com.hm.iou.database.table.msg.SimilarityContractMsgDbData;
import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by syl on 2019/4/16.
 */

public class MsgDbHelper {


    /**
     * 删除所有的消息中心数据
     *
     * @return
     */
    public static synchronized void deleteMsgCenterAllListData() {
        SugarRecord.deleteAll(ContractMsgDbData.class);
        SugarRecord.deleteAll(HmMsgDbData.class);
        SugarRecord.deleteAll(RemindBackMsgDbData.class);
        SugarRecord.deleteAll(SimilarityContractMsgDbData.class);
    }


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
     * 获取所有的条管家消息列表
     *
     * @return
     */
    public static synchronized List<HmMsgDbData> getHmMsgList() {
        List<HmMsgDbData> list = SugarRecord.listAll(HmMsgDbData.class);
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
     * 保存或更新疑似合同消息列表
     *
     * @param list
     */
    public static synchronized void saveOrUpdateSimilarityContractMsgList(List<SimilarityContractMsgDbData> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        SugarRecord.saveInTx(list);
    }

    /**
     * 获取所有的疑似合同消息列表
     *
     * @return
     */
    public static synchronized List<SimilarityContractMsgDbData> getSimilarityContractMsgList() {
        List<SimilarityContractMsgDbData> list = SugarRecord.listAll(SimilarityContractMsgDbData.class);
        return list;
    }

}
