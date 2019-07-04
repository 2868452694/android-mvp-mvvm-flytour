package com.fly.tour.me;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.databinding.ObservableList;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.fly.tour.api.newstype.entity.NewsType;
import com.fly.tour.common.event.RequestCode;
import com.fly.tour.common.mvvm.BaseMvvmActivity1;
import com.fly.tour.common.mvvm.BaseMvvmRefreshActivity;
import com.fly.tour.common.mvvm.BaseMvvmRefreshActivity1;
import com.fly.tour.common.util.ObservableListUtil;
import com.fly.tour.common.util.ToastUtil;
import com.fly.tour.common.view.CommonDialogFragment;
import com.fly.tour.me.adapter.NewsTypeShowAdapter;
import com.fly.tour.me.adapter.NewsTypeShowBindingAdapter;
import com.fly.tour.me.databinding.ActivityNewsTypeListBinding;
import com.fly.tour.me.mvvm.factory.MeViewModelFactory;
import com.fly.tour.me.mvvm.viewmodel.NewsTypeListViewModel;
import com.refresh.lib.DaisyRefreshLayout;

import java.util.List;

/**
 * Description: <NewsTypeListActivity><br>
 * Author:      mxdl<br>
 * Date:        2019/07/02<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsTypeListActivity extends BaseMvvmActivity1<ActivityNewsTypeListBinding, NewsTypeListViewModel> {

    private NewsTypeShowBindingAdapter mNewsTypeShowAdapter;

    public int onBindLayout() {
        return R.layout.activity_news_type_list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.menu_add) {
            startActivityForResult(new Intent(this, NewsTypeAddActivity.class), RequestCode.Me.NEWS_TYPE_ADD);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void initView() {
        mNewsTypeShowAdapter = new NewsTypeShowBindingAdapter(this, mViewModel.getList());
        mViewModel.getList().addOnListChangedCallback(ObservableListUtil.getListChangedCallback(mNewsTypeShowAdapter));
        mBinding.recview.setAdapter(mNewsTypeShowAdapter);
    }

    @Override
    public void initListener() {
        mNewsTypeShowAdapter.setDeleteClickLisenter(new NewsTypeShowBindingAdapter.DeleteClickLisenter() {
            @Override
            public void onClickDeleteListener(final int id) {
                new CommonDialogFragment.Builder().setTitle("信息提示").setDescribe("确定删除吗？").setLeftbtn("取消").setRightbtn("确定").setOnDialogClickListener(new CommonDialogFragment.OnDialogClickListener() {
                    @Override
                    public void onLeftBtnClick(View view) {
                    }

                    @Override
                    public void onRightBtnClick(View view) {
                        mViewModel.deleteNewsTypeById(id);
                    }
                }).build().show(getSupportFragmentManager(), "dialog");
            }
        });
    }

    @Override
    public void initData() {
        mViewModel.refreshData();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case RequestCode.Me.NEWS_TYPE_ADD:
                if (resultCode == Activity.RESULT_OK) {
                    mViewModel.refreshData();
                }
                break;
        }
    }

    @Override
    public Class<NewsTypeListViewModel> onBindViewModel() {
        return NewsTypeListViewModel.class;
    }

    @Override
    public ViewModelProvider.Factory onBindViewModelFactory() {
        return MeViewModelFactory.getInstance(getApplication());
    }

    @Override
    public void initViewObservable() {

    }

    @Override
    public int onBindVariableId() {
        return BR.viewModel;
    }
}
