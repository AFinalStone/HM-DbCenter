package com.hm.iou.database;


import com.hm.iou.database.table.LockSignDbData;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * @author syl
 * @time 2018/6/7 上午10:26
 */
public class LockSignDbHelper {

    /**
     * 保存或更新占用签章列表
     *
     * @param list
     */
    public static synchronized void saveOrUpdateLockSignDataList(List<LockSignDbData> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        SugarRecord.saveInTx(list);
    }

    /**
     * 查询表中的所有数据
     *
     * @return
     */
    public static synchronized List<LockSignDbData> queryLockSignDataList() {
        List<LockSignDbData> list = SugarRecord.find(LockSignDbData.class,
                null, null, null, "datetime(gen_date_str) desc", null);
        if (list == null) {
            list = new ArrayList<>();
        }
        return list;
    }

    /**
     * 清空数据
     *
     * @return
     */
    public static synchronized int deleteAllLockSignDbData() {
        return SugarRecord.deleteAll(LockSignDbData.class);
    }

}