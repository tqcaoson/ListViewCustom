package com.example.customlistview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<MusicModel> datas;

    public MyAdapter(Context context, ArrayList<MusicModel> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.custom_items, parent, false);
        ImageView imgBH = convertView.findViewById(R.id.imgBH);
        TextView tenBH = convertView.findViewById(R.id.tenBH);
        TextView tenCS = convertView.findViewById(R.id.tenCS);
        TextView TGian = convertView.findViewById(R.id.TGian);
        TextView delete = convertView.findViewById(R.id.delete);
        TextView edit = convertView.findViewById(R.id.edit);
        imgBH.setImageResource(datas.get(position).getIdAnh());
        tenBH.setText(datas.get(position).getTenBaiHat());
        tenCS.setText(datas.get(position).getTenCaSi());
        TGian.setText(datas.get(position).getThoiGian());
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Xác nhận xoá?");
                builder.setPositiveButton("Huỷ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("Xoá", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        datas.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.show();
            }
        });
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogView(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
    void DialogView(final int position){
        LayoutInflater inflater = LayoutInflater.from(context);
        View subView = inflater.inflate(R.layout.dialog_custom, null);
        final EditText tenBH = subView.findViewById(R.id.tenBH);
        final EditText tenCS = subView.findViewById(R.id.tenCS);
        final EditText TGian = subView.findViewById(R.id.TGian);
        tenBH.setText(datas.get(position).getTenBaiHat());
        tenCS.setText(datas.get(position).getTenCaSi());
        TGian.setText(datas.get(position).getThoiGian());
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(subView);
        builder.setPositiveButton("Huỷ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Sửa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                datas.get(position).setTenBaiHat(tenBH.getText().toString());
                datas.get(position).setTenCaSi(tenCS.getText().toString());
                datas.get(position).setThoiGian(TGian.getText().toString());
                notifyDataSetChanged();
            }
        });
        builder.show();

    }
}
