package com.example.login_project.bus_back;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.login_project.R;
import com.example.login_project.admin.BusSearchActivity;
import com.example.login_project.bus_go.AnsanGoActivity;
import com.example.login_project.bus_go.AnyangGoActivity;
import com.example.login_project.database.BusSeat;
import com.example.login_project.reservation.ReservationActivity;
import com.example.login_project.reservation.ReservationSettingActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GyodaeBackActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private Button Gyodae_back1;
    private Button Gyodae_back2;
    private Button Gyodae_back3;
    private Button Gyodae_back4;
    private Button Gyodae_back5;
    private Button Gyodae_back6;
    private Button back_button;
    private String location;
    private String go_or_back;
    private String time;
    private String exist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyodae_back);

        Intent intent = getIntent();

        String Id = intent.getStringExtra("userId");
        String Date = intent.getStringExtra("Date");
        int whether = intent.getIntExtra("whether", 0);
        String friday = intent.getStringExtra("friday");

        location = "교대";
        go_or_back ="하교";

        Gyodae_back1 = findViewById(R.id.btn_GD_af1);
        Gyodae_back2 = findViewById(R.id.btn_GD_af2);
        Gyodae_back3 = findViewById(R.id.btn_GD_af3);
        Gyodae_back4 = findViewById(R.id.btn_GD_af4);
        Gyodae_back5 = findViewById(R.id.btn_GD_af5);
        Gyodae_back6 = findViewById(R.id.btn_GD_af6);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Login_Project");

        back_button = findViewById(R.id.back_button11);

        if(friday.equals("1")){
            Gyodae_back1.setEnabled(false);
            Gyodae_back2.setEnabled(false);
            Gyodae_back4.setEnabled(false);
        }

        Gyodae_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                time = "12:30";

                if(whether == 0){
                    String strWhether = new String("0");
                    String strClient = new String("10");

                    BusSeat busSeat = new BusSeat();

                    busSeat.setClient(strClient);
                    busSeat.setWhether(strWhether);

                    mDatabaseRef.child(Date).child("Exist").setValue("1");
                    for(int i=1; i<=37; i++){
                        String seat = String.valueOf(i);
                        mDatabaseRef.child(Date).child("교대").child("하교").child("12:30").child(seat).setValue(busSeat);
                    }
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("12:30").child("Exist").setValue("1");
                    Toast.makeText(GyodaeBackActivity.this, "버스추가에 성공했습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(whether == 1){
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("12:30").child("Exist").setValue("0");
                    Toast.makeText(GyodaeBackActivity.this, "버스삭제에 성공했습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(whether == 2){
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("12:30").child("Exist").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            exist = snapshot.getValue(String.class);
                            if (exist.equals("0")) {
                                Toast.makeText(GyodaeBackActivity.this, "존재하지 않는 버스입니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intent = new Intent(GyodaeBackActivity.this, ReservationActivity.class);
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

        Gyodae_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                time = "13:30";

                if(whether == 0){
                    String strWhether = new String("0");
                    String strClient = new String("10");

                    BusSeat busSeat = new BusSeat();

                    busSeat.setClient(strClient);
                    busSeat.setWhether(strWhether);

                    mDatabaseRef.child(Date).child("Exist").setValue("1");
                    for(int i=1; i<=37; i++){
                        String seat = String.valueOf(i);
                        mDatabaseRef.child(Date).child("교대").child("하교").child("13:30").child(seat).setValue(busSeat);
                    }
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("13:30").child("Exist").setValue("1");
                    Toast.makeText(GyodaeBackActivity.this, "버스추가에 성공했습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(whether == 1){
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("13:30").child("Exist").setValue("0");
                    Toast.makeText(GyodaeBackActivity.this, "버스삭제에 성공했습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(whether == 2){
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("13:30").child("Exist").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            exist = snapshot.getValue(String.class);
                            if (exist.equals("0")) {
                                Toast.makeText(GyodaeBackActivity.this, "존재하지 않는 버스입니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intent = new Intent(GyodaeBackActivity.this, ReservationActivity.class);
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

        Gyodae_back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                time = "14:30";

                if(whether == 0){
                    String strWhether = new String("0");
                    String strClient = new String("10");

                    BusSeat busSeat = new BusSeat();

                    busSeat.setClient(strClient);
                    busSeat.setWhether(strWhether);

                    mDatabaseRef.child(Date).child("Exist").setValue("1");
                    for(int i=1; i<=37; i++){
                        String seat = String.valueOf(i);
                        mDatabaseRef.child(Date).child("교대").child("하교").child("14:30").child(seat).setValue(busSeat);
                    }
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("14:30").child("Exist").setValue("1");
                    Toast.makeText(GyodaeBackActivity.this, "버스추가에 성공했습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(whether == 1){
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("14:30").child("Exist").setValue("0");
                    Toast.makeText(GyodaeBackActivity.this, "버스삭제에 성공했습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(whether == 2){
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("14:30").child("Exist").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            exist = snapshot.getValue(String.class);
                            if (exist.equals("0")) {
                                Toast.makeText(GyodaeBackActivity.this, "존재하지 않는 버스입니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intent = new Intent(GyodaeBackActivity.this, ReservationActivity.class);
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

        Gyodae_back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                time = "15:30";

                if(whether == 0){
                    String strWhether = new String("0");
                    String strClient = new String("10");

                    BusSeat busSeat = new BusSeat();

                    busSeat.setClient(strClient);
                    busSeat.setWhether(strWhether);

                    mDatabaseRef.child(Date).child("Exist").setValue("1");
                    for(int i=1; i<=37; i++){
                        String seat = String.valueOf(i);
                        mDatabaseRef.child(Date).child("교대").child("하교").child("15:30").child(seat).setValue(busSeat);
                    }
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("15:30").child("Exist").setValue("1");
                    Toast.makeText(GyodaeBackActivity.this, "버스추가에 성공했습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(whether == 1){
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("15:30").child("Exist").setValue("0");
                    Toast.makeText(GyodaeBackActivity.this, "버스삭제에 성공했습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(whether == 2){
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("15:30").child("Exist").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            exist = snapshot.getValue(String.class);
                            if (exist.equals("0")) {
                                Toast.makeText(GyodaeBackActivity.this, "존재하지 않는 버스입니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intent = new Intent(GyodaeBackActivity.this, ReservationActivity.class);
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

        Gyodae_back5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                time = "16:30";

                if(whether == 0){
                    String strWhether = new String("0");
                    String strClient = new String("10");

                    BusSeat busSeat = new BusSeat();

                    busSeat.setClient(strClient);
                    busSeat.setWhether(strWhether);

                    mDatabaseRef.child(Date).child("Exist").setValue("1");
                    for(int i=1; i<=37; i++){
                        String seat = String.valueOf(i);
                        mDatabaseRef.child(Date).child("교대").child("하교").child("16:30").child(seat).setValue(busSeat);
                    }
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("16:30").child("Exist").setValue("1");
                    Toast.makeText(GyodaeBackActivity.this, "버스추가에 성공했습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(whether == 1){
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("16:30").child("Exist").setValue("0");
                    Toast.makeText(GyodaeBackActivity.this, "버스삭제에 성공했습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(whether == 2){
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("16:30").child("Exist").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            exist = snapshot.getValue(String.class);
                            if (exist.equals("0")) {
                                Toast.makeText(GyodaeBackActivity.this, "존재하지 않는 버스입니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intent = new Intent(GyodaeBackActivity.this, ReservationActivity.class);
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

        Gyodae_back6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                time = "18:10";

                if(whether == 0){
                    String strWhether = new String("0");
                    String strClient = new String("10");

                    BusSeat busSeat = new BusSeat();

                    busSeat.setClient(strClient);
                    busSeat.setWhether(strWhether);

                    mDatabaseRef.child(Date).child("Exist").setValue("1");
                    for(int i=1; i<=37; i++){
                        String seat = String.valueOf(i);
                        mDatabaseRef.child(Date).child("교대").child("하교").child("18:10").child(seat).setValue(busSeat);
                    }
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("18:10").child("Exist").setValue("1");
                    Toast.makeText(GyodaeBackActivity.this, "버스추가에 성공했습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(whether == 1){
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("18:10").child("Exist").setValue("0");
                    Toast.makeText(GyodaeBackActivity.this, "버스삭제에 성공했습니다.", Toast.LENGTH_SHORT).show();
                }
                else if(whether == 2){
                    mDatabaseRef.child(Date).child(location).child(go_or_back).child("18:10").child("Exist").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            exist = snapshot.getValue(String.class);
                            if (exist.equals("0")) {
                                Toast.makeText(GyodaeBackActivity.this, "존재하지 않는 버스입니다.", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent intent = new Intent(GyodaeBackActivity.this, ReservationActivity.class);
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
//                    Intent intent1 = new Intent(GyodaeBackActivity.this , ReservationSettingActivity.class);
//                    intent.putExtra("userId", Id);
//                    startActivity(intent1);
//                }
//                else if(whether == 1){
//                    Intent intent2 = new Intent(GyodaeBackActivity.this , BusSearchActivity.class);
//                    intent.putExtra("whether", 1);
//                    startActivity(intent2);
//                }
//                else if(whether == 0){
//                    Intent intent2 = new Intent(GyodaeBackActivity.this , BusSearchActivity.class);
//                    intent.putExtra("whether", 0);
//                    startActivity(intent2);
//                }
                finish();
            }
        });
    }
}