package com.example.aina.e_catering;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button ButtonSignIn , ButtonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonSignIn = (Button)findViewById(R.id.buttonSignIn);
        ButtonSignUp = (Button)findViewById(R.id.buttonSignUp);

        ButtonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SignUp = new Intent(MainActivity.this, com.example.aina.e_catering.SignUp.class);
                startActivity(SignUp);
            }
        });

        ButtonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SignIn = new Intent(MainActivity.this, com.example.aina.e_catering.SignIn.class);
                startActivity(SignIn);
            }
        });
    }
}
