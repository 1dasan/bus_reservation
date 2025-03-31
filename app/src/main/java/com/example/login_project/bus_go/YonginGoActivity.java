package com.example.login_project.bus_go;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.login_project.R;
import com.example.login_project.admin.BusSearchActivity;
import com.example.login_project.database.BusSeat;
import com.example.login_project.reservation.ReservationActivity;
import com.example.login_project.reservation.ReservationSettingActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class YonginGoActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private Button Yongin_go1;
    private Button back_button;
    private String location;
    private String go_or_back;
    private String time;
    private String exist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yongin_go);

        Intent intent = getIntent();

        String Id = intent.getStringExtra("userId");
        String Date = intent.getStringExtra("Date");
        int whether = intent.getIntExtra("whether", 0);

        location = "용인";
        go_or_back ="등교";

        Yongin_go1 = findViewById(R.id.YonginGo1);
        back_button = findViewById(R.id.back_button17);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Login_Project");

        Yongin_go1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                time = "7:10";

                if(whether == 0){
                    String strWhether = new String("0");
                    String strClient = new String("10");

                    BusSeat busSeat = new BusSeat();

                    busSeat.setClient(strClient);
                    busSeat.setWhether(strWhether);

                    mDatabaseRef.child(Date).child("Exist").setValue("1");
                    for(int i=1; i<=37; i++){
                        String seat = String.valueOf(i);
                        mDatabaseRef.child(Date).child("용인").child("등교").child("7:10").child(seat).setValue(busSeat);
                    }
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("7:10").child("Exist").setValue("1");
                    Toast.makeText(YonginGoActivity.this, "버스추가에 성공했습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(whether == 1){
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("7:10").child("Exist").setValue("0");
                    Toast.makeText(YonginGoActivity.this, "버스삭제에 성공했습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(whether == 2){
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("7:10").child("Exist").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            exist = snapshot.getValue(String.class);
                            if (exist.equals("0")) {
                                Toast.makeText(YonginGoActivity.this, "존재하지 않는 버스입니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intent = new Intent(YonginGoActivity.this, ReservationActivity.class);
                                intent.putExtra("userId", Id);
                                intent.putExtra("Date", Date);
                                intent.putExtra("Location", location);
                                intent.putExtra("Go_or_Back", go_or_back);
                                intent.putExtra("Time", time);

                                startActivity(intent);
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(whether == 2){
//                    Intent intent1 = new Intent(YonginGoActivity.this , ReservationSettingActivity.class);
//                    intent.putExtra("userId", Id);
//                    startActivity(intent1);
//                }
//                else if(whether == 1){
//                    Intent intent2 = new Intent(YonginGoActivity.this , BusSearchActivity.class);
//                    intent.putExtra("whether", 1);
//                    startActivity(intent2);
//                }
//                else if(whether == 0){
//                    Intent intent2 = new Intent(YonginGoActivity.this , BusSearchActivity.class);
//                    intent.putExtra("whether", 0);
//                    startActivity(intent2);
//                }
                finish();
            }
        });
    }
}