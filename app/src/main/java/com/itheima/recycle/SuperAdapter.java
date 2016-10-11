package com.itheima.recycle;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lenovo on 2016/10/10.
 * 升级版ListView的Adapter -- 子类
 */
public class SuperAdapter extends BaseSuperAdapter<SuperAdapter.MyViewHolder> {
    ArrayList<Object> mDatas;
    Context context;

    public SuperAdapter(ArrayList<Object> datas, Context context) {
        super(datas, context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = View.inflate(context,R.layout.list_item,null);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Object data = mDatas.get(position);
        holder.mTextView.setText(data.toString());
    }




    public class MyViewHolder extends BaseSuperAdapter.ViewHolder{
        ImageView mImageView;
        TextView mTextView;

        public MyViewHolder(View convertView) {
            super(convertView);
            mImageView = (ImageView) convertView.findViewById(R.id.iv);
            mTextView = (TextView) convertView.findViewById(R.id.tv);
        }
    }
}
