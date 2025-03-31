package com.example.login_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BusInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        String Id = intent.getStringExtra("userId");

        setContentView(R.layout.activity_bus_information);
        TextView nabtn = (TextView) findViewById(R.id.nabtn);
        String text = "홈페이지 바로가기 ";
        nabtn.setText(text);

        Linkify.TransformFilter linktest = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher matcher, String s) {
                return "";
            }
        };
        Pattern pattern = Pattern.compile("홈페이지 바로가기");
        Linkify.addLinks(nabtn, pattern, "https://www.bu.ac.kr/web/3483/subview.do?enc=Zm5jdDF8QEB8JTJGbWFpbk5vdGljZSUyRndlYiUyRjMwMzU0JTJGYXJ0Y2xWaWV3LmRvJTNGcGFnZSUzRDElMjZzcmNoQ29sdW1uJTNEc2olMjZzcmNoV3JkJTNEJUVEJTg2JUI1JUVEJTk1JTk5JTI2", null, linktest);
    }
}