package com.hm.iou.database.table.msg;

import com.orm.SugarRecord;
import com.orm.annotation.Unique;

/**
 * Created by syl on 2019/5/22.
 */

public class BaseMsgDbData extends SugarRecord {
    @Unique
    private String msgId;
    private String type;
    private boolean isHaveRead;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isHaveRead() {
        return isHaveRead;
    }

    public void setHaveRead(boolean haveRead) {
        isHaveRead = haveRead;
    }

    @Override
    public String toString() {
        return "BaseMsgDbData{" +
                "msgId='" + msgId + '\'' +
                ", type='" + type + '\'' +
                ", isHaveRead=" + isHaveRead +
                '}';
    }
}
