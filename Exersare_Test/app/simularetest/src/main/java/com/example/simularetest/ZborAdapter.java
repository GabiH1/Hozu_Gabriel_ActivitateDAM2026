package com.example.simularetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ZborAdapter extends BaseAdapter {

    private List<Zbor> zboruri;
    private Context ctx;
    private int resursaLayout;
    @Override
    public int getCount() {
        return zboruri.size();
    }

    @Override
    public Object getItem(int position) {
        return zboruri.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public ZborAdapter(List<Zbor> zboruri, Context ctx, int resursaLayout) {
        this.zboruri = zboruri;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View v=inflater.inflate(resursaLayout,parent,false);

        TextView tvCompanie=v.findViewById(R.id.tvCompanie);
        TextView tvDestinatie=v.findViewById(R.id.tvDestinatie);

        Zbor zbor=(Zbor)getItem(position);

        tvCompanie.setText(zbor.getCompanie());
        tvDestinatie.setText(zbor.getDestinatie());
        return v;
    }
}
