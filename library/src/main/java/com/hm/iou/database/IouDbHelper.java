package com.hm.iou.database;


import android.text.TextUtils;
import android.util.Log;

import com.hm.iou.database.table.IouComment;
import com.hm.iou.database.table.IouData;
import com.orm.SugarContext;
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
     * 通过借条id查询
     *
     * @param iouId 借条id
     * @return
     */
    public static synchronized IouData queryIOUById(String iouId) {
        List<IouData> list = SugarRecord.find(IouData.class, "iou_id = ?", new String[]{iouId});
        if (list == null || list.isEmpty())
            return null;
        return list.get(0);
    }

    /**
     * 通过借条id查询
     *
     * @param justiceId 借条公证id
     * @return
     */
    public static synchronized IouData queryIOUByJusticeId(String justiceId) {
        List<IouData> list = SugarRecord.find(IouData.class, "justice_id = ?", new String[]{justiceId});
        if (list == null || list.isEmpty())
            return null;
        return list.get(0);
    }

    /**
     * 通过借条id删除数据
     *
     * @param iouId 借条id
     * @return
     */
    public static synchronized int deleteIOUById(String iouId) {
        return SugarRecord.deleteAll(IouData.class, "iou_id = ?", new String[]{iouId});
    }

    /**
     * 查询借条数据
     *
     * @param iouKindList       借条类型，不能为空
     * @param iouStatusList     借条状态，不传则查询所有状态
     * @param orderByCreateTime "asc"：表示按创建或修改时间升序排列，"desc"：表示按降序排列，null表示不排列
     * @param orderByReturnDate "asc"：按归还时间升序排列，"desc"：表示按降序排列，null表示不排列
     * @return
     */
    public static synchronized List<IouData> queryIOUListByStatus(List<Integer> iouKindList,
                                                                  List<Integer> iouStatusList,
                                                                  String orderByCreateTime,
                                                                  String orderByReturnDate) {
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
            for (int i = 0; i < c; i++) {
                sb.append(iouStatusList.get(i));
                if (i < c - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
        }
        String whereClause = sb.toString();

        String orderBy = null;
        if (!TextUtils.isEmpty(orderByCreateTime)) {
            if ("asc".equals(orderByCreateTime.toLowerCase())) {
                orderBy = "last_modify_time asc";
            } else if ("desc".equals(orderByCreateTime.toLowerCase())) {
                orderBy = "last_modify_time desc";
            }
        }

        if (!TextUtils.isEmpty(orderByReturnDate)) {
            if ("asc".equals(orderByReturnDate.toLowerCase())) {
                orderBy = TextUtils.isEmpty(orderBy) ? "" : (orderBy + ",");
                orderBy = orderBy + "schedule_return_date asc";
            } else if ("desc".equals(orderByReturnDate.toLowerCase())) {
                orderBy = TextUtils.isEmpty(orderBy) ? "" : (orderBy + ",");
                orderBy = orderBy + "schedule_return_date desc";
            }
        }

        List<IouData> list = SugarRecord.find(IouData.class, whereClause, null, null, orderBy, null);
        return list;
    }

    /**
     * 查询借条数据
     *
     * @param iouKindList       借条类型，不能为空
     * @param status            借条状态
     * @param orderByCreateTime "asc"：表示按创建或修改时间升序排列，"desc"：表示按降序排列，null表示不排列
     * @param orderByReturnDate "asc"：按归还时间升序排列，"desc"：表示按降序排列，null表示不排列
     * @return
     */
    public static synchronized List<IouData> queryIOUListByStatus(List<Integer> iouKindList,
                                                                  int status,
                                                                  String orderByCreateTime,
                                                                  String orderByReturnDate) {
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
        sb.append(" and ");
        sb.append("iou_status = ").append(status);
        String whereClause = sb.toString();


        String orderBy = null;
        if (!TextUtils.isEmpty(orderByCreateTime)) {
            if ("asc".equals(orderByCreateTime.toLowerCase())) {
                orderBy = "last_modify_time asc";
            } else if ("desc".equals(orderByCreateTime.toLowerCase())) {
                orderBy = "last_modify_time desc";
            }
        }

        if (!TextUtils.isEmpty(orderByReturnDate)) {
            if ("asc".equals(orderByReturnDate.toLowerCase())) {
                orderBy = TextUtils.isEmpty(orderBy) ? "" : (orderBy + ",");
                orderBy = orderBy + "schedule_return_date asc";
            } else if ("desc".equals(orderByReturnDate.toLowerCase())) {
                orderBy = TextUtils.isEmpty(orderBy) ? "" : (orderBy + ",");
                orderBy = orderBy + "schedule_return_date desc";
            }
        }

        List<IouData> list = SugarRecord.find(IouData.class, whereClause, null, null, orderBy, null);
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

    public static synchronized long saveIOUData(IouData data) {
        return data.save();
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
     * @param iouKind   借条类型
     * @param iouStatus 借条状态
     * @return
     */
    public static synchronized long queryCountOfIou(int iouKind, int iouStatus) {
        return SugarRecord.count(IouData.class, "iou_kind = ? and iou_status = ?",
                new String[]{iouKind + "", iouStatus + ""});
    }

    public static synchronized long queryCountOfIou(List<Integer> iouKindList) {
        if (iouKindList == null || iouKindList.isEmpty()) {
            return SugarRecord.count(IouData.class);
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

        return SugarRecord.count(IouData.class, sb.toString(), null);
    }

    public static synchronized long queryCountOfIou(List<Integer> iouKindList, int iouStatus) {
        if (iouKindList == null || iouKindList.isEmpty()) {
            return SugarRecord.count(IouData.class);
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
        sb.append(" and iou_status = ").append(iouStatus);
        return SugarRecord.count(IouData.class, sb.toString(), null);
    }

    public static synchronized long queryCountOfIou(List<Integer> iouKindList, List<Integer> iouStatusList) {
        if (iouKindList == null || iouKindList.isEmpty()) {
            return SugarRecord.count(IouData.class);
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
            for (int i = 0; i < c; i++) {
                sb.append(iouStatusList.get(i));
                if (i < c - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
        }
        return SugarRecord.count(IouData.class, sb.toString(), null);
    }

    public static synchronized long queryCountOfIouByStatus(List<Integer> iouStatusList) {
        if (iouStatusList == null || iouStatusList.isEmpty()) {
            return SugarRecord.count(IouData.class);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("iou_status in (");
        int c = iouStatusList.size();
        for (int i = 0; i < c; i++) {
            sb.append(iouStatusList.get(i));
            if (i < c - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        return SugarRecord.count(IouData.class, sb.toString(), null);
    }

}