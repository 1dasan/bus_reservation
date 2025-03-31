package com.example.login_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.login_project.reservation.ReservationInformationActivity;
import com.example.login_project.reservation.ReservationSettingActivity;

public class MainScreenActivity extends AppCompatActivity {

    private Button bus_information_button;
    private Button reservation_button;
    private Button reservation_information_button;
    private Button more_information_button;
    private Button logout_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Intent intent = getIntent();

        String Id = intent.getStringExtra("userId");

        bus_information_button = findViewById(R.id.bus_information);
        reservation_button = findViewById(R.id.reservation_button);
        reservation_information_button = findViewById(R.id.reservation_information);
        more_information_button = findViewById(R.id.more_information);
        logout_button = findViewById(R.id.logout_button);

        bus_information_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainScreenActivity.this , BusInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });

        reservation_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainScreenActivity.this , ReservationSettingActivity.class);
                intent.putExtra("userId", Id);
                startActivity(intent);
            }
        });

        reservation_information_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainScreenActivity.this , ReservationInformationActivity.class);
                intent2.putExtra("userId", Id);
                startActivity(intent2);
            }
        });

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainScreenActivity.this, "로그아웃에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(MainScreenActivity.this , MainActivity.class);
                startActivity(intent3);
                finish();
            }
        });

        more_information_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainScreenActivity.this , QActivity.class);
                intent4.putExtra("userId", Id);
                startActivity(intent4);
            }
        });
    }
}