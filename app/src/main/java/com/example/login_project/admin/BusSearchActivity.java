package com.example.login_project.admin;

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
import com.example.login_project.reservation.ReservationSettingActivity;
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

public class BusSearchActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private Button go_or_back_button;
    private Button location_button;
    private Button inquiry_button;
    private Button date_button;
    private Button all_button;
    private Button back_button;
    private int count = 0;
    private String go_or_back;
    private String location;
    private String date_or;
    private String friday = "0";
    long now = System.currentTimeMillis();

    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_search);

        Intent intent = getIntent();

        int whether = intent.getIntExtra("whether", 0);

       // all_button.setText(count);

        go_or_back_button = findViewById(R.id.Ad_go_or_back_button);
        location_button = findViewById(R.id.Ad_location_button);
        inquiry_button = findViewById(R.id.Ad_inquiry_button);
        date_button = findViewById(R.id.Ad_date_button);
        all_button = findViewById(R.id.Ad_all_button);
        back_button = findViewById(R.id.back_button19);
        Date date = new Date(now);
        SimpleDateFormat mFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.KOREA);
        String today = mFormat.format(new Date());

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Login_Project");

        go_or_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(BusSearchActivity.this);
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
                AlertDialog.Builder dlg = new AlertDialog.Builder(BusSearchActivity.this);
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

                datePickerDialog = new DatePickerDialog(BusSearchActivity.this, new DatePickerDialog.OnDateSetListener() {
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

                if(!date_or.equals("날짜")){
                    count += 1000;
                }
                if (go_or_back == ("등교")) {
                    count += 1;
                } else if (go_or_back == ("하교")) {
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

                if (count == 1011) {
                    Intent intent = new Intent(BusSearchActivity.this, YeongdeungpoGoActivity.class);
                    intent.putExtra("Date", date_or);
                    intent.putExtra("whether", whether);
                    intent.putExtra("friday", friday);
                    startActivity(intent);
                } else if (count == 1021) {
                    Intent intent1 = new Intent(BusSearchActivity.this, GyodaeGoActivity.class);
                    intent1.putExtra("Date", date_or);
                    intent1.putExtra("whether", whether);
                    intent1.putExtra("friday", friday);
                    startActivity(intent1);
                } else if (count == 1022) {
                    Intent intent2 = new Intent(BusSearchActivity.this, GyodaeBackActivity.class);
                    intent2.putExtra("Date", date_or);
                    intent2.putExtra("whether", whether);
                    intent2.putExtra("friday", friday);
                    startActivity(intent2);
                } else if (count == 1031) {
                    Intent intent3 = new Intent(BusSearchActivity.this, JamsilGoActivity.class);
                    intent3.putExtra("Date", date_or);
                    intent3.putExtra("whether", whether);
                    intent3.putExtra("friday", friday);
                    startActivity(intent3);
                } else if (count == 1041) {
                    Intent intent4 = new Intent(BusSearchActivity.this, BundangGoActivity.class);
                    intent4.putExtra("Date", date_or);
                    intent4.putExtra("whether", whether);
                    intent4.putExtra("friday", friday);
                    startActivity(intent4);
                } else if (count == 1042) {
                    Intent intent5 = new Intent(BusSearchActivity.this, BundangBackActivity.class);
                    intent5.putExtra("Date", date_or);
                    intent5.putExtra("whether", whether);
                    intent5.putExtra("friday", friday);
                    startActivity(intent5);
                } else if (count == 1051) {
                    Intent intent6 = new Intent(BusSearchActivity.this, IncheonGoActivity.class);
                    intent6.putExtra("Date", date_or);
                    intent6.putExtra("whether", whether);
                    intent6.putExtra("friday", friday);
                    startActivity(intent6);
                } else if (count == 1052) {
                    Intent intent7 = new Intent(BusSearchActivity.this, IncheonBackActivity.class);
                    intent7.putExtra("Date", date_or);
                    intent7.putExtra("whether", whether);
                    intent7.putExtra("friday", friday);
                    startActivity(intent7);
                } else if (count == 1061) {
                    Intent intent8 = new Intent(BusSearchActivity.this, AnsanGoActivity.class);
                    intent8.putExtra("Date", date_or);
                    intent8.putExtra("whether", whether);
                    intent8.putExtra("friday", friday);
                    startActivity(intent8);
                } else if (count == 1062) {
                    Intent intent9 = new Intent(BusSearchActivity.this, AnsanBackActivity.class);
                    intent9.putExtra("Date", date_or);
                    intent9.putExtra("whether", whether);
                    intent9.putExtra("friday", friday);
                    startActivity(intent9);
                } else if (count == 1071) {
                    Intent intent10 = new Intent(BusSearchActivity.this, AnyangGoActivity.class);
                    intent10.putExtra("Date", date_or);
                    intent10.putExtra("whether", whether);
                    intent10.putExtra("friday", friday);
                    startActivity(intent10);
                } else if (count == 1072) {
                    Intent intent11 = new Intent(BusSearchActivity.this, AnyangBackActivity.class);
                    intent11.putExtra("Date", date_or);
                    intent11.putExtra("whether", whether);
                    intent11.putExtra("friday", friday);
                    startActivity(intent11);
                } else if (count == 1081) {
                    Intent intent12 = new Intent(BusSearchActivity.this, SuwonGoActivity.class);
                    intent12.putExtra("Date", date_or);
                    intent12.putExtra("whether", whether);
                    intent12.putExtra("friday", friday);
                    startActivity(intent12);
                } else if (count == 1082) {
                    Intent intent11 = new Intent(BusSearchActivity.this, AnyangBackActivity.class);
                    intent11.putExtra("Date", date_or);
                    intent11.putExtra("whether", whether);
                    intent11.putExtra("friday", friday);
                    startActivity(intent11);
                } else if (count == 1091) {
                    Intent intent13 = new Intent(BusSearchActivity.this, YonginGoActivity.class);
                    intent13.putExtra("Date", date_or);
                    intent13.putExtra("whether", whether);
                    intent13.putExtra("friday", friday);
                    startActivity(intent13);
                } else if (count == 1101) {
                    Intent intent14 = new Intent(BusSearchActivity.this, FourGoActivity.class);
                    intent14.putExtra("Date", date_or);
                    intent14.putExtra("whether", whether);
                    intent14.putExtra("friday", friday);
                    startActivity(intent14);
                } else if (count == 1111) {
                    Intent intent15 = new Intent(BusSearchActivity.this, JukjeonGoActivity.class);
                    intent15.putExtra("Date", date_or);
                    intent15.putExtra("whether", whether);
                    intent15.putExtra("friday", friday);
                    startActivity(intent15);
                } else {
                    Toast.makeText(BusSearchActivity.this, "조회에 실패했습니다.", Toast.LENGTH_SHORT).show();
                }
                count = 0;
            }
        });

        all_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                date_or = date_button.getText().toString();

                if(!date_or.equals("날짜")){
                    if(whether == 0){

                        String strWhether = new String("0");
                        String strClient = new String("10");

                        BusSeat busSeat = new BusSeat();

                        busSeat.setClient(strClient);
                        busSeat.setWhether(strWhether);

                        mDatabaseRef.child(date_or).child("Exist").setValue("1");

                        for(int i=1; i<=37; i++){
                            String seat = String.valueOf(i);
                            mDatabaseRef.child(date_or).child("영등포").child("등교").child("6:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("영등포").child("등교").child("6:30").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("교대").child("등교").child("7:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("교대").child("등교").child("7:30").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("교대").child("등교").child("8:50").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("교대").child("등교").child("8:50").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("교대").child("하교").child("12:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("교대").child("하교").child("12:30").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("교대").child("하교").child("13:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("교대").child("하교").child("13:30").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("교대").child("하교").child("14:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("교대").child("하교").child("14:30").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("교대").child("하교").child("15:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("교대").child("하교").child("15:30").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("교대").child("하교").child("16:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("교대").child("하교").child("16:30").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("교대").child("하교").child("18:10").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("교대").child("하교").child("18:10").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("잠실").child("등교").child("6:50").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("잠실").child("등교").child("6:50").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("분당").child("등교").child("7:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("분당").child("등교").child("7:30").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("분당").child("등교").child("8:50").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("분당").child("등교").child("8:50").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("분당").child("하교").child("15:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("분당").child("하교").child("15:30").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("분당").child("하교").child("16:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("분당").child("하교").child("16:30").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("분당").child("하교").child("18:10").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("분당").child("하교").child("18:10").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("인천,송내").child("등교").child("6:20").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("인천,송내").child("등교").child("6:20").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("인천,송내").child("하교").child("16:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("인천,송내").child("하교").child("16:30").child("Exist").setValue("1");

                            mDatabaseRef.child(date_or).child("인천,송내").child("하교").child("18:10").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("안산").child("등교").child("7:00").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("안산").child("하교").child("16:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("안산").child("하교").child("18:10").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("안양").child("등교").child("6:45").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("안양").child("하교").child("16:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("수원").child("등교").child("7:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("수원").child("등교").child("8:50").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("용인").child("등교").child("7:10").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("수원,병점,오산,평택").child("등교").child("7:00").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("죽전").child("등교").child("7:50").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("죽전").child("등교").child("9:10").child(seat).setValue(busSeat);

                            mDatabaseRef.child(date_or).child("인천,송내").child("하교").child("18:10").child("Exist").setValue("1");
                            mDatabaseRef.child(date_or).child("안산").child("등교").child("7:00").child("Exist").setValue("1");
                            mDatabaseRef.child(date_or).child("안산").child("하교").child("16:30").child("Exist").setValue("1");
                            mDatabaseRef.child(date_or).child("안산").child("하교").child("18:10").child("Exist").setValue("1");
                            mDatabaseRef.child(date_or).child("안양").child("등교").child("6:45").child("Exist").setValue("1");
                            mDatabaseRef.child(date_or).child("안양").child("하교").child("16:30").child("Exist").setValue("1");
                            mDatabaseRef.child(date_or).child("수원").child("등교").child("7:30").child("Exist").setValue("1");
                            mDatabaseRef.child(date_or).child("수원").child("등교").child("8:50").child("Exist").setValue("1");
                            mDatabaseRef.child(date_or).child("용인").child("등교").child("7:10").child("Exist").setValue("1");
                            mDatabaseRef.child(date_or).child("수원,병점,오산,평택").child("등교").child("7:00").child("Exist").setValue("1");
                            mDatabaseRef.child(date_or).child("죽전").child("등교").child("7:50").child("Exist").setValue("1");
                            mDatabaseRef.child(date_or).child("죽전").child("등교").child("9:10").child("Exist").setValue("1");

                        }
                        Toast.makeText(BusSearchActivity.this, "일괄처리에 성공했습니다.", Toast.LENGTH_SHORT).show();
                    }
                    else if(whether == 1){
                        String strWhether = new String("0");
                        String strClient = new String("10");

                        BusSeat busSeat = new BusSeat();

                        busSeat.setClient(strClient);
                        busSeat.setWhether(strWhether);

                        mDatabaseRef.child(date_or).child("Exist").setValue("0");

                        for(int i=1; i<=37; i++){
                            String seat = String.valueOf(i);
                            mDatabaseRef.child(date_or).child("영등포").child("등교").child("6:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("영등포").child("등교").child("6:30").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("교대").child("등교").child("7:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("교대").child("등교").child("7:30").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("교대").child("등교").child("8:50").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("교대").child("등교").child("8:50").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("교대").child("하교").child("12:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("교대").child("하교").child("12:30").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("교대").child("하교").child("13:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("교대").child("하교").child("13:30").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("교대").child("하교").child("14:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("교대").child("하교").child("14:30").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("교대").child("하교").child("15:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("교대").child("하교").child("15:30").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("교대").child("하교").child("16:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("교대").child("하교").child("16:30").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("교대").child("하교").child("18:10").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("교대").child("하교").child("18:10").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("잠실").child("등교").child("6:50").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("잠실").child("등교").child("6:50").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("분당").child("등교").child("7:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("분당").child("등교").child("7:30").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("분당").child("등교").child("8:50").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("분당").child("등교").child("8:50").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("분당").child("하교").child("15:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("분당").child("하교").child("15:30").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("분당").child("하교").child("16:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("분당").child("하교").child("16:30").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("분당").child("하교").child("18:10").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("분당").child("하교").child("18:10").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("인천,송내").child("등교").child("6:20").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("인천,송내").child("등교").child("6:20").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("인천,송내").child("하교").child("16:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("인천,송내").child("하교").child("16:30").child("Exist").setValue("0");

                            mDatabaseRef.child(date_or).child("인천,송내").child("하교").child("18:10").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("안산").child("등교").child("7:00").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("안산").child("하교").child("16:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("안산").child("하교").child("18:10").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("안양").child("등교").child("6:45").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("안양").child("하교").child("16:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("수원").child("등교").child("7:30").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("수원").child("등교").child("8:50").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("용인").child("등교").child("7:10").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("수원,병점,오산,평택").child("등교").child("7:00").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("죽전").child("등교").child("7:50").child(seat).setValue(busSeat);
                            mDatabaseRef.child(date_or).child("죽전").child("등교").child("9:10").child(seat).setValue(busSeat);

                            mDatabaseRef.child(date_or).child("인천,송내").child("하교").child("18:10").child("Exist").setValue("0");
                            mDatabaseRef.child(date_or).child("안산").child("등교").child("7:00").child("Exist").setValue("0");
                            mDatabaseRef.child(date_or).child("안산").child("하교").child("16:30").child("Exist").setValue("0");
                            mDatabaseRef.child(date_or).child("안산").child("하교").child("18:10").child("Exist").setValue("0");
                            mDatabaseRef.child(date_or).child("안양").child("등교").child("6:45").child("Exist").setValue("0");
                            mDatabaseRef.child(date_or).child("안양").child("하교").child("16:30").child("Exist").setValue("0");
                            mDatabaseRef.child(date_or).child("수원").child("등교").child("7:30").child("Exist").setValue("0");
                            mDatabaseRef.child(date_or).child("수원").child("등교").child("8:50").child("Exist").setValue("0");
                            mDatabaseRef.child(date_or).child("용인").child("등교").child("7:10").child("Exist").setValue("0");
                            mDatabaseRef.child(date_or).child("수원,병점,오산,평택").child("등교").child("7:00").child("Exist").setValue("0");
                            mDatabaseRef.child(date_or).child("죽전").child("등교").child("7:50").child("Exist").setValue("0");
                            mDatabaseRef.child(date_or).child("죽전").child("등교").child("9:10").child("Exist").setValue("0");

                        }
                        Toast.makeText(BusSearchActivity.this, "일괄처리에 성공했습니다.", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(BusSearchActivity.this, "일괄처리에 실패했습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent1 = new Intent(BusSearchActivity.this , AdminMainActivity.class);
//                startActivity(intent1);
                finish();
            }
        });
    }
}