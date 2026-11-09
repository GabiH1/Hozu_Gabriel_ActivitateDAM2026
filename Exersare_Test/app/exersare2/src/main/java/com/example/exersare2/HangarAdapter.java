package com.example.exersare2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class HangarAdapter extends BaseAdapter {

    private List<Hangar> hangare;
    private Context ctx;
    private int resursaLayout;

    public HangarAdapter(List<Hangar> hangare, Context ctx, int resursaLayout) {
        this.hangare = hangare;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return hangare.size();
    }

    @Override
    public Object getItem(int position) {
        return hangare.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View v=inflater.inflate(resursaLayout,parent,false);

        TextView tvNume=v.findViewById(R.id.tvNume);
        TextView tvCapacitate=v.findViewById(R.id.tvCapacitate);
        TextView tvTip=v.findViewById(R.id.tvTip);
        TextView tvLocatie=v.findViewById(R.id.tvLocatie);
        CheckBox cbDisponibil=v.findViewById(R.id.cbDisponibil);
        RatingBar rbRating=v.findViewById(R.id.rbRating);
        Switch swPaza=v.findViewById(R.id.swPaza);

        Hangar hangar=(Hangar)getItem(position);

        tvNume.setText(hangar.getNume());
        tvCapacitate.setText(Integer.toString(hangar.getCapacitate()));
        tvTip.setText(hangar.getTip());
        tvLocatie.setText(hangar.getLocatie());
        cbDisponibil.setChecked(hangar.isEsteDisponibil());
        rbRating.setRating(hangar.getRating());
        swPaza.setChecked(hangar.isArePaza());
        return v;

    }
}
