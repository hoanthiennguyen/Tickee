package com.example.tickee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tickee.filmschedule.FilmScheduleActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectChairActivity extends AppCompatActivity {
    int numberOfSelected;
    int numberOfNeedToChoose = 2;
    TextView txtTimeRemaining;
    Button btnContinue;
    GridView gridView;
    private List<Integer> chairs;
    private int[] statusOfChair =new int[32];
    private ArrayList<Integer> selectedChairs = new ArrayList<>();
    GridViewAdapter gridViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_chair);
        btnContinue = findViewById(R.id.btnContinue);
        txtTimeRemaining = findViewById(R.id.txtTimeRemaining);
        gridView = findViewById(R.id.chairs);
        chairs = Arrays.asList(new Integer[]{0,0,0,0,0,0,0,0,-1,-1,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0});
        gridViewAdapter = new GridViewAdapter(this,chairs);
        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(chairs.get(position) != -1){
                    if(selectedChairs.contains(position)){
                        if(chairs.get(position) == 0)
                            view.setBackgroundResource(R.drawable.roundbuttonwhite);
                        else
                            view.setBackgroundResource(R.drawable.roundbackgroundyellow);
                        selectedChairs.remove(new Integer(position));
                    }
                    else{
                        view.setBackgroundResource(R.drawable.roundbuttongreen);
                        selectedChairs.add(position);
                    }
                    setTextSelectedChair();

                }

            }
        });
        new CountDownTimer(5*60*1000, 1000) {

            public void onTick(long millisUntilFinished) {
                txtTimeRemaining.setText(convertSecondToTime(millisUntilFinished));
            }

            public void onFinish() {
                finish();
            }
        }.start();
    }
    private void setTextSelectedChair(){
        String normal = "" ,vip = "";
        int total = 0;
        for(Integer position: selectedChairs){
            if(chairs.get(position) ==0){
                normal += getTextPositionFromInt(position) +",";
                total += 80;
            }
            else{
                vip += getTextPositionFromInt(position) +",";
                total += 90;
            }
        }
        if(!normal.isEmpty())
            normal.substring(0,normal.length()-1);
        if(!vip.isEmpty())
            vip.substring(0,vip.length()-1);

        TextView txtNormal = findViewById(R.id.txtNormalSelected);
        TextView txtVip = findViewById(R.id.txtVipSelected);
        TextView txtTotal = findViewById(R.id.txtTotal);
        Button btnContinue = findViewById(R.id.btnContinue);
        if(total > 0 ){
            btnContinue.setBackgroundResource(R.color.green);
            btnContinue.setEnabled(true);
        }
        else {
            btnContinue.setBackgroundResource(R.color.gray);
            btnContinue.setEnabled(false);
        }

        txtTotal.setText(total+".000 đ");
        txtNormal.setText(normal);
        txtVip.setText(vip);
    }
    private String getTextPositionFromInt(int position){
        String[] characters = {"A","B","C","D"};
        return characters[position/8]+ (position%8+1);
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
                .setMessage("Bạn chắc chắn muốn hủy giao dịch?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(SelectChairActivity.this, FilmScheduleActivity.class);
                        startActivity(intent);
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton("Không", null)
                .show();
    }

    public void onClickContinue(View view){
        Intent intent = new Intent(this, MakePaymentActivity.class);
        startActivity(intent);
    }

}
