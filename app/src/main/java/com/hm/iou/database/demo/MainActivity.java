package com.hm.iou.database.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.hm.iou.database.CommentDbHelper;
import com.hm.iou.database.DebtBookDbHelper;
import com.hm.iou.database.IouDbHelper;
import com.hm.iou.database.MsgCenterDbHelper;
import com.hm.iou.database.table.DebtBookDbData;
import com.hm.iou.database.table.IouComment;
import com.hm.iou.database.table.IouData;
import com.hm.iou.database.table.MsgCenterDbData;
import com.hm.iou.logger.Logger;
import com.hm.iou.network.HttpReqManager;
import com.hm.iou.sharedata.UserManager;
import com.hm.iou.sharedata.model.BaseResponse;
import com.hm.iou.sharedata.model.UserInfo;
import com.hm.iou.tools.ToastUtil;
import com.orm.SugarRecord;
import com.sina.weibo.sdk.utils.MD5;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        findViewById(R.id.btn_test2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIOUList();
            }
        });

        findViewById(R.id.btn_test3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCommentList();
            }
        });

        findViewById(R.id.btn_test4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long cout = SugarRecord.count(IouData.class);
                ToastUtil.showMessage(MainActivity.this, "total count = " + cout);
            }
        });

        findViewById(R.id.btn_test5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long cout = SugarRecord.count(IouComment.class);
                ToastUtil.showMessage(MainActivity.this, "total count = " + cout);
            }
        });

        findViewById(R.id.btn_test6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IouData data = SugarRecord.first(IouData.class);
                List<IouData.FileEntity> list = data.getImageFiles();
                Logger.d("File size : %d", list != null ? list.size() : 0);

                if (list != null && list.size() > 0) {
                    Logger.d("first image id = %s, value = %s ", list.get(0).id, list.get(0).value);
                }
            }
        });

        findViewById(R.id.btn_test7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommentDbHelper.deleteAllCommentData();
                IouDbHelper.deleteAllIOUData();
            }
        });

        findViewById(R.id.btn_test8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Integer> iouKindList = new ArrayList<>();
                iouKindList.add(1);
                iouKindList.add(3);
                iouKindList.add(5);
                iouKindList.add(7);
                iouKindList.add(8);

                List<Integer> iouStatusList = new ArrayList<>();
                iouStatusList.add(1);
                iouStatusList.add(2);
                iouStatusList.add(5);
//                List<IouData> list = IouDbHelper.queryIOUListByStatus(iouKindList, iouStatusList, true);
//                System.out.println("size = " + (list != null ? list.size() : 0));
                System.out.println("============");
            }
        });

        findViewById(R.id.btn_test3_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<MsgCenterDbData> list = new ArrayList<>();
                MsgCenterDbData data = new MsgCenterDbData();
                data.setAutoId("1");
                data.setTitle("1");
                data.setType(1);
                data.setImageUrl("1");
                data.setPushDate("2018-06-05 12:30:56");
                MsgCenterDbHelper.addOrUpdateDataToMsgCenter(data);
                list.add(data);
                data = new MsgCenterDbData();
                data.setAutoId("2");
                data.setTitle("2");
                data.setType(2);
                data.setImageUrl("2");
                data.setPushDate("2018-05-05 12:30:56");
                MsgCenterDbHelper.addOrUpdateDataToMsgCenter(data);
                list.add(data);
                data = new MsgCenterDbData();
                data.setAutoId("3");
                data.setTitle("3");
                data.setType(3);
                data.setImageUrl("3");
                data.setPushDate("2018-07-05 12:30:56");
                MsgCenterDbHelper.addOrUpdateDataToMsgCenter(data);
                list.add(data);
            }
        });
        findViewById(R.id.btn_test3_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                MsgCenterDbData data = new MsgCenterDbData();
//                data.setAutoId("100");
//                data.setTitle("100");
//                data.setType(100);
//                data.setImageUrl("100");
//                data.setRead(true);
//                data.setPushDate("2018-06-05 12:31:56");
//                data.setNotice("系统维护");
                MsgCenterDbHelper.addOrUpdateNoticeToCache("100", "2018-06-05 12:31:56", "系统维护");
            }
        });
        findViewById(R.id.btn_test3_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long count = MsgCenterDbHelper.queryMsgCenterNoReadCount();
                System.out.println("未读消息数量" + count);
                System.out.println("============");
            }
        });
        findViewById(R.id.btn_test3_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<MsgCenterDbData> list = MsgCenterDbHelper.queryMsgCenterListData();
                for (MsgCenterDbData bean : list) {
                    System.out.println("消息内容" + bean.toString());
                    System.out.println("============");
                }
            }
        });
        findViewById(R.id.btn_test3_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MsgCenterDbHelper.deleteMsgCenterAllListData();
            }
        });
        findViewById(R.id.btn_test3_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean flag = MsgCenterDbHelper.queryNoticeById("100");
                System.out.println("是否存在" + flag);
                System.out.println("============");
            }
        });
        findViewById(R.id.btn_test4_1_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 10; i++) {
                    DebtBookDbData debtBookDbData = new DebtBookDbData();
                    debtBookDbData.setAutoId(String.format("00%d", i));
                    debtBookDbData.setCreateTime("2018.08.28 13:55:45");
                    debtBookDbData.setContent("记债本正文内容");
                    debtBookDbData.setDebtTime("2018.06.23 03:55:30");
                    debtBookDbData.setIfAddStar(1);
                    debtBookDbData.setIfHaveImg(1);
                    debtBookDbData.setLocationInfo("杭州市 西湖区");
                    debtBookDbData.setType(0);
                    DebtBookDbHelper.insertOrUpdateDebtBook(debtBookDbData);
                }
                //插入人情债
                DebtBookDbData debtBookDbData = new DebtBookDbData();
                debtBookDbData.setAutoId(String.format("00%d", 10));
                debtBookDbData.setCreateTime("2018.08.28 13:55:45");
                debtBookDbData.setContent("记债本正文内容");
                debtBookDbData.setDebtTime("2018.06.23 03:55:30");
                debtBookDbData.setIfAddStar(1);
                debtBookDbData.setIfHaveImg(1);
                debtBookDbData.setLocationInfo("杭州市 西湖区");
                debtBookDbData.setType(1);
                DebtBookDbHelper.insertOrUpdateDebtBook(debtBookDbData);
                //插入亲情债
                debtBookDbData = new DebtBookDbData();
                debtBookDbData.setAutoId(String.format("00%d", 11));
                debtBookDbData.setCreateTime("2018.08.28 13:55:45");
                debtBookDbData.setContent("记债本正文内容");
                debtBookDbData.setDebtTime("2018.06.23 03:55:30");
                debtBookDbData.setIfAddStar(1);
                debtBookDbData.setIfHaveImg(1);
                debtBookDbData.setLocationInfo("杭州市 西湖区");
                debtBookDbData.setType(2);
                DebtBookDbHelper.insertOrUpdateDebtBook(debtBookDbData);
            }
        });
        findViewById(R.id.btn_test4_2_query).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<DebtBookDbData> list = DebtBookDbHelper.queryDebtBookListByType(0);
                for (DebtBookDbData item : list) {
                    Log.d("记债本", "数据: " + item.toString());
                }
                list = DebtBookDbHelper.queryDebtBookListByType(1);
                for (DebtBookDbData item : list) {
                    Log.d("记债本", "人情债: " + item.toString());
                }
                list = DebtBookDbHelper.queryDebtBookListByType(2);
                for (DebtBookDbData item : list) {
                    Log.d("记债本", "亲情债: " + item.toString());
                }
            }
        });
        findViewById(R.id.btn_test4_3_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DebtBookDbData debtBookDbData = new DebtBookDbData();
                debtBookDbData.setAutoId("001");
                debtBookDbData.setCreateTime("2018.08.28 13:55:45");
                debtBookDbData.setContent("记债本正文内容被修改");
                debtBookDbData.setDebtTime("2018.06.23 03:55:30");
                debtBookDbData.setIfAddStar(0);
                debtBookDbData.setIfHaveImg(0);
                debtBookDbData.setLocationInfo("北京市 朝阳区");
                DebtBookDbHelper.insertOrUpdateDebtBook(debtBookDbData);
            }
        });
        findViewById(R.id.btn_test4_4_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DebtBookDbHelper.deleteDebtBookById("000");
            }
        });
        findViewById(R.id.btn_test4_5_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DebtBookDbHelper.deleteAllDebtBookData();
            }
        });
        findViewById(R.id.btn_test4_6_queryCount).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long num = DebtBookDbHelper.queryDebtBookListCount(0);
                Log.d("记债本", "全部数量: " + num);
                num = DebtBookDbHelper.queryDebtBookListCount(1);
                Log.d("记债本", "人情债数量: " + num);
            }
        });

    }


    private void login() {
        String pwd = MD5.hexdigest("123456".getBytes());
        MobileLoginReqBean reqBean = new MobileLoginReqBean();
        reqBean.setMobile("15967132742");
        reqBean.setQueryPswd(pwd);
        HttpReqManager.getInstance().getService(JietiaoService.class)
                .mobileLogin(reqBean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseResponse<UserInfo>>() {
                    @Override
                    public void accept(BaseResponse<UserInfo> userInfoBaseResponse) throws Exception {
                        ToastUtil.showMessage(MainActivity.this, "登录成功");
                        UserInfo userInfo = userInfoBaseResponse.getData();
                        UserManager.getInstance(MainActivity.this).updateOrSaveUserInfo(userInfo);
                        HttpReqManager.getInstance().setUserId(userInfo.getUserId());
                        HttpReqManager.getInstance().setToken(userInfo.getToken());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable t) throws Exception {
                        t.printStackTrace();
                    }
                });
    }

    private void getIOUList() {
        IOUListReqBean reqBean = new IOUListReqBean();
        reqBean.setNeedRefresh(true);
        reqBean.setLastReqDate(null);
        HttpReqManager.getInstance().getService(JietiaoService.class)
                .getIOUList(reqBean)
                .map(new Function<BaseResponse<IOUListResult>, Boolean>() {
                    @Override
                    public Boolean apply(BaseResponse<IOUListResult> response) throws Exception {
                        if (response.getErrorCode() == 0) {
                            IOUListResult result = response.getData();
                            Logger.d("获取数据成功....");
                            IouDbHelper.saveOrUpdateIouList(result.getAddOrUpdate());
                        }
                        return true;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        ToastUtil.showMessage(MainActivity.this, "获取数据成功");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });


    }

    private void getCommentList() {
        IOUListReqBean reqBean = new IOUListReqBean();
        reqBean.setNeedRefresh(true);
        reqBean.setLastReqDate(null);
        HttpReqManager.getInstance().getService(JietiaoService.class)
                .getIOUCommentList(reqBean)
                .map(new Function<BaseResponse<IOUCommentResult>, Boolean>() {
                    @Override
                    public Boolean apply(BaseResponse<IOUCommentResult> response) throws Exception {
                        if (response.getErrorCode() == 0) {
                            IOUCommentResult result = response.getData();
                            Logger.d("获取数据成功....");
                            CommentDbHelper.saveOrUpdateCommentList(result.getAddOrUpdate());
                        }
                        return true;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        ToastUtil.showMessage(MainActivity.this, "获取数据成功");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });


    }

}
