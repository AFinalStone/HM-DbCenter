package com.hm.iou.database;

import com.hm.iou.database.table.BorrowSquareContentData;
import com.hm.iou.database.table.BorrowSquareScrollData;
import com.orm.SugarRecord;

import java.util.List;

/**
 * 借款广场数据表操作工具类
 */
public class BorrowSquareDbHelper {

    /**
     * 获取所有的滚动列表数据
     *
     * @return
     */
    public static synchronized List<BorrowSquareScrollData> getAllSquareScollData() {
        return SugarRecord.listAll(BorrowSquareScrollData.class, "sort asc");
    }

    public static synchronized void deleteAllSquareScrollData() {
        SugarRecord.deleteAll(BorrowSquareScrollData.class);
    }

    public static synchronized void saveSquareScrollData(List<BorrowSquareScrollData> list) {
        SugarRecord.deleteAll(BorrowSquareScrollData.class);
        if (!list.isEmpty()) {
            SugarRecord.saveInTx(list);
        }
    }

    public static synchronized void updateSquareScrollData(BorrowSquareScrollData data) {
        SugarRecord.update(data);
    }


    public static synchronized List<BorrowSquareContentData> getAllSquareContentData() {
        return SugarRecord.listAll(BorrowSquareContentData.class);
    }

    public static synchronized List<BorrowSquareContentData> getSquareContentByPary(String part) {
        return SugarRecord.find(BorrowSquareContentData.class, "part = ?", part);
    }

    public static synchronized void deleteAllSquareContentData() {
        SugarRecord.deleteAll(BorrowSquareContentData.class);
    }

    public static synchronized void saveSquareContentData(List<BorrowSquareContentData> list) {
        SugarRecord.deleteAll(BorrowSquareContentData.class);
        if (!list.isEmpty()) {
            SugarRecord.saveInTx(list);
        }
    }

    public static synchronized void updateSquareContentData(BorrowSquareContentData data) {
        SugarRecord.update(data);
    }

    public static synchronized long updateShowStatusByApplyId(String applyId, int showStatus) {
        List<BorrowSquareContentData> list = SugarRecord.find(BorrowSquareContentData.class, "square_apply_id = ?", applyId);
        if (list != null && list.size() > 0) {
            BorrowSquareContentData data = list.get(0);
            data.setShowStatus(showStatus);
            return data.update();
        }
        return 0L;
    }

}
