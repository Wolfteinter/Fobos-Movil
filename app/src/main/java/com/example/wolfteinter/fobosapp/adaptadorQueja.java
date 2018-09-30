package com.example.wolfteinter.fobosapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class adaptadorQueja extends ArrayAdapter<classQueja> {
    public adaptadorQueja(@NonNull Context context, @NonNull List<classQueja> objects) {

        super(context,0, objects);

    }

    public View getView(int position, @Nullable View cardView, @NonNull ViewGroup parent) {

        // 1.
        LayoutInflater inflaterCard = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(cardView == null){

            cardView = inflaterCard.inflate(R.layout.cardqueja, parent, false);

        }

        ///

        TextView ruta = cardView.findViewById(R.id.textView3);
        TextView descripcion = cardView.findViewById(R.id.textView4);


        classQueja c1 = getItem(position);

        ruta.setText(c1.getRuta());
        descripcion.setText(c1.getDescripcion());

        return  cardView;
    }
}