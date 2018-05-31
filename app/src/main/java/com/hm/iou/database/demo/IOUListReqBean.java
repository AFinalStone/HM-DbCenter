package com.hm.iou.database.demo;

/**
 * Created by hjy on 2018/5/30.
 */

public class IOUListReqBean {

    private String lastReqDate;
    private boolean needRefresh;

    public String getLastReqDate() {
        return lastReqDate;
    }

    public void setLastReqDate(String lastReqDate) {
        this.lastReqDate = lastReqDate;
    }

    public boolean isNeedRefresh() {
        return needRefresh;
    }

    public void setNeedRefresh(boolean needRefresh) {
        this.needRefresh = needRefresh;
    }
}
