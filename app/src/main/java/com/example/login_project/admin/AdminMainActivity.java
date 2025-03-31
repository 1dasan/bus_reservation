package com.example.login_project.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.login_project.MainActivity;
import com.example.login_project.MainScreenActivity;
import com.example.login_project.R;

public class AdminMainActivity extends AppCompatActivity {

    private Button BusAdd;
    private Button BusDelete;
    private Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);

        BusAdd = findViewById(R.id.BusAddButton);
        BusDelete = findViewById(R.id.BusDeleteButton);
        back_button = findViewById(R.id.Ad_button);

        BusAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminMainActivity.this , BusSearchActivity.class);
                intent.putExtra("whether", 0);
                startActivity(intent);
            }
        });

        BusDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminMainActivity.this , BusSearchActivity.class);
                intent.putExtra("whether", 1);
                startActivity(intent);
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(AdminMainActivity.this , MainActivity.class);
//                startActivity(intent);
                finish();
            }
        });

    }
}