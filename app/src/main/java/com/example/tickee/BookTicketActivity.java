package com.example.tickee;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class BookTicketActivity extends AppCompatActivity {
    ImageButton btnImg;
    Button continueBtn;
    TextView ticketNor;
    TextView ticketVip;
    TextView ticketCoup;
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
        //Ticket Normal
        ticketNor = (TextView) findViewById(R.id.txtTicketNormal);
        btnImg = (ImageButton) findViewById(R.id.buttonAddNormal);
        btnImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ImageButton btnRemoveNormal = (ImageButton) findViewById(R.id.buttonRemoveNormal);
                btnRemoveNormal.setImageDrawable(getDrawable(R.drawable.ic_remove_black_24dp));
                int current =  Integer.parseInt(ticketNor.getText().toString());
                if(current < 10){
                    current = current + 1;
                    ticketNor.setText(String.valueOf(current));
                    TextView priceTotal = (TextView) findViewById(R.id.priceTotal);
                    priceTotal.setText(totalMoney());
                }else{
                    btnImg.setEnabled(false);
                    btnRemoveNormal.setEnabled(true);
                }
            }
        });
        btnImg = (ImageButton) findViewById(R.id.buttonRemoveNormal);
        btnImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ImageButton btnAddNormal = (ImageButton) findViewById(R.id.buttonAddNormal);
                btnAddNormal.setEnabled(true);
                int current =  Integer.parseInt(ticketNor.getText().toString());
                if(current != 0){
                    current = current - 1;
                    ticketNor.setText(String.valueOf(current));
                }else{
                    ImageButton btnRemoveNormal = (ImageButton) findViewById(R.id.buttonRemoveNormal);
                    btnRemoveNormal.setImageDrawable(getDrawable(R.drawable.ic_remove_transparent_24dp));
                    btnImg.setEnabled(false);
                }
                TextView priceTotal = (TextView) findViewById(R.id.priceTotal);
                priceTotal.setText(totalMoney());
            }
        });


        //Ticket Vip
        ticketVip = (TextView) findViewById(R.id.txtTicketVip);
        btnImg = (ImageButton) findViewById(R.id.buttonAddVip);
        btnImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ImageButton btnRemoveVip = (ImageButton) findViewById(R.id.buttonRemoveVip);
                btnRemoveVip.setImageDrawable(getDrawable(R.drawable.ic_remove_black_24dp));
                int current =  Integer.parseInt(ticketVip.getText().toString());
                if(current < 10){
                    current = current + 1;
                    ticketVip.setText(String.valueOf(current));
                    TextView priceTotal = (TextView) findViewById(R.id.priceTotal);
                    priceTotal.setText(totalMoney());
                }else{
                    btnImg.setEnabled(false);
                    btnRemoveVip.setEnabled(true);

                }
            }
        });
        btnImg = (ImageButton) findViewById(R.id.buttonRemoveVip);
        btnImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ImageButton btnAddVip = (ImageButton) findViewById(R.id.buttonAddVip);
                btnAddVip.setEnabled(true);
                int current =  Integer.parseInt(ticketVip.getText().toString());
                if(current != 0){
                    current = current - 1;
                    ticketVip.setText(String.valueOf(current));
                }else{
                    ImageButton btnRemoveVip = (ImageButton) findViewById(R.id.buttonRemoveVip);
                    btnRemoveVip.setImageDrawable(getDrawable(R.drawable.ic_remove_transparent_24dp));
                    btnImg.setEnabled(false);
                }
                TextView priceTotal = (TextView) findViewById(R.id.priceTotal);
                priceTotal.setText(totalMoney());
            }
        });

        //Ticket Couple
        ticketCoup = (TextView) findViewById(R.id.txtTicketCouple);
        btnImg = (ImageButton) findViewById(R.id.buttonAddCouple);
        btnImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ImageButton btnRemoveCouple = (ImageButton) findViewById(R.id.buttonRemoveCouple);
                btnRemoveCouple.setImageDrawable(getDrawable(R.drawable.ic_remove_black_24dp));
                btnRemoveCouple.setEnabled(true);
                int current =  Integer.parseInt(ticketCoup.getText().toString());
                if(current < 10){
                    current = current + 1;
                    ticketCoup.setText(String.valueOf(current));
                    TextView priceTotal = (TextView) findViewById(R.id.priceTotal);
                    priceTotal.setText(totalMoney());
                }else{
                    btnImg.setEnabled(false);
                    btnRemoveCouple.setEnabled(true);
                }
            }
        });
        btnImg = (ImageButton) findViewById(R.id.buttonRemoveCouple);
        btnImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ImageButton btnAddCoup = (ImageButton) findViewById(R.id.buttonAddCouple);
                btnAddCoup.setEnabled(true);
                int current =  Integer.parseInt(ticketCoup.getText().toString());
                if(current != 0){
                    current = current - 1;
                    ticketCoup.setText(String.valueOf(current));
                }else{
                    ImageButton btnRemoveCoup = (ImageButton) findViewById(R.id.buttonRemoveCouple);
                    btnRemoveCoup.setImageDrawable(getDrawable(R.drawable.ic_remove_transparent_24dp));
                    btnImg.setEnabled(false);
                }
                TextView priceTotal = (TextView) findViewById(R.id.priceTotal);
                priceTotal.setText(totalMoney());
            }
        });
    }



    public String totalMoney(){
        ticketNor = findViewById(R.id.txtTicketNormal);
        ticketVip = findViewById(R.id.txtTicketVip);
        ticketCoup = findViewById(R.id.txtTicketCouple);
        totalNor = Integer.parseInt(ticketNor.getText().toString()) * priceNormal;
        totalVip = Integer.parseInt(ticketVip.getText().toString()) * priceVip;
        totalCoup = Integer.parseInt(ticketCoup.getText().toString()) * priceCouple;
        int sum = totalCoup + totalNor + totalVip;
        String total = String.valueOf(sum) + ".000 đ";
        return total;
    }

}
