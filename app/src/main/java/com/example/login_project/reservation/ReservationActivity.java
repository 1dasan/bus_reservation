package com.example.login_project.reservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.login_project.MainScreenActivity;
import com.example.login_project.R;
import com.example.login_project.bus_back.AnsanBackActivity;
import com.example.login_project.bus_back.AnyangBackActivity;
import com.example.login_project.bus_back.BundangBackActivity;
import com.example.login_project.bus_back.GyodaeBackActivity;
import com.example.login_project.bus_back.IncheonBackActivity;
import com.example.login_project.bus_go.AnsanGoActivity;
import com.example.login_project.bus_go.AnyangGoActivity;
import com.example.login_project.bus_go.BundangGoActivity;
import com.example.login_project.bus_go.FourGoActivity;
import com.example.login_project.bus_go.GyodaeGoActivity;
import com.example.login_project.bus_go.IncheonGoActivity;
import com.example.login_project.bus_go.JamsilGoActivity;
import com.example.login_project.bus_go.JukjeonGoActivity;
import com.example.login_project.bus_go.SuwonGoActivity;
import com.example.login_project.bus_go.YeongdeungpoGoActivity;
import com.example.login_project.bus_go.YonginGoActivity;
import com.example.login_project.database.BusSeat;
import com.example.login_project.database.ReadSeat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ReservationActivity extends AppCompatActivity {

    private Button Seat1, Seat2, Seat3, Seat4, Seat5, Seat6, Seat7, Seat8, Seat9, Seat10, Seat11, Seat12, Seat13, Seat14, Seat15, Seat16, Seat17, Seat18, Seat19, Seat20, Seat21, Seat22, Seat23, Seat24, Seat25, Seat26, Seat27, Seat28, Seat29, Seat30, Seat31, Seat32, Seat33, Seat34, Seat35, Seat36, Seat37;
    private Button back_button;

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private String whether;
    private String whether2;
    private String whether3;
    private String whether4;
    private String whether5;
    private String whether6;
    private String whether7;
    private String whether8;
    private String whether9;
    private String whether10;
    private String whether11;
    private String whether12;
    private String whether13;
    private String whether14;
    private String whether15;
    private String whether16;
    private String whether17;
    private String whether18;
    private String whether19;
    private String whether20;
    private String whether21;
    private String whether22;
    private String whether23;
    private String whether24;
    private String whether25;
    private String whether26;
    private String whether27;
    private String whether28;
    private String whether29;
    private String whether30;
    private String whether31;
    private String whether32;
    private String whether33;
    private String whether34;
    private String whether35;
    private String whether36;
    private String whether37;
    private String busSeat1;
    private String busSeat2;
    private String busSeat3;
    private String busSeat4;
    private String busSeat5;
    private String busSeat6;
    private String busSeat7;
    private String busSeat8;
    private String busSeat9;
    private String busSeat10;
    private String reservation_lock;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        Intent intent = getIntent();

        String Id = intent.getStringExtra("userId");
        String Date = intent.getStringExtra("Date");
        String Location = intent.getStringExtra("Location");
        String Go_or_Back = intent.getStringExtra("Go_or_Back");
        String Time = intent.getStringExtra("Time");

        Log.d("ReservationActivity", "Id=" + Id);
        Log.d("ReservationActivity", "Date=" + Date);
        Log.d("ReservationActivity", "Location=" + Location);
        Log.d("ReservationActivity", "Go_or_Back=" + Go_or_Back);
        Log.d("ReservationActivity", "Time=" + Time);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Login_Project");

        Seat1 = findViewById(R.id.seat1);
        Seat2 = findViewById(R.id.seat2);
        Seat3 = findViewById(R.id.seat3);
        Seat4 = findViewById(R.id.seat4);
        Seat5 = findViewById(R.id.seat5);
        Seat6 = findViewById(R.id.seat6);
        Seat7 = findViewById(R.id.seat7);
        Seat8 = findViewById(R.id.seat8);
        Seat9 = findViewById(R.id.seat9);
        Seat10 = findViewById(R.id.seat10);
        Seat11 = findViewById(R.id.seat11);
        Seat12 = findViewById(R.id.seat12);
        Seat13 = findViewById(R.id.seat13);
        Seat14 = findViewById(R.id.seat14);
        Seat15 = findViewById(R.id.seat15);
        Seat16 = findViewById(R.id.seat16);
        Seat17 = findViewById(R.id.seat17);
        Seat18 = findViewById(R.id.seat18);
        Seat19 = findViewById(R.id.seat19);
        Seat20 = findViewById(R.id.seat20);
        Seat21 = findViewById(R.id.seat21);
        Seat22 = findViewById(R.id.seat22);
        Seat23 = findViewById(R.id.seat23);
        Seat24 = findViewById(R.id.seat24);
        Seat25 = findViewById(R.id.seat25);
        Seat26 = findViewById(R.id.seat26);
        Seat27 = findViewById(R.id.seat27);
        Seat28 = findViewById(R.id.seat28);
        Seat29 = findViewById(R.id.seat29);
        Seat30 = findViewById(R.id.seat30);
        Seat31 = findViewById(R.id.seat31);
        Seat32 = findViewById(R.id.seat32);
        Seat33 = findViewById(R.id.seat33);
        Seat34 = findViewById(R.id.seat34);
        Seat35 = findViewById(R.id.seat35);
        Seat36 = findViewById(R.id.seat36);
        Seat37 = findViewById(R.id.seat37);
        back_button = findViewById(R.id.back_button);

        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("1").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether = snapshot.getValue(String.class);

                Log.d("onDataChange", "whether=" + whether);

                if(whether.equals("1")) {
                    Seat1.setEnabled(false);
                }
                else {
                    Seat1.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat1.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("2").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether2 = snapshot.getValue(String.class);

                if(whether2.equals("1")) {
                    Seat2.setEnabled(false);
                }
                else {
                    Seat2.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat2.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("3").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether3 = snapshot.getValue(String.class);

                if(whether3.equals("1")){
                    Seat3.setEnabled(false);
                }
                else {
                    Seat3.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat3.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("4").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether4 = snapshot.getValue(String.class);

                if(whether4.equals("1")){
                    Seat4.setEnabled(false);
                }
                else {
                    Seat4.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat4.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("5").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether5 = snapshot.getValue(String.class);

                if(whether5.equals("1")){
                    Seat5.setEnabled(false);
                }
                else {
                    Seat5.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat4.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("6").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether6 = snapshot.getValue(String.class);

                if (whether6.equals("1")) {
                    Seat6.setEnabled(false);
                } else {
                    Seat6.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat6.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("7").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether7 = snapshot.getValue(String.class);

                if (whether7.equals("1")) {
                    Seat7.setEnabled(false);
                } else {
                    Seat7.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat7.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("8").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether8 = snapshot.getValue(String.class);

                if (whether8.equals("1")) {
                    Seat8.setEnabled(false);
                } else {
                    Seat8.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat8.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("9").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether9 = snapshot.getValue(String.class);

                if (whether9.equals("1")) {
                    Seat9.setEnabled(false);
                } else {
                    Seat9.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat9.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("10").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether10 = snapshot.getValue(String.class);

                if (whether10.equals("1")) {
                    Seat10.setEnabled(false);
                } else {
                    Seat10.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat10.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("11").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether11 = snapshot.getValue(String.class);

                if (whether11.equals("1")) {
                    Seat11.setEnabled(false);
                } else {
                    Seat11.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat11.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("12").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether12 = snapshot.getValue(String.class);

                if (whether12.equals("1")) {
                    Seat12.setEnabled(false);
                } else {
                    Seat12.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat12.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("13").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether13 = snapshot.getValue(String.class);

                if (whether13.equals("1")) {
                    Seat13.setEnabled(false);
                } else {
                    Seat13.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat13.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("14").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether14 = snapshot.getValue(String.class);

                if (whether14.equals("1")) {
                    Seat14.setEnabled(false);
                } else {
                    Seat14.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat14.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("15").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether15 = snapshot.getValue(String.class);

                if (whether15.equals("1")) {
                    Seat15.setEnabled(false);
                } else {
                    Seat15.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat15.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("16").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether16 = snapshot.getValue(String.class);

                if (whether16.equals("1")) {
                    Seat16.setEnabled(false);
                } else {
                    Seat16.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat16.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("17").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether17 = snapshot.getValue(String.class);

                if (whether17.equals("1")) {
                    Seat17.setEnabled(false);
                } else {
                    Seat17.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat17.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("18").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether18 = snapshot.getValue(String.class);

                if (whether18.equals("1")) {
                    Seat18.setEnabled(false);
                } else {
                    Seat18.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat18.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("19").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether19 = snapshot.getValue(String.class);

                if (whether19.equals("1")) {
                    Seat19.setEnabled(false);
                } else {
                    Seat19.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat19.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("20").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether20 = snapshot.getValue(String.class);

                if (whether20.equals("1")) {
                    Seat20.setEnabled(false);
                } else {
                    Seat20.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat20.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("21").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether21 = snapshot.getValue(String.class);

                if (whether21.equals("1")) {
                    Seat21.setEnabled(false);
                } else {
                    Seat21.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat21.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("22").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether22 = snapshot.getValue(String.class);

                if (whether22.equals("1")) {
                    Seat2.setEnabled(false);
                } else {
                    Seat22.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat22.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("23").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether23 = snapshot.getValue(String.class);

                if (whether23.equals("1")) {
                    Seat23.setEnabled(false);
                } else {
                    Seat23.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat23.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("24").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether24 = snapshot.getValue(String.class);

                if (whether24.equals("1")) {
                    Seat24.setEnabled(false);
                } else {
                    Seat24.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat24.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("25").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether25 = snapshot.getValue(String.class);

                if (whether25.equals("1")) {
                    Seat25.setEnabled(false);
                } else {
                    Seat25.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat25.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("26").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether26 = snapshot.getValue(String.class);

                if (whether26.equals("1")) {
                    Seat26.setEnabled(false);
                } else {
                    Seat26.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat26.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("27").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether27 = snapshot.getValue(String.class);

                if (whether27.equals("1")) {
                    Seat27.setEnabled(false);
                } else {
                    Seat27.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat27.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("28").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether28 = snapshot.getValue(String.class);

                if (whether28.equals("1")) {
                    Seat28.setEnabled(false);
                } else {
                    Seat28.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat28.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("29").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether29 = snapshot.getValue(String.class);

                if (whether29.equals("1")) {
                    Seat29.setEnabled(false);
                } else {
                    Seat29.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat29.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("30").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether30 = snapshot.getValue(String.class);

                if (whether30.equals("1")) {
                    Seat30.setEnabled(false);
                } else {
                    Seat30.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat30.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("31").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether31 = snapshot.getValue(String.class);

                if (whether31.equals("1")) {
                    Seat31.setEnabled(false);
                } else {
                    Seat31.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat31.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("32").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether32 = snapshot.getValue(String.class);

                if (whether32.equals("1")) {
                    Seat32.setEnabled(false);
                } else {
                    Seat32.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat32.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("33").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether33 = snapshot.getValue(String.class);

                if (whether33.equals("1")) {
                    Seat33.setEnabled(false);
                } else {
                    Seat33.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat33.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("34").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether34 = snapshot.getValue(String.class);

                if (whether34.equals("1")) {
                    Seat34.setEnabled(false);
                } else {
                    Seat34.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat34.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("35").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether35 = snapshot.getValue(String.class);

                if (whether35.equals("1")) {
                    Seat3.setEnabled(false);
                } else {
                    Seat35.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat35.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("36").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether36 = snapshot.getValue(String.class);

                if (whether36.equals("1")) {
                    Seat36.setEnabled(false);
                } else {
                    Seat36.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat36.setEnabled(true);
            }
        });
        mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("37").child("whether").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                whether37 = snapshot.getValue(String.class);

                if (whether37.equals("1")) {
                    Seat37.setEnabled(false);
                } else {
                    Seat37.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Seat37.setEnabled(true);
            }
        });

        mDatabaseRef.child("UserAccount").child(Id).child("busSeat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                busSeat1 = snapshot.getValue(String.class);

                if(busSeat1.equals("0")){
                    num = 1;
                }
                else {
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            busSeat2 = snapshot.getValue(String.class);

                            if(busSeat2.equals("0")){
                                num = 2;
                            }
                            else {
                                mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        busSeat3 = snapshot.getValue(String.class);

                                        if(busSeat3.equals("0")){
                                            num = 3;
                                        }
                                        else {
                                            mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").addValueEventListener(new ValueEventListener() {
                                                @Override
                                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                    busSeat4 = snapshot.getValue(String.class);

                                                    if(busSeat4.equals("0")){
                                                        num = 4;
                                                    }
                                                    else {
                                                        mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").addValueEventListener(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                                busSeat5 = snapshot.getValue(String.class);

                                                                if(busSeat5.equals("0")){
                                                                    num = 5;
                                                                }
                                                                else {
                                                                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").addValueEventListener(new ValueEventListener() {
                                                                        @Override
                                                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                                            busSeat6 = snapshot.getValue(String.class);

                                                                            if(busSeat6.equals("0")){
                                                                                num = 6;
                                                                            }
                                                                            else {
                                                                                mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").addValueEventListener(new ValueEventListener() {
                                                                                    @Override
                                                                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                                                        busSeat7 = snapshot.getValue(String.class);

                                                                                        if(busSeat7.equals("0")){
                                                                                            num = 7;
                                                                                        }
                                                                                        else {
                                                                                            mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").addValueEventListener(new ValueEventListener() {
                                                                                                @Override
                                                                                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                                                                    busSeat8 = snapshot.getValue(String.class);

                                                                                                    if(busSeat8.equals("0")){
                                                                                                        num = 8;
                                                                                                    }
                                                                                                    else {
                                                                                                        mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").addValueEventListener(new ValueEventListener() {
                                                                                                            @Override
                                                                                                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                                                                                busSeat9 = snapshot.getValue(String.class);

                                                                                                                if(busSeat9.equals("0")){
                                                                                                                    num = 9;
                                                                                                                }
                                                                                                                else {
                                                                                                                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").addValueEventListener(new ValueEventListener() {
                                                                                                                        @Override
                                                                                                                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                                                                                            busSeat10 = snapshot.getValue(String.class);

                                                                                                                            if(busSeat10.equals("0")){
                                                                                                                                num = 10;
                                                                                                                            }
                                                                                                                            else {
                                                                                                                                num = 11;
                                                                                                                                reservation_lock = "1";
                                                                                                                            }
                                                                                                                        }

                                                                                                                        @Override
                                                                                                                        public void onCancelled(@NonNull DatabaseError error) {

                                                                                                                        }
                                                                                                                    });
                                                                                                                }
                                                                                                            }

                                                                                                            @Override
                                                                                                            public void onCancelled(@NonNull DatabaseError error) {

                                                                                                            }
                                                                                                        });
                                                                                                    }
                                                                                                }

                                                                                                @Override
                                                                                                public void onCancelled(@NonNull DatabaseError error) {

                                                                                                }
                                                                                            });
                                                                                        }
                                                                                    }

                                                                                    @Override
                                                                                    public void onCancelled(@NonNull DatabaseError error) {

                                                                                    }
                                                                                });
                                                                            }
                                                                        }

                                                                        @Override
                                                                        public void onCancelled(@NonNull DatabaseError error) {

                                                                        }
                                                                    });
                                                                }
                                                            }

                                                            @Override
                                                            public void onCancelled(@NonNull DatabaseError error) {

                                                            }
                                                        });
                                                    }
                                                }

                                                @Override
                                                public void onCancelled(@NonNull DatabaseError error) {

                                                }
                                            });
                                        }
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {

                                    }
                                });
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        Seat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("1").setValue(busSeat);

                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "1");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "1");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "1");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "1");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "1");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "1");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "1");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "1");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "1");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "1");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("1").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("1").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("2").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "2");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "2");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "2");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "2");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "2");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "2");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "2");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "2");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "2");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "2");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("2").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("2").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("3").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "3");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "3");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "3");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "3");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "3");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "3");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "3");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "3");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "3");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "3");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("3").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("3").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("4").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "4");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "4");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "4");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "4");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "4");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "4");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "4");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "4");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "4");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "4");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("4").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("4").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("5").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "5");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "5");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "5");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "5");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "5");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "5");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "5");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "5");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "5");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "5");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("5").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("5").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("6").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "6");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "6");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "6");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "6");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "6");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "6");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "6");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "6");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "6");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "6");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("6").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("6").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("7").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "7");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "7");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "7");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "7");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "7");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "7");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "7");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "7");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "7");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "7");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("7").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("7").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("8").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "8");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "8");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "8");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "8");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "8");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "8");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "8");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "8");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "8");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "8");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("8").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("8").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("9").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "9");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "9");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "9");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "9");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "9");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "9");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "9");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "9");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "9");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "9");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("9").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("9").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("10").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "10");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "10");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "10");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "10");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "10");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "10");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "10");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "10");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "10");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "10");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("10").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("10").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("11").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "11");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "11");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "11");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "11");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "11");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "11");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "11");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "11");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "11");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "11");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("11").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("11").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("12").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "12");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "12");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "12");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "12");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "12");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "12");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "12");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "12");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "12");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "12");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("12").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("12").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("13").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "13");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "13");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "13");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "13");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "13");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "13");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "13");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "13");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "13");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "13");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("13").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("13").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("14").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "14");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "14");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "14");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "14");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "14");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "14");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "14");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "14");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "14");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "14");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("14").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("14").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("15").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "15");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "15");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "15");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "15");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "15");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "15");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "15");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "15");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "15");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "15");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("15").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("15").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("16").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "16");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "16");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "16");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "16");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "16");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "16");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "16");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "16");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "16");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "16");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("16").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("16").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("17").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "17");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "17");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "17");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "17");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "17");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "17");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "17");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "17");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "17");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "17");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("17").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("17").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("18").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "18");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "18");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "18");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "18");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "18");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "18");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "18");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "18");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "18");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "18");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("18").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("18").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("19").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "19");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "19");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "19");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "19");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "19");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "19");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "19");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "19");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "19");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "19");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("19").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("19").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("20").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "20");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "20");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "20");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "20");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "20");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "20");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "20");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "20");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "20");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "20");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("20").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("20").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("21").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "21");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "21");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "21");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "21");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "21");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "21");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "21");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "21");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "21");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "21");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("21").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("21").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("22").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "22");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "22");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "22");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "22");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "22");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "22");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "22");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "22");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "22");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "22");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("22").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("22").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("23").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "23");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "23");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "23");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "23");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "23");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "23");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "23");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "23");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "23");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "23");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("23").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("23").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("24").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "24");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "24");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "24");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "24");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "24");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "24");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "24");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "24");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "24");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "24");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("24").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("24").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("25").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "25");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "25");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "25");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "25");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "25");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "25");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "25");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "25");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "25");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "25");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("25").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("25").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("26").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "26");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "26");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "26");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "26");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "26");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "26");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "26");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "26");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "26");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "26");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("26").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("26").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("27").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "27");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "27");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "27");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "27");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "27");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "27");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "27");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "27");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "27");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "27");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("27").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("27").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("28").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "28");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "28");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "28");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "28");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "28");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "28");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "28");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "28");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "28");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "28");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("28").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("28").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("29").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "29");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "29");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "29");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "29");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "29");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "29");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "29");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "29");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "29");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "29");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("29").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("29").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("30").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "30");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "30");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "30");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "30");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "30");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "30");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "30");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "30");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "30");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "30");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("30").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("30").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("31").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "31");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "31");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "31");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "31");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "31");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "31");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "31");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "31");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "31");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "31");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("31").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("31").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("32").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "32");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "32");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "32");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "32");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "32");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "32");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "32");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "32");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "32");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "32");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("32").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("32").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("33").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "33");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "33");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "33");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "33");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "33");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "33");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "33");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "33");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "33");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "33");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("33").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("33").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("34").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "34");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "34");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "34");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "34");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "34");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "34");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "34");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "34");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "34");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "34");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("34").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("34").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("35").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "35");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "35");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "35");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "35");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "35");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "35");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "35");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "35");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "35");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "35");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("35").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("35").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("36").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "36");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "36");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "36");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "36");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "36");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "36");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "36");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "36");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "36");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "36");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("36").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("36").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });
        Seat37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("1");
                String strClient = new String(Id);

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("37").setValue(busSeat);
                if(num == 1){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "37");
                }
                else if(num == 2){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "37");
                }
                else if(num == 3){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "37");
                }
                else if(num == 4){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "37");
                }
                else if(num == 5){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "37");
                }
                else if(num == 6){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "37");
                }
                else if(num == 7){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "37");
                }
                else if(num == 8){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "37");
                }
                else if(num == 9){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "37");
                }
                else if(num == 10){
                    Toast.makeText(ReservationActivity.this, "좌석예약에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue(Date + "/" + Location + "/" + Go_or_Back + "/" + Time + "/" + "37");
                }
                else if(num == 11){
                    Toast.makeText(ReservationActivity.this, "더이상 예약할 수 없습니다.", Toast.LENGTH_SHORT).show();
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("37").child("client").setValue("10");
                    mDatabaseRef.child(Date).child(Location).child(Go_or_Back).child(Time).child("37").child("whether").setValue("0");
                }

                Intent intent1 = new Intent(ReservationActivity.this , ReservationInformationActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                if(Location.equals("안산")){
                    if(Go_or_Back.equals("등교")){
                        Intent intent2 = new Intent(ReservationActivity.this , AnsanGoActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", Date);
                        intent2.putExtra("whether", 2);
                        startActivity(intent2);
                    }
                    else if(Go_or_Back.equals("하교")){
                        Intent intent2 = new Intent(ReservationActivity.this , AnsanBackActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", Date);
                        intent2.putExtra("whether", 2);
                        startActivity(intent2);
                    }
                }
                if(Location.equals("안양")){
                    if(Go_or_Back.equals("등교")){
                        Intent intent2 = new Intent(ReservationActivity.this , AnyangGoActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", Date);
                        intent2.putExtra("whether", 2);
                        startActivity(intent2);
                    }
                    else if(Go_or_Back.equals("하교")){
                        Intent intent2 = new Intent(ReservationActivity.this , AnyangBackActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", Date);
                        intent2.putExtra("whether", 2);
                        startActivity(intent2);
                    }
                }
                if(Location.equals("분당")){
                    if(Go_or_Back.equals("등교")){
                        Intent intent2 = new Intent(ReservationActivity.this , BundangGoActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", Date);
                        intent2.putExtra("whether", 2);
                        startActivity(intent2);
                    }
                    else if(Go_or_Back.equals("하교")){
                        Intent intent2 = new Intent(ReservationActivity.this , BundangBackActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", Date);
                        intent2.putExtra("whether", 2);
                        startActivity(intent2);
                    }
                }
                if(Location.equals("수원,병점,오산,평택")){
                    if(Go_or_Back.equals("등교")){
                        Intent intent2 = new Intent(ReservationActivity.this , FourGoActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", Date);
                        intent2.putExtra("whether", 2);
                        startActivity(intent2);
                    }
                }
                if(Location.equals("교대")){
                    if(Go_or_Back.equals("등교")){
                        Intent intent2 = new Intent(ReservationActivity.this , GyodaeGoActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", Date);
                        intent2.putExtra("whether", 2);
                        startActivity(intent2);
                    }
                    else if(Go_or_Back.equals("하교")){
                        Intent intent2 = new Intent(ReservationActivity.this , GyodaeBackActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", Date);
                        intent2.putExtra("whether", 2);
                        startActivity(intent2);
                    }
                }
                if(Location.equals("인천")){
                    if(Go_or_Back.equals("등교")){
                        Intent intent2 = new Intent(ReservationActivity.this , IncheonGoActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", Date);
                        intent2.putExtra("whether", 2);
                        startActivity(intent2);
                    }
                    else if(Go_or_Back.equals("하교")){
                        Intent intent2 = new Intent(ReservationActivity.this , IncheonBackActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", Date);
                        intent2.putExtra("whether", 2);
                        startActivity(intent2);
                    }
                }
                if(Location.equals("잠실")){
                    if(Go_or_Back.equals("등교")){
                        Intent intent2 = new Intent(ReservationActivity.this , JamsilGoActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", Date);
                        intent2.putExtra("whether", 2);
                        startActivity(intent2);
                    }
                }
                if(Location.equals("죽전")){
                    if(Go_or_Back.equals("등교")){
                        Intent intent2 = new Intent(ReservationActivity.this , JukjeonGoActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", Date);
                        intent2.putExtra("whether", 2);
                        startActivity(intent2);
                    }
                }
                if(Location.equals("수원")){
                    if(Go_or_Back.equals("등교")){
                        Intent intent2 = new Intent(ReservationActivity.this , SuwonGoActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", Date);
                        intent2.putExtra("whether", 2);
                        startActivity(intent2);
                    }
                }
                if(Location.equals("영등포")){
                    if(Go_or_Back.equals("등교")){
                        Intent intent2 = new Intent(ReservationActivity.this , YeongdeungpoGoActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", Date);
                        intent2.putExtra("whether", 2);
                        startActivity(intent2);
                    }
                }
                if(Location.equals("용인")){
                    if(Go_or_Back.equals("등교")){
                        Intent intent2 = new Intent(ReservationActivity.this , YonginGoActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", Date);
                        intent2.putExtra("whether", 2);
                        startActivity(intent2);
                    }
                }
                */
               finish();
            }
        });
    }
}
