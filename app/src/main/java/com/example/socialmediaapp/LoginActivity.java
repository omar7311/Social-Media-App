package com.example.socialmediaapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText userName, password;
    Button logIn,loginAnonymously;
    TextView forgetPassword;
     FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
        login();
    }

    private void initUI() {
        userName = findViewById(R.id.userName_EditText);
        password = findViewById(R.id.passWord_EditText);
        logIn = findViewById(R.id.login_button);
        loginAnonymously=findViewById(R.id.login_button_anonymously);
        forgetPassword = findViewById(R.id.forgetPassword_textView);
        auth=FirebaseAuth.getInstance();
    }
    private void login(){
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(userName.getText().toString().isEmpty()){
                   Toast.makeText(LoginActivity.this, "enter user name ", Toast.LENGTH_SHORT).show();
                   return;
               }
                if(password.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "enter password ", Toast.LENGTH_SHORT).show();
                    return;
                }
                auth.signInWithEmailAndPassword(userName.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            finish();
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "email or password is incorrect", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        loginAnonymously.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signInAnonymously().addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        Toast.makeText(LoginActivity.this, "Log in anonymously success", Toast.LENGTH_SHORT).show();
                        finish();}
                        else{
                            Toast.makeText(LoginActivity.this, "error please try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }


}