package com.itheima.recycle;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lenovo on 2016/10/10.
 */
public class MyAdapter extends BaseAdapter {

    ArrayList<Object> mDatas;
    Context context;

    public MyAdapter(ArrayList<Object> datas, Context context) {
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

        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.list_item, null);
            holder = new ViewHolder();
            holder.mImageView = (ImageView) convertView.findViewById(R.id.iv);
            holder.mTextView = (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Object data = mDatas.get(position);
        holder.mTextView.setText(data.toString());

        return convertView;
    }

    class ViewHolder {
        ImageView mImageView;
        TextView mTextView;
    }
}
