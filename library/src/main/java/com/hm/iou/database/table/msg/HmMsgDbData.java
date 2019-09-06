package com.hm.iou.database.table.msg;

import android.text.TextUtils;

import com.orm.annotation.Ignore;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author syl
 * @time 2018/6/7 上午10:26
 */
public class HmMsgDbData extends BaseMsgDbData {
    /**
     * contentCollectId : 0
     * imgUrl : string
     * jumpUrl : string
     * sourceBizType : 0
     * startTime : 2019-04-16T12:51:15.705Z
     * title : string
     */

    private String contentCollectId;
    private String imgUrl;
    private String jumpUrl;
    private int sourceBizType;   //10=广告模块，20=资讯模块, 30=意见反馈结果 100=="官方公告"
    private String startTime;
    private String title;        //标题
    private String notice;       //官方公告简介
    private String content;
    @Ignore
    private List<String> imgUrlList;        //图片

    private String imgs;

    public String getContentCollectId() {
        return contentCollectId;
    }

    public void setContentCollectId(String contentCollectId) {
        this.contentCollectId = contentCollectId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

    public int getSourceBizType() {
        return sourceBizType;
    }

    public void setSourceBizType(int sourceBizType) {
        this.sourceBizType = sourceBizType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getImgUrlList() {
        return imgUrlList;
    }

    public void setImgUrlList(List<String> imgUrlList) {
        this.imgUrlList = imgUrlList;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    /**
     * 将图片 List 转换为 JSONArray 格式的字符串，便于数据库字段存储
     */
    public void convertImgListToString() {
        if (TextUtils.isEmpty(imgs) && imgUrlList != null && imgUrlList.size() > 0) {
            try {
                JSONArray array = new JSONArray();
                for (String url : imgUrlList) {
                    array.put(url);
                }
                imgs = array.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从数据库里读取图片数据时，将字符串转换为图片 List
     *
     * @return
     */
    public List<String> getImgListFromDb() {
        if (imgUrlList != null)
            return imgUrlList;
        if (TextUtils.isEmpty(imgs))
            return null;
        try {
            List<String> list = new ArrayList<>();
            JSONArray arr = new JSONArray(imgs);
            for (int i = 0; i < arr.length(); i++) {
                list.add(arr.getString(i));
            }
            imgUrlList = list;
            return imgUrlList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}