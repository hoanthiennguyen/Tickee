package com.example.tickee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SelectChairActivity extends AppCompatActivity {
    int numberOfSelected;
    int numberOfNeedToChoose = 2;
    Button btnContinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_chair);
        btnContinue = findViewById(R.id.btnContinue);
    }
    public void onClickExit(View view){
        finish();
    }
    public void onClickChair(View view){

        if(view.isSelected()){
            view.setBackgroundResource(R.drawable.roundbuttongray);
            view.setSelected(false);
            numberOfSelected--;
            btnContinue.setEnabled(false);
            btnContinue.setBackgroundResource(android.R.drawable.btn_default);
        }
        else {
            if(numberOfSelected < numberOfNeedToChoose)
            {
                numberOfSelected++;
                view.setSelected(true);
                view.setBackgroundResource(R.drawable.roundbuttongreen);
            }
            else
                Toast.makeText(this, "Bạn đã chọn đủ " + numberOfNeedToChoose + " ghế" , Toast.LENGTH_SHORT).show();
            if(numberOfSelected == numberOfNeedToChoose){
                btnContinue.setEnabled(true);
                btnContinue.setBackgroundColor(getResources().getColor(R.color.BHD));
            }

        }

    }
    public void onClickContinue(View view){
        Intent intent = new Intent(this, MakePaymentActivity.class);
        startActivity(intent);
    }

}
