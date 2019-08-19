package com.thanksyoung.yyplayer.base;

import android.content.Context;
import android.view.View;

public abstract class BasePager {
    /**
     * 上下文
     */
    public final Context context;
    public View rootview;
    /**
     * 标志着本页面是否被初始化过
     */
    public boolean isInit;

    public BasePager(Context context){
        this.context = context;
        this.rootview = initView();
    }

    /**
     * 由孩子实现
     * @return
     */
    public abstract View initView();

    /**
     * 当子页面需要初始化数据，联网请求，则重写该方法
     */
    public void initData(){

    }
}
