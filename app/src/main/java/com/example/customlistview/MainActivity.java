package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvDanhSach;
    ArrayList<MusicModel> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        datas.add(new MusicModel(R.drawable.download, "Lạc Trôi", "Sơn Tùng", "5:00"));
        datas.add(new MusicModel(R.drawable.download, "Lạc Trôi", "Sơn Tùng", "5:00"));
        datas.add(new MusicModel(R.drawable.download, "Lạc Trôi", "Sơn Tùng", "5:00"));
        datas.add(new MusicModel(R.drawable.download, "Lạc Trôi", "Sơn Tùng", "5:00"));
        datas.add(new MusicModel(R.drawable.download, "Lạc Trôi", "Sơn Tùng", "5:00"));
        datas.add(new MusicModel(R.drawable.download, "Lạc Trôi", "Sơn Tùng", "5:00"));
        datas.add(new MusicModel(R.drawable.download, "Lạc Trôi", "Sơn Tùng", "5:00"));
        final MyAdapter adapter = new MyAdapter(MainActivity.this, datas);
        lvDanhSach.setAdapter(adapter);
        lvDanhSach.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("imgBH", datas.get(position).getIdAnh());
                bundle.putString("tenBH", datas.get(position).getTenBaiHat());
                bundle.putString("tenCS", datas.get(position).getTenCaSi());
                bundle.putString("TGian", datas.get(position).getThoiGian());
                intent.putExtras(bundle);
                startActivity(intent);
                return false;
            }
        });
    }
    void anhXa(){
        lvDanhSach = findViewById(R.id.lvDanhSach);
        datas = new ArrayList<>();
    }

}
