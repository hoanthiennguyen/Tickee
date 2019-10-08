package com.example.tickee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.tickee.filmschedule.FilmScheduleActivity;

public class MakePaymentActivity extends AppCompatActivity {
    TextView txtTimeRemaining;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_payment);
        txtTimeRemaining = findViewById(R.id.txtTimeRemaining);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.check(R.id.radioZalopPay);
        new CountDownTimer(3*60*1000, 1000) {

            public void onTick(long millisUntilFinished) {
                txtTimeRemaining.setText(convertSecondToTime(millisUntilFinished));
            }

            public void onFinish() {
                finish();
            }
        }.start();
    }
    public void onClickExit(View view){
        new AlertDialog.Builder(this)
                .setMessage("Bạn chắc chắn muốn hủy giao dịch?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MakePaymentActivity.this, FilmScheduleActivity.class);
                        startActivity(intent);
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton("Không", null)
                .show();
    }
    private String convertSecondToTime(long remainMiliSecond){
        int remainSecond =(int) remainMiliSecond/1000;
        int minute = remainSecond/60;
        int second = remainSecond%60;
        String strSecond = second < 10 ? "0" + second : "" + second;
        return minute +":" + strSecond;
    }
    public void onClickMakePayment(View view){
        Intent intent = new Intent(this, SuccessTransactionActivity.class);
        startActivity(intent);
    }
}
