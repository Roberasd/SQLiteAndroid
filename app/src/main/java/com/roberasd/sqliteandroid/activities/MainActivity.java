package com.roberasd.sqliteandroid.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.roberasd.sqliteandroid.R;
import com.roberasd.sqliteandroid.database.UsersDAO;
import com.roberasd.sqliteandroid.models.UserModel;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText emailLogin = (EditText) findViewById(R.id.email_login);
        final EditText passwordLogin = (EditText) findViewById(R.id.pass_login);

        final UsersDAO usersDAO = new UsersDAO(getApplicationContext());

        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel model = usersDAO.getUser(emailLogin.getText().toString(), passwordLogin.getText().toString());
                if(model != null){

                    Intent intent =  new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("person_model", model);
                    startActivity(intent);

                }else
                    Toast.makeText(MainActivity.this, "Email o Contraseña incorrectos", Toast.LENGTH_SHORT).show();


            }
        });

        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SigninActivity.class));
            }
        });
    }
}
