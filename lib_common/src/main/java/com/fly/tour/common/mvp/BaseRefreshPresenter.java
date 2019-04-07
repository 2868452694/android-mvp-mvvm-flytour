package com.zjx.vcars.common.mvp;

import android.content.Context;

/**
 * Description: <BaseRefreshPresenter><br>
 * Author:      gxl<br>
 * Date:        2019/2/26<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public abstract class BaseRefreshPresenter<M extends BaseModel,V extends BaseRefreshView<T>,T> extends BasePresenter<M,V> implements BaseRefreshContract.Presenter{
    public BaseRefreshPresenter(Context context) {
        super(context);
    }
}
