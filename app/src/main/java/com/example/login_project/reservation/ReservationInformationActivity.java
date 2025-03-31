package com.example.login_project.reservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login_project.MainScreenActivity;
import com.example.login_project.R;
import com.example.login_project.database.BusSeat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ReservationInformationActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private String client;
    private String client2;
    private String client3;
    private String client4;
    private String client5;
    private String client6;
    private String client7;
    private String client8;
    private String client9;
    private String client10;

    private TextView text;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView text5;
    private TextView text6;
    private TextView text7;
    private TextView text8;
    private TextView text9;
    private TextView text10;

    private Button cancel_button;
    private Button cancel_button2;
    private Button cancel_button3;
    private Button cancel_button4;
    private Button cancel_button5;
    private Button cancel_button6;
    private Button cancel_button7;
    private Button cancel_button8;
    private Button cancel_button9;
    private Button cancel_button10;
    private Button back_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_information);

        Intent intent = getIntent();

        String Id = intent.getStringExtra("userId");

        text = findViewById(R.id.textView);
        text2 = findViewById(R.id.textView3);
        text3 = findViewById(R.id.textView4);
        text4 = findViewById(R.id.textView5);
        text5 = findViewById(R.id.textView6);
        text6 = findViewById(R.id.textView7);
        text7 = findViewById(R.id.textView8);
        text8 = findViewById(R.id.textView9);
        text9 = findViewById(R.id.textView10);
        text10 = findViewById(R.id.textView11);
        cancel_button = findViewById(R.id.seat_cancel_button);
        cancel_button2 = findViewById(R.id.seat_cancel_button2);
        cancel_button3 = findViewById(R.id.seat_cancel_button3);
        cancel_button4 = findViewById(R.id.seat_cancel_button4);
        cancel_button5 = findViewById(R.id.seat_cancel_button5);
        cancel_button6 = findViewById(R.id.seat_cancel_button6);
        cancel_button7 = findViewById(R.id.seat_cancel_button7);
        cancel_button8 = findViewById(R.id.seat_cancel_button8);
        cancel_button9 = findViewById(R.id.seat_cancel_button9);
        cancel_button10 = findViewById(R.id.seat_cancel_button10);

        back_button = findViewById(R.id.back_button);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Login_Project");

        mDatabaseRef.child("UserAccount").child(Id).child("busSeat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                client = snapshot.getValue(String.class);

                if(!client.equals("0")){
                    text.setText(client);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                client2 = snapshot.getValue(String.class);

                if(!client2.equals("0")){
                    text2.setText(client2);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                client3 = snapshot.getValue(String.class);

                if(!client3.equals("0")){
                    text3.setText(client3);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                client4 = snapshot.getValue(String.class);

                if(!client4.equals("0")){
                    text4.setText(client4);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                client5 = snapshot.getValue(String.class);

                if(!client5.equals("0")){
                    text5.setText(client5);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                client6 = snapshot.getValue(String.class);

                if(!client6.equals("0")){
                    text6.setText(client6);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                client7 = snapshot.getValue(String.class);

                if(!client7.equals("0")){
                    text7.setText(client7);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                client8 = snapshot.getValue(String.class);

                if(!client8.equals("0")){
                    text8.setText(client8);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                client9 = snapshot.getValue(String.class);

                if(!client9.equals("0")){
                    text9.setText(client9);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                client10 = snapshot.getValue(String.class);

                if(!client10.equals("0")){
                    text10.setText(client10);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("0");
                String strClient = new String("10");

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(client).setValue(busSeat);
                mDatabaseRef.child("UserAccount").child(Id).child("busSeat").setValue("0");

                Intent intent1 = new Intent(ReservationInformationActivity.this , MainScreenActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);

                Toast.makeText(ReservationInformationActivity.this, "예약취소에 성공하셨습니다", Toast.LENGTH_SHORT).show();
            }
        });
        cancel_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("0");
                String strClient = new String("10");

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(client2).setValue(busSeat);
                mDatabaseRef.child("UserAccount").child(Id).child("busSeat2").setValue("0");

                Intent intent1 = new Intent(ReservationInformationActivity.this , MainScreenActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);

                Toast.makeText(ReservationInformationActivity.this, "예약취소에 성공하셨습니다", Toast.LENGTH_SHORT).show();
            }
        });
        cancel_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("0");
                String strClient = new String("10");

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(client3).setValue(busSeat);
                mDatabaseRef.child("UserAccount").child(Id).child("busSeat3").setValue("0");

                Intent intent1 = new Intent(ReservationInformationActivity.this , MainScreenActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);

                Toast.makeText(ReservationInformationActivity.this, "예약취소에 성공하셨습니다", Toast.LENGTH_SHORT).show();
            }
        });
        cancel_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("0");
                String strClient = new String("10");

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(client4).setValue(busSeat);
                mDatabaseRef.child("UserAccount").child(Id).child("busSeat4").setValue("0");

                Intent intent1 = new Intent(ReservationInformationActivity.this , MainScreenActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);

                Toast.makeText(ReservationInformationActivity.this, "예약취소에 성공하셨습니다", Toast.LENGTH_SHORT).show();
            }
        });
        cancel_button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("0");
                String strClient = new String("10");

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(client5).setValue(busSeat);
                mDatabaseRef.child("UserAccount").child(Id).child("busSeat5").setValue("0");

                Intent intent1 = new Intent(ReservationInformationActivity.this , MainScreenActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);

                Toast.makeText(ReservationInformationActivity.this, "예약취소에 성공하셨습니다", Toast.LENGTH_SHORT).show();
            }
        });
        cancel_button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("0");
                String strClient = new String("10");

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(client6).setValue(busSeat);
                mDatabaseRef.child("UserAccount").child(Id).child("busSeat6").setValue("0");

                Intent intent1 = new Intent(ReservationInformationActivity.this , MainScreenActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);

                Toast.makeText(ReservationInformationActivity.this, "예약취소에 성공하셨습니다", Toast.LENGTH_SHORT).show();
            }
        });
        cancel_button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("0");
                String strClient = new String("10");

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(client7).setValue(busSeat);
                mDatabaseRef.child("UserAccount").child(Id).child("busSeat7").setValue("0");

                Intent intent1 = new Intent(ReservationInformationActivity.this , MainScreenActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);

                Toast.makeText(ReservationInformationActivity.this, "예약취소에 성공하셨습니다", Toast.LENGTH_SHORT).show();
            }
        });
        cancel_button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("0");
                String strClient = new String("10");

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(client8).setValue(busSeat);
                mDatabaseRef.child("UserAccount").child(Id).child("busSeat8").setValue("0");

                Intent intent1 = new Intent(ReservationInformationActivity.this , MainScreenActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);

                Toast.makeText(ReservationInformationActivity.this, "예약취소에 성공하셨습니다", Toast.LENGTH_SHORT).show();
            }
        });
        cancel_button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("0");
                String strClient = new String("10");

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(client9).setValue(busSeat);
                mDatabaseRef.child("UserAccount").child(Id).child("busSeat9").setValue("0");

                Intent intent1 = new Intent(ReservationInformationActivity.this , MainScreenActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);

                Toast.makeText(ReservationInformationActivity.this, "예약취소에 성공하셨습니다", Toast.LENGTH_SHORT).show();
            }
        });
        cancel_button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strWhether = new String("0");
                String strClient = new String("10");

                BusSeat busSeat = new BusSeat();

                busSeat.setClient(strClient);
                busSeat.setWhether(strWhether);

                mDatabaseRef.child(client10).setValue(busSeat);
                mDatabaseRef.child("UserAccount").child(Id).child("busSeat10").setValue("0");

                Intent intent1 = new Intent(ReservationInformationActivity.this , MainScreenActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);

                Toast.makeText(ReservationInformationActivity.this, "예약취소에 성공하셨습니다", Toast.LENGTH_SHORT).show();
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(ReservationInformationActivity.this , MainScreenActivity.class);
                intent1.putExtra("userId", Id);
                startActivity(intent1);
                finish();
            }
        });
    }
}