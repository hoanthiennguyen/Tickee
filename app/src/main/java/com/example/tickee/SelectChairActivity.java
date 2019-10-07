package com.example.tickee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SelectChairActivity extends AppCompatActivity {
    int numberOfSelected;
    int numberOfNeedToChoose = 2;
    TextView txtTimeRemaining;
    Button btnContinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_chair);
        btnContinue = findViewById(R.id.btnContinue);
        txtTimeRemaining = findViewById(R.id.txtTimeRemaining);
        new CountDownTimer(5*60*1000, 1000) {

            public void onTick(long millisUntilFinished) {
                txtTimeRemaining.setText(convertSecondToTime(millisUntilFinished));
            }

            public void onFinish() {
                finish();
            }
        }.start();
    }

    private String convertSecondToTime(long remainMiliSecond){
        int remainSecond =(int) remainMiliSecond/1000;
        int minute = remainSecond/60;
        int second = remainSecond%60;
        String strSecond = second < 10 ? "0" + second : "" + second;
        return minute +":" + strSecond;
    }
    public void onClickExit(View view){
        new AlertDialog.Builder(this)
                .setMessage("Bạn chắc chắn muốn hủy giao dịch và trở về trang chủ?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(SelectChairActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton("Không", null)
                .show();
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
                btnContinue.setBackgroundColor(getResources().getColor(R.color.green));
            }

        }

    }
    public void onClickContinue(View view){
        Intent intent = new Intent(this, MakePaymentActivity.class);
        startActivity(intent);
    }

}
