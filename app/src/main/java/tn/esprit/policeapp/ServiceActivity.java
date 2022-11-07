package tn.esprit.policeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ServiceActivity extends AppCompatActivity implements View.OnClickListener {

     ImageView img;
     CardView d1,d2,d3,d4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        img=findViewById(R.id.image4);
        d1 = findViewById(R.id.d1);
        d2 = findViewById(R.id.d2);
        d3 = findViewById(R.id.d3);
        d4 = findViewById(R.id.d4);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ServiceActivity.this, Page1Activity.class));

            }
        });

        d1.setOnClickListener((View.OnClickListener) this);
        d2.setOnClickListener((View.OnClickListener) this);
        d3.setOnClickListener((View.OnClickListener) this);
        d4.setOnClickListener((View.OnClickListener) this);
    }
    @Override
    public void onClick(View v) {
            Intent i;
            switch (v.getId()){
                case R.id.d1:i=new Intent(this,D1Activity.class);
                   startActivity(i);
                   break;

                case R.id.d2:i=new Intent(this,D2Activity.class);
                    startActivity(i);
                    break;
                case R.id.d3:i=new Intent(this,D3Activity.class);
                    startActivity(i);
                    break;
                case R.id.d4:i=new Intent(this,D4Activity.class);
                    startActivity(i);
                    break;
            }

            }


    }
