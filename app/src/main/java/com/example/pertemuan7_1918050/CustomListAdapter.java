package com.example.pertemuan7_1918050;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Alkohol> Alkohol;
    public CustomListAdapter(Activity activity, List<Alkohol> Alkohol) {
        this.activity = activity;
        this.Alkohol = Alkohol;
    }
    @Override
    public int getCount() {
        return Alkohol.size();
    }
    @Override
    public Object getItem(int location) {
        return Alkohol.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama_produk);
        TextView harga = (TextView)
                convertView.findViewById(R.id.text_harga);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Alkohol m = Alkohol.get(position);
        nama.setText("Nama Produk : "+ m.get_nama_produk());
        harga.setText("Harga : "+ m.get_harga());
        return convertView;
    }
}
