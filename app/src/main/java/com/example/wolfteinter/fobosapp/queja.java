package com.example.wolfteinter.fobosapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

public class queja extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "DocEmision";
    private FirebaseFirestore db;
    //CollectionReference envios;
    Button btnEnviar;
    EditText inputDescripcion;
    EditText inputRuta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queja);


        db = FirebaseFirestore.getInstance();
        inputDescripcion=(EditText)findViewById(R.id.descripcion);
        inputRuta=(EditText)findViewById(R.id.ruta);
        btnEnviar=findViewById(R.id.enviar);

        btnEnviar.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Map<String,String> data = new HashMap<>();
        data.put("Tipo","Queja");
        data.put("Descripcion",inputDescripcion.getText().toString());
        data.put("Ruta",inputRuta.getText().toString());

        db.collection("emisiones")
                .add(data)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {


                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });

        inputRuta.setText(" ");
        inputDescripcion.setText(" ");
        Toast.makeText(this,"Se añadido correctamente",Toast.LENGTH_SHORT).show();

    }
}


