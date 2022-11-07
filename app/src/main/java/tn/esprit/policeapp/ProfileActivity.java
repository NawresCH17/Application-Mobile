package tn.esprit.policeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

     TextView user;
     TextView email;
     TextView phone;
     TextView password;
     Button change;
     Button home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);



        user = findViewById(R.id.nom);
        email = findViewById(R.id.email);
        password=findViewById(R.id.pwd);
        phone = findViewById(R.id.phone);
        change=findViewById(R.id.btn);
        home=findViewById(R.id.btn4);


            String username = getIntent().getStringExtra("username");
            String mail = getIntent().getStringExtra("email");
            String mdp = getIntent().getStringExtra("password");
            String tel = getIntent().getStringExtra("phone");


             user.setText(username);
             email.setText(mail);
             password.setText(mdp);
             phone.setText(tel);

           home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, HomeActivity.class));

            }
        });
        }
}