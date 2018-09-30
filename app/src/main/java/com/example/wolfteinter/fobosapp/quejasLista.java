package com.example.wolfteinter.fobosapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class quejasLista extends AppCompatActivity {
    private static final String TAG = "Documento";
    ListView varNombres;
    List<classQueja> objetosLista = new ArrayList<classQueja>();

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String ruta;
    String descripcion;
    String resultado;
    String tipo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quejas_lista);

        objetosLista.add(new classQueja("8","prueba"));
        varNombres = findViewById(R.id.lista);

        //aqui se tiene que recuperar los datos
        db.collection("emisiones")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {

                            for (DocumentSnapshot document : task.getResult()) {
                                resultado= document.getData().values().toString();
                                //resultado.replace('[',' ');


                                String[] arregloStrings = resultado.split(",");
                                tipo=arregloStrings[0];



                                //Toast.makeText(quejasLista.this, tipo, Toast.LENGTH_SHORT).show();
                                if(tipo.equals("[Queja")){
                                    ruta=arregloStrings[1];
                                    descripcion=arregloStrings[2];
                                    objetosLista.add(new classQueja("2","prueba"));
                                    //objetosLista.add(new classQueja(ruta,"hola"));
                                    //Toast.makeText(quejasLista.this, objetosLista.get(1).getDescripcion(), Toast.LENGTH_SHORT).show();
                                }


                                //Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }

                    }

                });




        adaptadorQueja adaptador = new adaptadorQueja(this,objetosLista);
        varNombres.setAdapter(adaptador);

    }
}
