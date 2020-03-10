package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    ImageView imgBH;
    TextView tenBH, tenCS, TGian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        anhXa();
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            imgBH.setImageResource(bundle.getInt("imgBH", 123));
            tenBH.setText(bundle.getString("tenBH", "sai key"));
            tenCS.setText(bundle.getString("tenCS", "sai key"));
            TGian.setText(bundle.getString("TGian", "sai key"));
        }
    }
    void anhXa(){
        imgBH = findViewById(R.id.imgBH);
        tenBH = findViewById(R.id.tenBH);
        tenCS = findViewById(R.id.tenCS);
        TGian = findViewById(R.id.TGian);
    }
}
