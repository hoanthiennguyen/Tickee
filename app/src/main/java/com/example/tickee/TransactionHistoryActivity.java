package com.example.tickee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TransactionHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bought_ticket);
    }
    public void onClickTransactionDetails(View view){
        Intent intent = new Intent(this, TransactionDetailsActivity.class);
        startActivity(intent);
    }
}
