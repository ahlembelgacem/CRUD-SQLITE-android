package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText phone;
    EditText nom;
    Button add;
    Helper h=new Helper(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone=findViewById(R.id.phone);
        nom=findViewById(R.id.nom);
        add=findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact cn=new Contact(nom.getText().toString(),phone.getText().toString());
                h.insertContact(cn);
                Intent intent= new Intent(MainActivity.this, ListeContact.class);
                startActivity(intent);
            }
        });


    }
}