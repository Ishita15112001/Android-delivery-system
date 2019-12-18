package com.example.foodiesarena;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ResRegActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9;
    Button button;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_reg);
        getSupportActionBar().setTitle("Registration Form");

        e1 = (EditText)findViewById(R.id.name);
        e2 = (EditText)findViewById(R.id.email);
        e3 = (EditText)findViewById(R.id.add);
        e4 = (EditText)findViewById(R.id.phn);
        e5 = (EditText)findViewById(R.id.des);
        e6 = (EditText)findViewById(R.id.radius);
        e7 = (EditText)findViewById(R.id.time);
        e8 = (EditText)findViewById(R.id.hours);
        e9 = (EditText)findViewById(R.id.password);
        button = (Button)findViewById(R.id.button);


        firebaseAuth = FirebaseAuth.getInstance();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = e1.getText().toString();
                String email = e2.getText().toString().trim();
                String address = e3.getText().toString();
                String phone = e4.getText().toString().trim();
                String description = e5.getText().toString();
                String radius = e6.getText().toString();
                String time = e7.getText().toString();
                String hours = e8.getText().toString();
                String password = e9.getText().toString();


                if(TextUtils.isEmpty(name)){
                    Toast.makeText(ResRegActivity.this, "Please Enter Name", Toast.LENGTH_SHORT);
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(ResRegActivity.this, "Please Enter Email", Toast.LENGTH_SHORT);
                    return;
                }

                if(TextUtils.isEmpty(address)){
                    Toast.makeText(ResRegActivity.this, "Please Enter Address", Toast.LENGTH_SHORT);
                    return;
                }

                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(ResRegActivity.this, "Please Enter Phone number", Toast.LENGTH_SHORT);
                    return;
                }

                if(TextUtils.isEmpty(description)){
                    Toast.makeText(ResRegActivity.this, "Please Enter description", Toast.LENGTH_LONG);
                    return;
                }

                if(TextUtils.isEmpty(radius)){
                    Toast.makeText(ResRegActivity.this, "Please Enter Restaurant radius", Toast.LENGTH_SHORT);
                    return;
                }

                if(TextUtils.isEmpty(time)){
                    Toast.makeText(ResRegActivity.this, "Please Enter delivery time", Toast.LENGTH_SHORT);
                    return;
                }

                if(TextUtils.isEmpty(hours)){
                    Toast.makeText(ResRegActivity.this, "Please Enter Restaurant hours", Toast.LENGTH_SHORT);
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(ResRegActivity.this, "Please Enter Password", Toast.LENGTH_SHORT);
                    return;
                }

                if(password.length()<6){
                    Toast.makeText(ResRegActivity.this, "Password too short", Toast.LENGTH_SHORT);
                    return;
                }



                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(ResRegActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                    Toast.makeText(ResRegActivity.this, "Registration Complete", Toast.LENGTH_SHORT);


                                } else {

                                    Toast.makeText(ResRegActivity.this, "Authentication Failed", Toast.LENGTH_SHORT);


                                }

                                // ...
                            }
                        });

            }
        });

    }
}
