package com.example.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class BicicletaAdapter extends BaseAdapter {
    private List<Bicicleta> biciclete;
    private Context ctx;
    private int resursaLayout;
    @Override
    public int getCount() {
        return biciclete.size();
    }

    @Override
    public Object getItem(int position) {
        return biciclete.get(position);
    }

    public BicicletaAdapter(List<Bicicleta> biciclete, Context ctx, int resursaLayout) {
        this.biciclete = biciclete;
        this.ctx = ctx;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(ctx);
        View v=inflater.inflate(resursaLayout, parent,false);

        Bicicleta bicicleta=biciclete.get(position);
        TextView textViewId=v.findViewById(R.id.idBicicleta);
        TextView textViewModel=v.findViewById(R.id.modelBicicleta);
        TextView textViewPret=v.findViewById(R.id.pretBicicleta);
        TextView textViewTip=v.findViewById(R.id.tipBicicleta);
        TextView textViewMarca=v.findViewById(R.id.marcaBicicleta);
        TextView textViewEsteElectrica=v.findViewById(R.id.esteElectricaBicicleta);
        TextView textViewAreFraneDisc=v.findViewById(R.id.areFraneDiscBicicleta);
        TextView textViewRating=v.findViewById(R.id.ratingBicicleta);

        textViewId.setText(String.valueOf(bicicleta.getIdBicicleta()));
        textViewModel.setText(bicicleta.getModel());
        textViewPret.setText(String.valueOf(bicicleta.getPret()));
        textViewTip.setText(bicicleta.getTip());
        textViewMarca.setText(bicicleta.getMarca());
        textViewEsteElectrica.setText(bicicleta.isEsteElectrica()?"Este electrica":"Nu este electrica");
        if(bicicleta.isAreFraneDisc()){
            textViewAreFraneDisc.setText("Are frane disc");
        }else{
            textViewAreFraneDisc.setText("Nu are frane disc");
        }
        textViewRating.setText(String.valueOf(bicicleta.getRating()));
        return v;
    }
}
