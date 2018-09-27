package com.example.jack.dogsmaganerapp.Activity;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jack.dogsmaganerapp.R;
import com.example.jack.dogsmaganerapp.object.Bulletin;
import com.example.jack.dogsmaganerapp.object.New;
import com.example.jack.dogsmaganerapp.user_defined_adapter.RecyBulletinAdapter;
import com.example.jack.dogsmaganerapp.user_defined_adapter.RecyNewsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * BackgroundLibrary使用方法：
 * 1.在super.onCreate方法之前调用
 */

public class MainActivity extends BaseActivity {

    private List<Bulletin> bulletinsList;
    private List<New> newsList;
    private RecyclerView recy_bulletins;
    private RecyclerView recy_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        初始化bulletinList数据
        bulletinsList = initBulletinList();
//        初始化newsList数据
        newsList = initNewList();

//        设置bulletinRecy，绑定adapter
        setBulletinRecy();
//        设置bulletinRecy，绑定adapter
        setNewsRecy();

    }
//        设置bulletinRecy，绑定adapter
    private void setNewsRecy() {
        //        初始化recy
        recy_news = (RecyclerView)findViewById(R.id.recy_new);
//        设置recy布局方式为线性布局,默认垂直排列
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recy_news.setLayoutManager(layoutManager);
//        创建adapter
        RecyNewsAdapter adapter = new RecyNewsAdapter(newsList,getApplicationContext());
        recy_news.setAdapter(adapter);
    }

//        初始化bulletinList数据
    private List<New> initNewList() {
        List<New> news = new ArrayList<>();

       for (int i = 0;i<10;i++){
           news.add(new New(R.drawable.square_picture,
                   R.drawable.map_picture,
                   R.string.new_title_1,
                   R.string.new_time_1,
                   R.string.new_from_1));

           news.add(new New(R.drawable.square_picture,
                   R.drawable.map_picture,
                   R.string.new_title_2,
                   R.string.new_time_2,
                   R.string.new_from_2));

       }
        return news;
    }

//        设置bulletinRecy，绑定adapter
    private void setBulletinRecy() {
//        初始化recy
        recy_bulletins = (RecyclerView)findViewById(R.id.recy_bulletin);
//        设置recy布局方式为线性布局,默认垂直排列
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recy_bulletins.setLayoutManager(layoutManager);
//        创建adapter
        RecyBulletinAdapter adapter = new RecyBulletinAdapter(bulletinsList,getApplicationContext());
        recy_bulletins.setAdapter(adapter);

    }

    //        初始化bulletinList数据
    private List initBulletinList() {
        List<Bulletin> bulletins = new ArrayList<>();

        bulletins.add(new Bulletin(R.drawable.square_picture,
                R.string.bulletin_name_1,
                R.string.bulletin_title_1,
                R.string.bulletin_time_1));

        bulletins.add(new Bulletin(R.drawable.map_picture,
                R.string.bulletin_name_2,
                R.string.bulletin_title_2,
                R.string.bulletin_time_2));

        return bulletins;
    }
}
