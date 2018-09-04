package com.hm.iou.database;


import com.hm.iou.database.table.DebtBookDbData;
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
    public static synchronized long insertOrUpdateDebtBook(DebtBookDbData data) {
        return data.save();
    }


    /**
     * 通过id删除记债本
     *
     * @param autoId
     * @return
     */
    public static synchronized int deleteDebtBookById(String autoId) {
        return SugarRecord.deleteAll(DebtBookDbData.class, "auto_id = ?", autoId);
    }

    /**
     * 清空数据
     *
     * @return
     */
    public static synchronized int deleteAllDebtBookData() {
        return SugarRecord.deleteAll(DebtBookDbData.class);
    }

    /**
     * 保存或更新记债本列表
     *
     * @param list
     */
    public static synchronized void saveOrUpdateDebtBookList(List<DebtBookDbData> list) {
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
    public static synchronized List<DebtBookDbData> queryDebtBookListById(String autoId) {
        List<DebtBookDbData> list = SugarRecord.find(DebtBookDbData.class, "auto_id = ?",
                new String[]{autoId}, null, "debt_time desc", null);
        return list;
    }

    /**
     * 根据类型查询记债本
     *
     * @param type TabAll(-1, "记债本")，TabConvenientlyRecord(0, "随手记"), TabHumanFeel(1, "人情债"), TabFamily(2, "亲情债"), TabMoney(3, "金钱债");
     * @return
     */
    public static synchronized List<DebtBookDbData> queryDebtBookListByType(int type) {
        if (type == -1) {
            return SugarRecord.find(DebtBookDbData.class, null,
                    null, null, "debt_time desc", null);
        }
        return SugarRecord.find(DebtBookDbData.class, "type = ?",
                new String[]{String.valueOf(type)}, null, "debt_time desc", null);
    }

    /**
     * 根据类型查询记债本数量
     *
     * @param type TabAll(-1, "记债本")，TabConvenientlyRecord(0, "随手记"), TabHumanFeel(1, "人情债"), TabFamily(2, "亲情债"), TabMoney(3, "金钱债");
     * @return
     */
    public static synchronized long queryDebtBookListCount(int type) {
        if (type == -1) {
            return SugarRecord.count(DebtBookDbData.class);
        }
        return SugarRecord.count(DebtBookDbData.class, "type = ?", new String[]{String.valueOf(type)});
    }
}
