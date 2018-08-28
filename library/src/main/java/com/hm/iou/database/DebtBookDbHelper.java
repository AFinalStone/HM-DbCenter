package com.hm.iou.database;


import com.hm.iou.database.table.DebtBookItem;
import com.orm.SugarRecord;

import java.util.List;


/**
 * @author syl
 * @time 2018/8/28 下午1:56
 */
public class DebtBookDbHelper {

    /**
     * 添加或更新记债本到数据库
     *
     * @param data
     * @return
     */
    public static synchronized long insertOrUpdateDebtBook(DebtBookItem data) {
        return data.save();
    }


    /**
     * 通过id删除记债本
     *
     * @param autoId
     * @return
     */
    public static synchronized int deleteDebtBookById(String autoId) {
        return SugarRecord.deleteAll(DebtBookItem.class, "auto_id = ?", autoId);
    }

    /**
     * 清空数据
     *
     * @return
     */
    public static synchronized int deleteAllDebtBookData() {
        return SugarRecord.deleteAll(DebtBookItem.class);
    }

    /**
     * 保存或更新记债本列表
     *
     * @param list
     */
    public static synchronized void saveOrUpdateDebtBookList(List<DebtBookItem> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        SugarRecord.saveInTx(list);
    }

    /**
     * 根据id查询记债本
     *
     * @param autoId
     * @return
     */
    public static synchronized List<DebtBookItem> queryDebtBookListById(String autoId) {
        List<DebtBookItem> list = SugarRecord.find(DebtBookItem.class, "auto_id = ?",
                new String[]{autoId}, null, "create_time asc", null);
        return list;
    }

    /**
     * 查询全部的记债本数据
     *
     * @return
     */
    public static synchronized List<DebtBookItem> queryDebtBookAllDataList() {
        return DebtBookItem.listAll(DebtBookItem.class);
    }
}
