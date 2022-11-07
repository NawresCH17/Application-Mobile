package tn.esprit.policeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class DetailsActivity extends AppCompatActivity {

    EditText nom,prenom,adresse,dateNaiss;
    Button edit,delete;
    int position;
    Params p=new Params();
    HashMap<String,String> m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        nom=findViewById(R.id.nom);
        prenom=findViewById(R.id.prenom);
        adresse=findViewById(R.id.adresse);
        dateNaiss=findViewById(R.id.date);
        edit=findViewById(R.id.modif);
        delete=findViewById(R.id.supp);

        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            position=extras.getInt("position");
        }

        m=p.values.get(position);
        nom.setText(m.get("nom"));
        prenom.setText(m.get("prenom"));
        adresse.setText(m.get("adresse"));
        dateNaiss.setText(m.get("date"));

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.put("nom",nom.getText().toString());
                m.put("prenom",prenom.getText().toString());
                m.put("Adresse",adresse.getText().toString());
                m.put("date",dateNaiss.getText().toString());
                Intent i=new Intent(getApplicationContext(),DemandeActivity.class);
                startActivity(i);
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.values.remove(position);
                Intent i=new Intent(getApplicationContext(),DemandeActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}