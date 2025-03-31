package com.example.login_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.login_project.reservation.ReservationSettingActivity;

public class QActivity extends AppCompatActivity {

    private Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qactivity);

        Intent intent = getIntent();

        String Id = intent.getStringExtra("userId");

        back_button = findViewById(R.id.back_button20);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent1 = new Intent(QActivity.this , MainScreenActivity.class);
//                intent1.putExtra("userId", Id);
//                startActivity(intent1);
                finish();
            }
        });
    }
}