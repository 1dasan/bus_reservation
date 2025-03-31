package com.example.login_project.reservation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ReservationSettingActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private Button go_or_back_button;
    private Button location_button;
    private Button inquiry_button;
    private Button date_button;
    private Button back_button;
    private int count = 0;
    private String go_or_back;
    private String location;
    private String date_or;
    private String a;
    private String exist;
    private String friday;
    long now = System.currentTimeMillis();

    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_setting);

        Intent intent = getIntent();

        String Id = intent.getStringExtra("userId");

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Login_Project");
        go_or_back_button = findViewById(R.id.go_or_back_button);
        location_button = findViewById(R.id.location_button);
        inquiry_button = findViewById(R.id.inquiry_button);
        date_button = findViewById(R.id.date_button);
        back_button = findViewById(R.id.back_button2);
        Date date = new Date(now);
        SimpleDateFormat mFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.KOREA);
        String today = mFormat.format(new Date());

        inquiry_button.setEnabled(false);

        date_button.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                go_or_back = go_or_back_button.getText().toString();
                location = location_button.getText().toString();
                date_or = date_button.getText().toString();

                mDatabaseRef.child(date_or).child("Exist").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        exist = snapshot.getValue(String.class);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                if(!go_or_back.equals("등교 / 하교")){
                    if(!location.equals("지역선택")){
                        inquiry_button.setEnabled(true);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        go_or_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                date_or = date_button.getText().toString();

                AlertDialog.Builder dlg = new AlertDialog.Builder(ReservationSettingActivity.this);
                dlg.setTitle("등교 / 하교");
                final String[] versionArray = new String[] {"등교","하교"};

                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        go_or_back_button.setText(versionArray[i]);
                    }
                });
                dlg.show();

            }
        });

        location_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(ReservationSettingActivity.this);
                dlg.setTitle("지역선택");
                final String[] versionArray = new String[] {"영등포","교대","잠실","분당","인천, 송내","안산","안양","수원","용인","수원, 병점, 오산, 평택","죽전"};

                dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        location_button.setText(versionArray[i]);
                    }
                });
                dlg.show();
            }
        });

        date_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int Year = calendar.get(Calendar.YEAR);
                int Month = calendar.get(Calendar.MONTH);
                int Day = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(ReservationSettingActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month += 1;
                        String date = year + "/" + month + "/" + day;

                        date_button.setText(date);
                        }
                    }, Year, Month, Day);
                datePickerDialog.show();

                }
        });

        inquiry_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                go_or_back = go_or_back_button.getText().toString();
                location = location_button.getText().toString();
                date_or = date_button.getText().toString();

                if(date_or.equals("2022/12/2") || date_or.equals("2022/12/9") || date_or.equals("2022/12/16") || date_or.equals("2022/12/23") || date_or.equals("2022/12/30")){
                    friday = "1";
                }
                else {
                    friday = "0";
                }

                if(exist.equals("1")){
                    if (go_or_back.equals("등교")) {
                        count += 1;
                    } else if (go_or_back.equals("하교")) {
                        count += 2;
                    }

                    if (location == ("영등포")) {
                        count += 10;
                    } else if (location == ("교대")) {
                        count += 20;
                    } else if (location == ("잠실")) {
                        count += 30;
                    } else if (location == ("분당")) {
                        count += 40;
                    } else if (location == ("인천, 송내")) {
                        count += 50;
                    } else if (location == ("안산")) {
                        count += 60;
                    } else if (location == ("안양")) {
                        count += 70;
                    } else if (location == ("수원")) {
                        count += 80;
                    } else if (location == ("용인")) {
                        count += 90;
                    } else if (location == ("수원, 병점, 오산, 평택")) {
                        count += 100;
                    } else if (location == ("죽전")) {
                        count += 110;
                    }

                    if (count == 11) {
                        Intent intent = new Intent(ReservationSettingActivity.this, YeongdeungpoGoActivity.class);
                        intent.putExtra("userId", Id);
                        intent.putExtra("Date", date_or);
                        intent.putExtra("whether", 2);
                        intent.putExtra("friday", friday);
                        startActivity(intent);
                    } else if (count == 21) {
                        Intent intent1 = new Intent(ReservationSettingActivity.this, GyodaeGoActivity.class);
                        intent1.putExtra("userId", Id);
                        intent1.putExtra("Date", date_or);
                        intent1.putExtra("whether", 2);
                        intent1.putExtra("friday", friday);
                        startActivity(intent1);
                    } else if (count == 22) {
                        Intent intent2 = new Intent(ReservationSettingActivity.this, GyodaeBackActivity.class);
                        intent2.putExtra("userId", Id);
                        intent2.putExtra("Date", date_or);
                        intent2.putExtra("whether", 2);
                        intent2.putExtra("friday", friday);
                        startActivity(intent2);
                    } else if (count == 31) {
                        Intent intent3 = new Intent(ReservationSettingActivity.this, JamsilGoActivity.class);
                        intent3.putExtra("userId", Id);
                        intent3.putExtra("Date", date_or);
                        intent3.putExtra("whether", 2);
                        intent3.putExtra("friday", friday);
                        startActivity(intent3);
                    } else if (count == 41) {
                        Intent intent4 = new Intent(ReservationSettingActivity.this, BundangGoActivity.class);
                        intent4.putExtra("userId", Id);
                        intent4.putExtra("Date", date_or);
                        intent4.putExtra("whether", 2);
                        intent4.putExtra("friday", friday);
                        startActivity(intent4);
                    } else if (count == 42) {
                        Intent intent5 = new Intent(ReservationSettingActivity.this, BundangBackActivity.class);
                        intent5.putExtra("userId", Id);
                        intent5.putExtra("Date", date_or);
                        intent5.putExtra("whether", 2);
                        intent5.putExtra("friday", friday);
                        startActivity(intent5);
                    } else if (count == 51) {
                        Intent intent6 = new Intent(ReservationSettingActivity.this, IncheonGoActivity.class);
                        intent6.putExtra("userId", Id);
                        intent6.putExtra("Date", date_or);
                        intent6.putExtra("whether", 2);
                        intent6.putExtra("friday", friday);
                        startActivity(intent6);
                    } else if (count == 52) {
                        Intent intent7 = new Intent(ReservationSettingActivity.this, IncheonBackActivity.class);
                        intent7.putExtra("userId", Id);
                        intent7.putExtra("Date", date_or);
                        intent7.putExtra("whether", 2);
                        intent7.putExtra("friday", friday);
                        startActivity(intent7);
                    } else if (count == 61) {
                        Intent intent8 = new Intent(ReservationSettingActivity.this, AnsanGoActivity.class);
                        intent8.putExtra("userId", Id);
                        intent8.putExtra("Date", date_or);
                        intent8.putExtra("whether", 2);
                        intent8.putExtra("friday", friday);
                        startActivity(intent8);
                    } else if (count == 62) {
                        Intent intent9 = new Intent(ReservationSettingActivity.this, AnsanBackActivity.class);
                        intent9.putExtra("userId", Id);
                        intent9.putExtra("Date", date_or);
                        intent9.putExtra("whether", 2);
                        intent9.putExtra("friday", friday);
                        startActivity(intent9);
                    } else if (count == 71) {
                        Intent intent10 = new Intent(ReservationSettingActivity.this, AnyangGoActivity.class);
                        intent10.putExtra("userId", Id);
                        intent10.putExtra("Date", date_or);
                        intent10.putExtra("whether", 2);
                        intent10.putExtra("friday", friday);
                        startActivity(intent10);
                    } else if (count == 72) {
                        Intent intent11 = new Intent(ReservationSettingActivity.this, AnyangBackActivity.class);
                        intent11.putExtra("userId", Id);
                        intent11.putExtra("Date", date_or);
                        intent11.putExtra("whether", 2);
                        intent11.putExtra("friday", friday);
                        startActivity(intent11);
                    } else if (count == 81) {
                        Intent intent12 = new Intent(ReservationSettingActivity.this, SuwonGoActivity.class);
                        intent12.putExtra("userId", Id);
                        intent12.putExtra("Date", date_or);
                        intent12.putExtra("whether", 2);
                        intent12.putExtra("friday", friday);
                        startActivity(intent12);
                    } else if (count == 82) {
                        Intent intent11 = new Intent(ReservationSettingActivity.this, AnyangBackActivity.class);
                        intent11.putExtra("userId", Id);
                        intent11.putExtra("Date", date_or);
                        intent11.putExtra("whether", 2);
                        intent11.putExtra("friday", friday);
                        startActivity(intent11);
                    } else if (count == 91) {
                        Intent intent13 = new Intent(ReservationSettingActivity.this, YonginGoActivity.class);
                        intent13.putExtra("userId", Id);
                        intent13.putExtra("Date", date_or);
                        intent13.putExtra("whether", 2);
                        intent13.putExtra("friday", friday);
                        startActivity(intent13);
                    } else if (count == 101) {
                        Intent intent14 = new Intent(ReservationSettingActivity.this, FourGoActivity.class);
                        intent14.putExtra("userId", Id);
                        intent14.putExtra("Date", date_or);
                        intent14.putExtra("whether", 2);
                        intent14.putExtra("friday", friday);
                        startActivity(intent14);
                    } else if (count == 111) {
                        Intent intent15 = new Intent(ReservationSettingActivity.this, JukjeonGoActivity.class);
                        intent15.putExtra("userId", Id);
                        intent15.putExtra("Date", date_or);
                        intent15.putExtra("whether", 2);
                        intent15.putExtra("friday", friday);
                        startActivity(intent15);
                    } else {
                        Toast.makeText(ReservationSettingActivity.this, "조회에 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                    count = 0;
                }
                else if(exist.equals("0")){
                    Toast.makeText(ReservationSettingActivity.this, "조회에 실패했습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent1 = new Intent(ReservationSettingActivity.this , MainScreenActivity.class);
//                intent1.putExtra("userId", Id);
//                startActivity(intent1);
                finish();
            }
        });
    }
}