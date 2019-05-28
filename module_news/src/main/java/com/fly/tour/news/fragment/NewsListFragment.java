package com.fly.tour.news.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fly.tour.common.base.BaseFragment;
import com.fly.tour.common.base.BaseRefreshFragment;
import com.fly.tour.common.event.KeyCode;
import com.fly.tour.common.mvp.BaseRefreshPresenter;
import com.fly.tour.db.entity.NewsDetail;
import com.fly.tour.db.entity.NewsType;
import com.fly.tour.news.adapter.NewsListAdatper;
import com.fly.tour.news.contract.NewsListContract;
import com.fly.tour.news.model.NewsListModel;
import com.fly.tour.news.presenter.NewsListPresenter;
import com.fly.tour.trip.R;

import java.util.List;

/**
 * Description: <人工智能><br>
 * Author:      gxl<br>
 * Date:        2018/12/11<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class NewsListFragment extends BaseRefreshFragment<NewsListModel,NewsListContract.View<NewsDetail>,NewsListPresenter,NewsDetail> implements NewsListContract.View<NewsDetail>{

    private NewsType mNewsType;
    private RecyclerView mRecViewNewsDetail;
    private NewsListAdatper mNewsListAdatper;

    public static NewsListFragment newInstance(NewsType newsType) {
        NewsListFragment newsListFragment = new NewsListFragment();
        Bundle args = new Bundle();
        args.putParcelable(KeyCode.News.NEWS_TYPE,newsType);
        newsListFragment.setArguments(args);

        return newsListFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mNewsType = getArguments().getParcelable(KeyCode.News.NEWS_TYPE);
    }

    @Override
    public int onBindLayout() {
        return R.layout.fragment_news_list;
    }

    @Override
    public void initView(View view) {
        mRecViewNewsDetail = view.findViewById(R.id.recview_news_list);
        mRecViewNewsDetail.setLayoutManager(new LinearLayoutManager(mActivity));
        mNewsListAdatper = new NewsListAdatper(mActivity);
        mRecViewNewsDetail.setAdapter(mNewsListAdatper);
    }

    @Override
    public void initData() {
        mPresenter.setNewsType(mNewsType.getId());
        autoLoadData();

    }

    @Override
    public String getToolbarTitle() {
        return null;
    }

    @Override
    protected int onBindRreshLayout() {
        return R.id.refview_news_list;
    }

    @Override
    public NewsListPresenter initPresenter() {
        return new NewsListPresenter(mActivity);
    }



    @Override
    public void onRefreshEvent() {
        mPresenter.refreshData();
    }

    @Override
    public void onLoadMoreEvent() {
        mPresenter.loadMoreData();
    }

    @Override
    public void onAutoLoadEvent() {
        mPresenter.refreshData();
    }

    @Override
    public void refreshData(List<NewsDetail> data) {
        mNewsListAdatper.refresh(data);
    }

    @Override
    public void loadMoreData(List<NewsDetail> data) {
        mNewsListAdatper.addAll(data);
    }
}
