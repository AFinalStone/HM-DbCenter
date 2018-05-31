package com.hm.iou.database.demo;

import com.hm.iou.database.table.IouData;
import com.hm.iou.sharedata.model.BaseResponse;
import com.hm.iou.sharedata.model.UserInfo;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by hjy on 2018/5/29.
 */

public interface JietiaoService {

    @POST("/api/iou/user/v1/mobileLogin")
    Flowable<BaseResponse<UserInfo>> mobileLogin(@Body MobileLoginReqBean mobileLoginReqBean);


    @POST("/api/iou/front/v1/getIOUCache")
    Flowable<BaseResponse<IOUListResult>> getIOUList(@Body IOUListReqBean reqBean);

    @POST("/api/iou/front/v1/getIOUCommentCache")
    Flowable<BaseResponse<IOUCommentResult>> getIOUCommentList(@Body IOUListReqBean reqBean);

}
