package com.example.android.myassistant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;




public class SignUpActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText confirmPassword;
    Button signUpBtn;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        username=findViewById(R.id.userName_editText);
        password=findViewById(R.id.password_editText);
        confirmPassword=findViewById(R.id.confirmPassword_editText);
        signUpBtn = findViewById(R.id.signUpButton);

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = username.getText().toString().trim();
                String Password = password.getText().toString().trim();
                String ConfirmPassword = confirmPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    Toast.makeText(SignUpActivity.this,"Enter email", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(Password)){
                    Toast.makeText(SignUpActivity.this,"Enter Password", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(ConfirmPassword)){
                    Toast.makeText(SignUpActivity.this,"Enter Password again", Toast.LENGTH_SHORT).show();
                }
                if (Password.length()<6){
                    Toast.makeText(SignUpActivity.this,"Password too short", Toast.LENGTH_SHORT).show();
                }
                if(Password.equals(confirmPassword)){

                    mAuth.createUserWithEmailAndPassword(email, Password)
                            .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull com.google.android.gms.tasks.Task<AuthResult> task) {

                                    if (task.isSuccessful()) {

                                        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                                        Toast.makeText(SignUpActivity.this,"SignUp Completed",Toast.LENGTH_SHORT );


                                    }
                                    else {

                                        Toast.makeText(SignUpActivity.this,"Authentication Failed",Toast.LENGTH_SHORT );

                                    }

                                }


                            });


                }
            }
        });

    }

    }

