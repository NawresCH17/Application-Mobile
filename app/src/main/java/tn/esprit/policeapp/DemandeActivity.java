package tn.esprit.policeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;


public class DemandeActivity extends AppCompatActivity {

    ListView list;
    String nom,prenom,address,date;
    HashMap<String,String>map;
    Params p= new Params();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demande);


        list=findViewById(R.id.demandes);

        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            nom=extras.getString("nom");
            prenom=extras.getString("prenom");
            address=extras.getString("Adresse");
            date=extras.getString("date");
            map=new HashMap<String,String>();
            map.put("nom",nom);
            map.put("prenom",prenom);
            map.put("adresse",address);
            map.put("date",date);
            p.values.add(map);

        }

        SimpleAdapter adapter=new SimpleAdapter(DemandeActivity.this,p.values,
                R.layout.item_carte,
                new String[]{"nom","prenom","adresse","date"},
                new int[]{R.id.nom,R.id.prenom,R.id.adresse,R.id.date});
             list.setAdapter(adapter);

             list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                 @Override
                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                     Intent i=new Intent(getApplicationContext(),DetailsActivity.class);
                     i.putExtra("position",position);
                     startActivity(i);
                 }
             });
    }
}