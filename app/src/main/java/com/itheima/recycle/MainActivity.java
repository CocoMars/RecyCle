package com.itheima.recycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.recy)
    RecyclerView mRecy;
    private ListRecyclerAdapter mAdapter;
    ArrayList<String> Datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecy.setLayoutManager(layoutManager);

        //设置Adapter
        if (mAdapter == null) {
            Datas = new ArrayList<>();
            for (int i = 0; i < 50; i++) {

                Datas.add(i + "At last you and me");
            }

            mAdapter = new ListRecyclerAdapter(Datas, this);
            mRecy.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }


    }

}
