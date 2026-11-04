package com.example.seminar4_hozu_gabriel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class HangarAdapter extends BaseAdapter {
    private Context context;
    private List<Hangar> hangare;
    private int resursaLayout;

    public HangarAdapter(Context context, List<Hangar> hangare, int resursaLayout) {
        this.context = context;
        this.hangare = hangare;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() {
        return hangare.size();
    }

    @Override
    public Object getItem(int i) {
        return hangare.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View v = convertView;

        LayoutInflater inflator = LayoutInflater.from(context);
        v = inflator.inflate(resursaLayout, viewGroup, false);


        TextView tvNume = v.findViewById(R.id.numeHangar);
        TextView tvLocatie = v.findViewById(R.id.locatieHangar);
        TextView tvTip = v.findViewById(R.id.tipHangar);
        TextView tvCapacitate = v.findViewById(R.id.capacitateHangar);
        TextView tvRating = v.findViewById(R.id.ratingHangar);

        Hangar hangar = (Hangar) getItem(i);


        if (tvNume != null) {
            tvNume.setText(hangar.getNume());
        }
        if (tvLocatie != null) {
            tvLocatie.setText(hangar.getLocatie());
        }
        if (tvTip != null) {
            tvTip.setText(hangar.getTip());
        }
        if (tvCapacitate != null) {
            tvCapacitate.setText(String.valueOf(hangar.getCapacitate()));
        }
        if (tvRating != null) {
            tvRating.setText(String.valueOf(hangar.getRating()));
        }


        return v;
    }
}
