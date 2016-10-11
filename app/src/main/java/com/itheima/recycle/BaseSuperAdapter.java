package com.itheima.recycle;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 2016/10/10.
 * 升级版ListView的Adapter -- 抽取父类
 */
public abstract class BaseSuperAdapter<T extends BaseSuperAdapter.ViewHolder> extends BaseAdapter {

    ArrayList<Object> mDatas;
    Context context;

    public BaseSuperAdapter(ArrayList<Object> datas, Context context) {
        mDatas = datas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        T holder;
        if (convertView== null){
            holder = onCreateViewHolder(parent);
        }else {
            holder = (T) convertView.getTag();
        }

        //设置数据
        onBindViewHolder(holder,position);
        return holder.rootView;
    }

    public abstract T onCreateViewHolder(ViewGroup parent);

    public abstract void onBindViewHolder(T holder, int position);

    public class ViewHolder {
        View rootView;

        public ViewHolder(View convertView){
            rootView = convertView;
            convertView.setTag(this);
        }
    }
}
