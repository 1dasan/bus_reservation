package com.example.login_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login_project.admin.AdminMainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private EditText Id, Password;
    private Button login_button;
    private Button register_button;
    private String adminId;
    private String adminPwd;
    private int check = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Login_Project");

        Id = findViewById(R.id.et_Email);
        Password = findViewById(R.id.et_Password);

        login_button = findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strId = Id.getText().toString();
                String strPwd = Password.getText().toString();

                check = 0;

                mDatabaseRef.child("AdminAccount").child("adminId").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        adminId = snapshot.getValue(String.class);

                        if(adminId.equals(strId)){
                            check++;
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                mDatabaseRef.child("AdminAccount").child("adminPwd").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        adminPwd = snapshot.getValue(String.class);

                        if(adminPwd.equals(strPwd)){
                            check++;
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                mFirebaseAuth.signInWithEmailAndPassword(strId, strPwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            if(check == 2) {
                                Intent intent2 = new Intent(MainActivity.this, AdminMainActivity.class);
                                Toast.makeText(MainActivity.this, "관리자 로그인에 성공했습니다", Toast.LENGTH_SHORT).show();
                                startActivity(intent2);
                                check = 0;
                            }
                            else {
                                Intent intent = new Intent(MainActivity.this, MainScreenActivity.class);
                                intent.putExtra("userId", mFirebaseAuth.getUid());
                                startActivity(intent);
                                Toast.makeText(MainActivity.this, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "로그인에 실패했습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        register_button = findViewById(R.id.register_button);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}