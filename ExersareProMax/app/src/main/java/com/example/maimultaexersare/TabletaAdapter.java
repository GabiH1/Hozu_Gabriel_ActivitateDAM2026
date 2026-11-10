package com.example.maimultaexersare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class TabletaAdapter extends BaseAdapter {
    private List<Tableta> tablete;
    private Context ctx;
    private int resursalayout;

    public TabletaAdapter(Context ctx, int resursalayout, List<Tableta> tablete) {
        this.ctx = ctx;
        this.resursalayout = resursalayout;
        this.tablete = tablete;
    }

    @Override
    public int getCount() {
        return tablete.size();
    }

    @Override
    public Object getItem(int position) {
        return tablete.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v=inflater.inflate(resursalayout,parent,false);

        TextView idTv=v.findViewById(R.id.Hozu_GabrielidTv);
        TextView modelTv=v.findViewById(R.id.Hozu_GabrielModelTv);
        TextView spatiuTv=v.findViewById(R.id.Hozu_GabrielSpatiuTv);
        CheckBox esteOled=v.findViewById(R.id.Hozu_GabrielCheckBox);

        Tableta tableta=tablete.get(position);
        idTv.setText(String.valueOf(tableta.getIdTableta()));
        modelTv.setText(tableta.getModel());
        spatiuTv.setText(String.valueOf(tableta.getSpatiuMemorie()));
        esteOled.setChecked(tableta.isEsteOled());
        return v;
    }
}
