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
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.ServerTimestamp;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.google.android.gms.common.internal.safeparcel.SafeParcelable.NULL;

public class queja extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "DocEmision";
    private FirebaseFirestore db;
    //CollectionReference envios;
    Button btnEnviar;
    EditText inputDescripcion;
    EditText inputRuta;
    EditText inputHashTag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_queja);


        db = FirebaseFirestore.getInstance();
        inputDescripcion=(EditText)findViewById(R.id.descripcion);
        inputRuta=(EditText)findViewById(R.id.ruta);
        inputHashTag=findViewById(R.id.hashtag);
        btnEnviar=findViewById(R.id.enviar);

        btnEnviar.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {



        Map<String,Object> data = new HashMap<>();
        data.put("Tipo","Queja");
        data.put("Descripcion",inputDescripcion.getText().toString());
        data.put("Ruta",inputRuta.getText().toString());
        data.put("HashTag",inputHashTag.getText().toString());
        data.put("Fecha", FieldValue.serverTimestamp());

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
        inputHashTag.setText(" ");

        Toast.makeText(this,"Se añadido correctamente",Toast.LENGTH_SHORT).show();

    }
}


