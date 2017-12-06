package com.bwei.exam8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.bwei.exam8.adapter.MyAdapter;
import com.bwei.exam8.bean.DataDataBean;
import com.bwei.exam8.presenter.MainPresenter;
import com.bwei.exam8.view.MainView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements MainView{

    @BindView(R.id.xrecyclerview)
    XRecyclerView xrecyclerview;
    private MainPresenter presenter;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(this);
        presenter.get();
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        adapter = new MyAdapter(this);
        xrecyclerview.setLayoutManager(manager);
        xrecyclerview.setAdapter(adapter);

        xrecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
           @Override
           public void onRefresh() {
               presenter.get();
               xrecyclerview.refreshComplete();
           }

           @Override
           public void onLoadMore() {
               presenter.get();
               xrecyclerview.loadMoreComplete();
           }
       });
    }

    @Override
    public void success(DataDataBean bean) {
       adapter.addData(bean);
    }

    @Override
    public void failure(Exception e) {

    }
}
