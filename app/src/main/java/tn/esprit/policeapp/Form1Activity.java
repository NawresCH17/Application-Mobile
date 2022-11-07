package tn.esprit.policeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Form1Activity extends AppCompatActivity {


    EditText nom;
    EditText prenom;
    EditText adresse;
    EditText dateNaiss;
    EditText lieu;
    EditText profession;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1);

        nom=findViewById(R.id.nom);
        prenom=findViewById(R.id.prenom);
        adresse=findViewById(R.id.adresse);
        dateNaiss=findViewById(R.id.date);
        lieu=findViewById(R.id.lieu);
        profession=findViewById(R.id.profession);
        add=findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),DemandeActivity.class);
                i.putExtra("nom",nom.getText().toString());
                i.putExtra("prenom",prenom.getText().toString());
                i.putExtra("Adresse",adresse.getText().toString());
                i.putExtra("date",dateNaiss.getText().toString());
                startActivity(i);
            }
        });
    }
}