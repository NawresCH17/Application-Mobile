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

public class SignUpActivity extends AppCompatActivity {

    EditText username;
    EditText email;
    EditText password;
    EditText phone;
    Button sign;
    UserDAO userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        phone = findViewById(R.id.phone);
        sign = findViewById(R.id.signUP);

        userDao = Room.databaseBuilder(this, MyDatabase.class, "mi-database.db").allowMainThreadQueries()
                .build().userDAO();

        /*sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(SignUpActivity.this,HomeActivity.class));
                Intent intent = new Intent(SignUpActivity.this, Page1Activity.class);

                intent.putExtra("username", username.getText().toString());
                intent.putExtra("email", email.getText().toString());
                intent.putExtra("Password", password.getText().toString());
                intent.putExtra("Phone", phone.getText().toString());

                startActivity(intent);
            }
        });
*/
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = username.getText().toString().trim();
                String pwd = password.getText().toString().trim();


                if (password.equals(password)) {
                    User user = new User(userName,pwd);
                    userDao.insert(user);
                    Intent moveToLogin = new Intent(SignUpActivity.this, SignInActivity.class);
                    startActivity(moveToLogin);

                } else {
                    Toast.makeText(SignUpActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();

                }
            }

        });
    }
}
