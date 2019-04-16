package com.fly.tour.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fly.tour.common.mvp.BaseModel;
import com.fly.tour.common.mvp.BasePresenter;

/**
 * Description: <BaseMvpActivity><br>
 * Author:      gxl<br>
 * Date:        2018/6/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public abstract class BaseMvpActivity<M extends BaseModel,V,P extends BasePresenter<M,V>> extends BaseActivity {
    protected P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = initPresenter();
        if(mPresenter != null){
            mPresenter.attach((V) this);
            mPresenter.injectLifecycle(this);
        }
        super.onCreate(savedInstanceState);

    }
    public abstract P initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null){
            mPresenter.detach();
        }
    }
}
