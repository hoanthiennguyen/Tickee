package com.example.tickee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BookTicketActivity extends AppCompatActivity {
    TextView ticketNor;
    TextView ticketVip;
    TextView ticketCoup;
    int priceNormal = 80;
    int priceVip = 85;
    int priceCouple = 180;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_ticket);
    }

    public void onClickAddNormal(View view) {
        ticketNor = findViewById(R.id.txtTicketNormal);
        int current = Integer.parseInt(ticketNor.getText().toString());
        int amount = current++;
        ticketNor.setText(amount);
        TextView priceTotal = findViewById(R.id.priceTotal);
        priceTotal.setText(totalMoney());
    }

    public void onClickAddVip(View view) {
        ticketVip = findViewById(R.id.txtTicketVip);
        int current = Integer.parseInt(ticketVip.getText().toString());
        int amount = current++;
        ticketVip.setText(amount);
        TextView priceTotal = findViewById(R.id.priceTotal);
        priceTotal.setText(totalMoney());
    }

    public void onClickAddCouple(View view) {
        ticketCoup = findViewById(R.id.txtTicketCouple);
        int current = Integer.parseInt(ticketCoup.getText().toString());
        int amount = current++;
        ticketCoup.setText(amount);
        TextView priceTotal = findViewById(R.id.priceTotal);
        priceTotal.setText(totalMoney());
    }

    public void onClickRemoveNormal(View view) {
        ticketNor = findViewById(R.id.txtTicketNormal);
        int current = Integer.parseInt(ticketNor.getText().toString());
        if(current == 0){
            ticketNor.setText(current);
        }
        int amount = current - 1;
        ticketNor.setText(amount);
        TextView priceTotal = findViewById(R.id.priceTotal);
        priceTotal.setText(totalMoney());
    }

    public void onClickRemoveVip(View view) {
        ticketVip = findViewById(R.id.txtTicketVip);
        int current = Integer.parseInt(ticketVip.getText().toString());
        if(current == 0){
            ticketVip.setText(current);
        }
        int amount = current - 1;
        ticketVip.setText(amount);
        TextView priceTotal = findViewById(R.id.priceTotal);
        priceTotal.setText(totalMoney());
    }

    public void onClickRemoveCouple(View view) {
        ticketCoup = findViewById(R.id.txtTicketCouple);
        int current = Integer.parseInt(ticketCoup.getText().toString());
        if(current == 0){
            ticketCoup.setText(current);
        }
        int amount = current - 1;
        ticketCoup.setText(amount);
        TextView priceTotal = findViewById(R.id.priceTotal);
        priceTotal.setText(totalMoney());
    }


    public String totalMoney(){
        ticketNor = findViewById(R.id.txtTicketNormal);
        ticketVip = findViewById(R.id.txtTicketVip);
        ticketCoup = findViewById(R.id.txtTicketCouple);
        int totalNor = Integer.parseInt(ticketNor.getText().toString()) * priceNormal;
        int totalVip = Integer.parseInt(ticketVip.getText().toString()) * priceVip;
        int totalCoup = Integer.parseInt(ticketCoup.getText().toString()) * priceCouple;
        int sum = totalCoup + totalNor + totalVip;
        String total = sum + ".000";
        return total;
    }
}
