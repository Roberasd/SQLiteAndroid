package com.roberasd.sqliteandroid.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.roberasd.sqliteandroid.R;
import com.roberasd.sqliteandroid.database.UsersDAO;
import com.roberasd.sqliteandroid.models.PersonModel;

public class SigninActivity extends AppCompatActivity {

    private EditText mPersonName, mPersonLastName, mPersonAge, mPersonCountry, mEmail, mPassword;
    private UsersDAO mUsersDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mUsersDAO = new UsersDAO(getApplicationContext());

        mPersonName = (EditText) findViewById(R.id.person_name);
        mPersonLastName = (EditText) findViewById(R.id.person_last_name);
        mPersonAge = (EditText) findViewById(R.id.person_age);
        mEmail = (EditText) findViewById(R.id.person_email);
        mPersonCountry = (EditText) findViewById(R.id.person_country);
        mPassword = (EditText) findViewById(R.id.person_password);

        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonModel model = new PersonModel();

                model.setName(mPersonName.getText().toString());
                model.setName(mPersonLastName.getText().toString());
                model.setAge(Integer.parseInt(mPersonAge.getText().toString()));
                model.setEmail(mEmail.getText().toString());
                model.setCountry(mPersonCountry.getText().toString());
                model.setPassword(mPassword.getText().toString());

                if(mUsersDAO.isRegistered(mEmail.getText().toString()))
                    Toast.makeText(SigninActivity.this, "Usuario ya registrado", Toast.LENGTH_SHORT).show();
                else
                    if(mUsersDAO.insertUser(model) == -1)
                        Toast.makeText(SigninActivity.this, "Error al registrarte. Intenta de nuevo", Toast.LENGTH_SHORT).show();
                    else{
                        Toast.makeText(SigninActivity.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SigninActivity.this, MainActivity.class));
                    }


            }
        });

    }
}
