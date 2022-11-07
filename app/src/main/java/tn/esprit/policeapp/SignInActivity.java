package tn.esprit.policeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tn.esprit.policeapp.dao.UserDAO;
import tn.esprit.policeapp.database.MyDatabase;
import tn.esprit.policeapp.entities.User;

public class SignInActivity extends AppCompatActivity {


    EditText username;
    EditText password;
    Button logBtn;
    Button signup;
    UserDAO db;
    MyDatabase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_in);

        username=findViewById(R.id.username);
        password=findViewById(R.id.pwd);
        logBtn=findViewById(R.id.loginbtn);
        signup=findViewById(R.id.signupbtn);

        dataBase = Room.databaseBuilder(this, MyDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();

        db = dataBase.userDAO();

        /*logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, HomeActivity.class));

            }
        });*/

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignInActivity.this, SignUpActivity.class));

            }
        });


        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString().trim();
                String pwd = password.getText().toString().trim();

                User user = db.getUser(name,pwd);
                if (user != null) {
                    Intent i = new Intent(SignInActivity.this, HomeActivity.class);

                    startActivity(i);
                    finish();
                }else{
                    Toast.makeText(SignInActivity.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}