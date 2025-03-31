package com.example.login_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login_project.database.UserAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private DatabaseReference mDatabaseRef;
    private EditText Id, Password, Password2, Name;
    private Button Register_button;
    private Button Login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Login_Project");

        Id = findViewById(R.id.et_id);
        Password = findViewById(R.id.et_pwd);
        Password2 = findViewById(R.id.et_pwd2);
        Name = findViewById(R.id.et_name);
        Register_button = findViewById(R.id.register_button2);
        Login_button = findViewById(R.id.login_button2);

        Register_button.setEnabled(false);

        Password2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(Password.getText().toString().equals(Password2.getText().toString())){
                   Register_button.setEnabled(true);
                }
                else{
                    Register_button.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        Register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strId = Id.getText().toString();
                String strPwd = Password.getText().toString();
                String strName = Name.getText().toString();

                mFirebaseAuth.createUserWithEmailAndPassword(strId, strPwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                            UserAccount account = new UserAccount();
                            account.setIdToken(firebaseUser.getUid());
                            account.setEmailId(firebaseUser.getEmail());
                            account.setPassword(strPwd);
                            account.setUserName(strName);

                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).child("busSeat").setValue("0");
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).child("busSeat2").setValue("0");
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).child("busSeat3").setValue("0");
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).child("busSeat4").setValue("0");
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).child("busSeat5").setValue("0");
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).child("busSeat6").setValue("0");
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).child("busSeat7").setValue("0");
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).child("busSeat8").setValue("0");
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).child("busSeat9").setValue("0");
                            mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).child("busSeat10").setValue("0");

                            Toast.makeText(RegisterActivity.this, "회원가입에 성공하셨습니다", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this , MainActivity.class);
                            startActivity(intent);
                        } else{
                            Toast.makeText(RegisterActivity.this, "회원가입에 실패하셨습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
//                    Intent intent = new Intent(RegisterActivity.this , MainActivity.class);
//                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}