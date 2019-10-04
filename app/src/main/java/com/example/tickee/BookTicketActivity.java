package com.example.tickee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BookTicketActivity extends AppCompatActivity {
    ImageButton addNormal;
    ImageButton addVip;
    ImageButton addCouple;
    ImageButton removeNormal;
    ImageButton removeVip;
    ImageButton removeCouple;
    TextView ticketNor;
    TextView ticketVip;
    TextView ticketCoup;
    Button btnContinue;
    int priceNormal = 80;
    int priceVip = 85;
    int priceCouple = 180;
    int totalNor = 0;
    int totalVip = 0;
    int totalCoup = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ticket);

        btnContinue = findViewById(R.id.btnContinue);
        //Ticket Normal
        ticketNor = (TextView) findViewById(R.id.txtTicketNormal);
        addNormal = (ImageButton) findViewById(R.id.buttonAddNormal);
        addNormal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                removeNormal.setImageDrawable(getDrawable(R.drawable.ic_remove_black_24dp));
                removeNormal.setEnabled(true);
                int current =  Integer.parseInt(ticketNor.getText().toString());
                if(current < 10){
                    current = current + 1;
                    ticketNor.setText(String.valueOf(current));
                    TextView priceTotal = (TextView) findViewById(R.id.priceTotal);
                    priceTotal.setText(totalMoney());
                }
                if(current == 10){
                    addNormal.setEnabled(false);
                    addNormal.setImageDrawable(getDrawable(R.drawable.ic_add_circle_diable_24dp));
                }
            }
        });

        //Remove Normal
        removeNormal = (ImageButton) findViewById(R.id.buttonRemoveNormal);
        removeNormal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addNormal.setEnabled(true);
                int current =  Integer.parseInt(ticketNor.getText().toString());
                if(current != 0){
                    addNormal.setImageDrawable(getDrawable(R.drawable.ic_add_circle_black_24dp));
                    current = current - 1;
                    ticketNor.setText(String.valueOf(current));
                }if(current == 0) {
                    removeNormal.setImageDrawable(getDrawable(R.drawable.ic_remove_transparent_24dp));
                    removeNormal.setEnabled(false);
                }
                TextView priceTotal = (TextView) findViewById(R.id.priceTotal);
                priceTotal.setText(totalMoney());
            }
        });


        //Ticket Vip
        ticketVip = (TextView) findViewById(R.id.txtTicketVip);
        addVip = (ImageButton) findViewById(R.id.buttonAddVip);
        addVip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                removeVip.setEnabled(true);
                removeVip.setImageDrawable(getDrawable(R.drawable.ic_remove_black_24dp));
                int current =  Integer.parseInt(ticketVip.getText().toString());
                if(current < 10){
                    current = current + 1;
                    ticketVip.setText(String.valueOf(current));
                    TextView priceTotal = (TextView) findViewById(R.id.priceTotal);
                    priceTotal.setText(totalMoney());
                }
                if(current == 10){
                    addVip.setEnabled(false);
                    addVip.setImageDrawable(getDrawable(R.drawable.ic_add_circle_diable_24dp));
                }
            }
        });


        //Remove Vip
        removeVip = (ImageButton) findViewById(R.id.buttonRemoveVip);
        removeVip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addVip.setEnabled(true);
                int current =  Integer.parseInt(ticketVip.getText().toString());
                if(current != 0){
                    addVip.setImageDrawable(getDrawable(R.drawable.ic_add_circle_black_24dp));
                    current = current - 1;
                    ticketVip.setText(String.valueOf(current));
                }if(current == 0){
                    ImageButton btnRemoveVip = (ImageButton) findViewById(R.id.buttonRemoveVip);
                    btnRemoveVip.setImageDrawable(getDrawable(R.drawable.ic_remove_transparent_24dp));
                    removeVip.setEnabled(false);
                }
                TextView priceTotal = (TextView) findViewById(R.id.priceTotal);
                priceTotal.setText(totalMoney());
            }
        });

        //Ticket Couple
        ticketCoup = (TextView) findViewById(R.id.txtTicketCouple);
        addCouple = (ImageButton) findViewById(R.id.buttonAddCouple);
        addCouple.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                removeCouple.setImageDrawable(getDrawable(R.drawable.ic_remove_black_24dp));
                removeCouple.setEnabled(true);
                int current =  Integer.parseInt(ticketCoup.getText().toString());
                if(current < 10){
                    current = current + 1;
                    ticketCoup.setText(String.valueOf(current));
                    TextView priceTotal = (TextView) findViewById(R.id.priceTotal);
                    priceTotal.setText(totalMoney());
                }
                if(current == 10){
                    addCouple.setEnabled(false);
                    addCouple.setImageDrawable(getDrawable(R.drawable.ic_add_circle_diable_24dp));
                }
            }
        });


        //Remove Couple
        removeCouple = (ImageButton) findViewById(R.id.buttonRemoveCouple);
        removeCouple.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addCouple.setEnabled(true);
                int current =  Integer.parseInt(ticketCoup.getText().toString());
                if(current != 0){
                    addCouple.setImageDrawable(getDrawable(R.drawable.ic_add_circle_black_24dp));
                    current = current - 1;
                    ticketCoup.setText(String.valueOf(current));
                }if(current == 0){
                    ImageButton btnRemoveCoup = (ImageButton) findViewById(R.id.buttonRemoveCouple);
                    btnRemoveCoup.setImageDrawable(getDrawable(R.drawable.ic_remove_transparent_24dp));
                    removeCouple.setEnabled(false);
                }
                TextView priceTotal = (TextView) findViewById(R.id.priceTotal);
                priceTotal.setText(totalMoney());
            }
        });
    }


    public String totalMoney(){
        LinearLayout continueLayout = (LinearLayout) findViewById(R.id.continueLayout);
        ticketNor = findViewById(R.id.txtTicketNormal);
        ticketVip = findViewById(R.id.txtTicketVip);
        ticketCoup = findViewById(R.id.txtTicketCouple);
        totalNor = Integer.parseInt(ticketNor.getText().toString()) * priceNormal;
        totalVip = Integer.parseInt(ticketVip.getText().toString()) * priceVip;
        totalCoup = Integer.parseInt(ticketCoup.getText().toString()) * priceCouple;
        int sum = totalCoup + totalNor + totalVip;
        String total = sum + ".000 đ";
        if (total.length() == 10){
            String arr[] = total.split("");
            total = arr[1] + "." + arr[2]+ arr[3]+ arr[4] + ".000 đ";
        }
        if(total.equals("0.000 đ")){
            continueLayout.setBackground(getDrawable(R.color.gray));
            btnContinue.setEnabled(false);
        }else{
            continueLayout.setBackground(getDrawable(R.color.green));
            btnContinue.setEnabled(true);
        }
        return total;
    }
    public void onClickContinue(View view){
        Intent intent = new Intent(this,SelectChairActivity.class);
        startActivity(intent);
    }
    public void onClickExit(View view){
        finish();
    }

}
