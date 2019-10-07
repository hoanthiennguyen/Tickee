package com.example.tickee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SuccessTransactionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_transaction);
    }
    public void onClickBackToHome(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
