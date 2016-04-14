package com.roberasd.sqliteandroid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.roberasd.sqliteandroid.R;
import com.roberasd.sqliteandroid.adapter.UserAdapter;
import com.roberasd.sqliteandroid.database.UsersDAO;
import com.roberasd.sqliteandroid.models.UserModel;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        UserModel model = getIntent().getParcelableExtra("person_model");
        UserAdapter userAdapter = new UserAdapter(getApplicationContext());
        UsersDAO usersDAO = new UsersDAO(getApplicationContext());

        TextView name = (TextView) findViewById(R.id.person_name);
        TextView lastName = (TextView) findViewById(R.id.person_last_name);
        TextView age = (TextView) findViewById(R.id.person_age);
        TextView email = (TextView) findViewById(R.id.person_email);
        ListView listAllUsers = (ListView) findViewById(R.id.list_of_all_users);

        userAdapter.addAll(usersDAO.getAllUsers());
        listAllUsers.setAdapter(userAdapter);

        name.setText("Nombre \n" + model.getName());
        lastName.setText("Apellido \n" + model.getLastName());
        age.setText(String.valueOf("Años \n" + model.getAge()));
        email.setText("Correo \n" + model.getEmail());

        listAllUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
}
