 package com.example.tp5;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

 public class DetailContact extends AppCompatActivity {
    EditText nom;
    EditText phone;
    Button mod,delete;
String id;
Helper h=new Helper(DetailContact.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_contact);
        nom=findViewById(R.id.nom);
        phone=findViewById(R.id.phone);
        mod=findViewById(R.id.mod);
        delete=findViewById(R.id.delete);
        id=getIntent().getStringExtra("id");
        Contact cn=h.getOneContact(Integer.parseInt(id));
        nom.setText(cn.getNom());
        phone.setText(cn.getPhone());

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Contact cn=new Contact(Integer.parseInt(id),
        nom.getText().toString(),phone.getText().toString());

        h.updateContact(cn);
                Intent intent=new Intent(DetailContact.this,ListeContact.class);
                startActivity(intent);
            }
        });
delete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        h.deleteContact(Integer.parseInt(id));
        Intent intent=new Intent(DetailContact.this,ListeContact.class);
        startActivity(intent);

    }
});
    }
}