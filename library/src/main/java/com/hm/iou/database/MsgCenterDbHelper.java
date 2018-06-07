package com.hm.iou.database;


import android.util.Log;

import com.hm.iou.database.table.MsgCenterDbData;
import com.orm.SugarRecord;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author syl
 * @time 2018/6/7 上午10:26
 */
public class MsgCenterDbHelper {

    /**
     * 添加或更新消息中心消息列表
     *
     * @param msgItem
     */
    public static synchronized void addOrUpdateDataToMsgCenter(MsgCenterDbData msgItem) {
        if (msgItem == null) {
            return;
        }
        SugarRecord.saveInTx(msgItem);
    }

    /**
     * 添加或更新消息中心消息列表
     *
     * @param list
     */
    public static synchronized void addOrUpdateDataToMsgCenter(List<MsgCenterDbData> list) {
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
        MsgCenterDbData dbData = new MsgCenterDbData();
        noticeId = "notice_" + noticeId;//防止和消息中心其他类型的id重复
        dbData.setType(100); //这里主要是为了在消息中心获取的时候，进行分类比较使用
        dbData.setAutoId(noticeId);
        dbData.setPushDate(pushDate);
        dbData.setRead(true);
        dbData.setNotice(notice);
        addOrUpdateDataToMsgCenter(dbData);
    }

    /**
     * 根据光放公告id查询官方公告
     *
     * @param noticeId 官方公告id
     * @return
     */
    public static synchronized boolean queryNoticeById(String noticeId) {
        noticeId = "notice_" + noticeId;//防止和消息中心其他类型的id重复
        return !(null == queryMsgCenterItemByAutoId(noticeId));
    }

    /**
     * 查询消息中心未读消息数量
     *
     * @return
     */
    public static synchronized long queryMsgCenterNoReadCount() {
        return SugarRecord.count(MsgCenterDbData.class, "is_read = 0", null);
    }

    /**
     * 获取消息中心的所有消息列表
     *
     * @return
     */
    public static synchronized List<MsgCenterDbData> queryMsgCenterListData() {
        Date currentDate = new Date(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_YEAR, -15);
        Date outDateFlag = calendar.getTime();
        String outTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(outDateFlag);
        Log.e("过期的Date时间：", outTime);
        //删除过期的数据
//        SugarRecord.executeQuery("delete from MSG_CENTER_DB_DATA where datetime(push_date) < datetime(?)", outTime);
        SugarRecord.deleteAll(MsgCenterDbData.class, "datetime(push_date) < datetime(?)", outTime);
        //获取缓存数据
//        List<MsgCenterDbData> list = SugarRecord.findWithQuery(MsgCenterDbData.class,
//                "select * from MSG_CENTER_DB_DATA order by datetime(push_date) desc");
        List<MsgCenterDbData> list = SugarRecord.find(MsgCenterDbData.class,
                null, null, null, "datetime(push_date) desc", null);
        return list;
    }


    /**
     * 删除所有的消息中心数据
     *
     * @return
     */
    public static synchronized int deleteMsgCenterAllListData() {
        return SugarRecord.deleteAll(MsgCenterDbData.class);
    }

    /**
     * 通过id查询消息是否存在
     *
     * @param autoId
     * @return
     */
    private static synchronized MsgCenterDbData queryMsgCenterItemByAutoId(String autoId) {
        List<MsgCenterDbData> list = SugarRecord.find(MsgCenterDbData.class, "auto_id = ?", autoId);
        if (list == null || list.isEmpty())
            return null;
        return list.get(0);
    }

}