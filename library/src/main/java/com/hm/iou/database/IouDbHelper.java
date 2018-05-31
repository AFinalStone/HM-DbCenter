package com.hm.iou.database;


import android.util.Log;

import com.hm.iou.database.table.IouComment;
import com.hm.iou.database.table.IouData;
import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by hjy on 2018/5/30.
 */

public class IouDbHelper {

    /**
     * 删除所有的借条数据
     *
     * @return
     */
    public static synchronized int deleteAllIOUData() {
        return SugarRecord.deleteAll(IouData.class);
    }

    /**
     * 保存或更新借条数据
     *
     * @param list
     * @return
     */
    public static synchronized void saveOrUpdateIouList(List<IouData> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (IouData data : list) {
            data.convertFileMapToJson();
        }
        SugarRecord.saveInTx(list);
    }

    /**
     * 查询借条数据
     *
     * @param iouKindList 借条类型，不能为空
     * @param iouStatusList 借条状态，不穿则查询所有状态
     * @param orderByCreateTime true-根据收录时间排序
     * @return
     */
    public static synchronized List<IouData> queryIOUListByStatus(List<Integer> iouKindList,
                                                                  List<Integer> iouStatusList,
                                                                  boolean orderByCreateTime) {
        if (iouKindList == null || iouKindList.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("iou_kind in (");
        int c = iouKindList.size();
        for (int i = 0; i < c; i++) {
            sb.append(iouKindList.get(i));
            if (i < c - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        if (iouStatusList != null && iouStatusList.size() > 0) {
            sb.append(" and ");
            sb.append("iou_status in (");
            c = iouStatusList.size();
            for (int i=0; i<c; i++) {
                sb.append(iouStatusList.get(i));
                if (i < c - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
        }

        String whereClause = sb.toString();
        Log.d("SQL", whereClause);
        String orderBy = orderByCreateTime ? "last_modify_time desc" : "schedule_return_date desc";
        List<IouData> list = SugarRecord.find(IouData.class, whereClause, null, null,  orderBy, null);
        return list;
    }

    /**
     * 更新借条数据
     *
     * @param data
     * @return
     */
    public static synchronized long updateIOUData(IouData data) {
        return SugarRecord.update(data);
    }

    /**
     * 删除借条数据
     *
     * @param iouId 借条id
     * @return
     */
    public static synchronized int deleteIOUData(String iouId) {
        return SugarRecord.deleteAll(IouData.class, "iou_id = ?", iouId);
    }

    /**
     * 查询借条数
     *
     * @param iouKind 借条类型
     * @return
     */
    public static synchronized long queryCountOfIou(int iouKind) {
        return SugarRecord.count(IouData.class, "iou_kind = " + iouKind, null);
    }

    /**
     * 查询借条数
     *
     * @param iouKind 借条类型
     * @param iouStatus 借条状态
     * @return
     */
    public static synchronized long queryCountOfIou(int iouKind, int iouStatus) {
        return SugarRecord.count(IouData.class, "iou_kind = ? and iou_status = ?",
                new String[] {iouKind + "", iouStatus + ""});
    }

}