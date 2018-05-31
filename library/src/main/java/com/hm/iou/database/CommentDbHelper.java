package com.hm.iou.database;


import com.hm.iou.database.table.IouComment;
import com.hm.iou.database.table.IouData;
import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by hjy on 2018/5/30.
 */

public class CommentDbHelper {

    /**
     * 删除所有的评论数据
     *
     * @return
     */
    public static synchronized int deleteAllCommentData() {
        return SugarRecord.deleteAll(IouComment.class);
    }

    /**
     * 保存或更新评论列表
     *
     * @param list
     */
    public static synchronized void saveOrUpdateCommentList(List<IouComment> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        SugarRecord.saveInTx(list);
    }

    /**
     * 根据借条id查询评论
     *
     * @param iouId
     * @return
     */
    public static synchronized List<IouComment> queryCommentList(String iouId) {
        List<IouComment> list = SugarRecord.find(IouComment.class, "iou_id = ?",
                new String[]{iouId}, null, "create_time asc", null);
        return list;
    }

    /**
     * 通过评论id删除评论
     *
     * @param commentId
     * @return
     */
    public static synchronized int deleteCommentById(String commentId) {
        return SugarRecord.deleteAll(IouComment.class, "comment_id = ?", commentId);
    }

    /**
     * 通过借条id删除评论
     *
     * @param iouId
     * @return
     */
    public static synchronized int deleteCommentByIouId(String iouId) {
        return SugarRecord.deleteAll(IouComment.class, "iou_id = ?", iouId);
    }

    /**
     * 更新评论
     *
     * @param data
     * @return
     */
    public static synchronized long updateComment(IouComment data) {
        return data.update();
    }

}