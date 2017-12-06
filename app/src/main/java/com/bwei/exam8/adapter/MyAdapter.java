package com.bwei.exam8.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwei.exam8.R;
import com.bwei.exam8.bean.DataDataBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by acer on 2017/12/6.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    List<DataDataBean.NewslistBean> list;
    public static final int title = 0;
    public static final int image = 1;

    public MyAdapter(Context context) {
        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = View.inflate(context, R.layout.title, null);
            IViewHolder iViewHolder = new IViewHolder(view);
            return iViewHolder;

        } else {

            View view = View.inflate(context, R.layout.image, null);
            PViewHolder pViewHolder = new PViewHolder(view);
            return pViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case 0:
                IViewHolder holder1= (IViewHolder) holder;
                holder1.title2.setText(list.get(position).getTitle());

                break;
            case 1:
                PViewHolder holder2= (PViewHolder) holder;
                holder2.simpleDraweeview.setImageURI(list.get(position).getPicUrl());
                holder2.title.setText(list.get(position).getTitle());
                break;

        }

    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void addData(DataDataBean bean) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.addAll(bean.getNewslist());
        notifyDataSetChanged();

    }

    static class IViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title2)
        TextView title2;

        IViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class PViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.simple_draweeview)
        SimpleDraweeView simpleDraweeview;
        @BindView(R.id.title)
        TextView title;

        PViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
