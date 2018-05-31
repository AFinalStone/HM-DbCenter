package com.hm.iou.database.demo;

import com.hm.iou.database.table.IouComment;
import com.hm.iou.database.table.IouData;

import java.util.List;

/**
 * Created by hjy on 2018/5/30.
 */

public class IOUCommentResult {

    private List<IouComment> addOrUpdate;
    private List<String> delete;
    private String pullDate;

    public List<IouComment> getAddOrUpdate() {
        return addOrUpdate;
    }

    public void setAddOrUpdate(List<IouComment> addOrUpdate) {
        this.addOrUpdate = addOrUpdate;
    }

    public List<String> getDelete() {
        return delete;
    }

    public void setDelete(List<String> delete) {
        this.delete = delete;
    }

    public String getPullDate() {
        return pullDate;
    }

    public void setPullDate(String pullDate) {
        this.pullDate = pullDate;
    }
}
