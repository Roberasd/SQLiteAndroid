package com.roberasd.sqliteandroid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.roberasd.sqliteandroid.R;
import com.roberasd.sqliteandroid.models.PersonModel;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        PersonModel model = getIntent().getParcelableExtra("person_model");

        TextView name = (TextView) findViewById(R.id.person_name);
        TextView lastName = (TextView) findViewById(R.id.person_last_name);
        TextView age = (TextView) findViewById(R.id.person_age);
        TextView email = (TextView) findViewById(R.id.person_email);
        TextView personCountry = (TextView) findViewById(R.id.person_country);

        name.setText("Nombre \n" + model.getName());
        lastName.setText("Apellido \n" + model.getLastName());
        age.setText(String.valueOf("Años \n" + model.getAge()));
        email.setText("Correo \n" + model.getEmail());
        personCountry.setText("País \n" + model.getCountry());
    }
}
