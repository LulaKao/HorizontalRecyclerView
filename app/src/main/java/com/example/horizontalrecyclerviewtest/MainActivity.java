package com.example.horizontalrecyclerviewtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        LinkedList<String> linkedList = new LinkedList();

        // 設定分類項目名稱
        linkedList.add("最新");
        linkedList.add("所有");
        linkedList.add("戲劇");
        linkedList.add("電影");
        linkedList.add("動漫");
        linkedList.add("中文字幕");
        linkedList.add("綜藝");
        linkedList.add("歐美");
        linkedList.add("亞洲");
        linkedList.add("電視熱播");
        linkedList.add("台灣");
        linkedList.add("韓國");
        linkedList.add("日本");
        linkedList.add("短片");
        linkedList.add("BL");
        linkedList.add("直播");
        linkedList.add("雙語");
        linkedList.add("韓文字幕");

//        for (int i = 0; i < 20; i++)
//            linkedList.add("小明" + i + "号");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        // 配置水平布局（默認為 vertical 垂直布局）--> 變成橫向滑動
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        // 載入資料
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new TextAdapter(linkedList));
    }
}
