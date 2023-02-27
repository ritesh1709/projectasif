package com.example.gymmangement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class HomeFragment extends AppCompatActivity implements View.OnClickListener {

    public CardView card1 , card2, card3, card4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        card1= (CardView) findViewById(R.id.c1);
        card2= (CardView) findViewById(R.id.c2);
        card3= (CardView) findViewById(R.id.c3);
        card4= (CardView) findViewById(R.id.c4);

        card1.setOnClickListener(this);
        card2.setOnClickListener(this);
        card3.setOnClickListener(this);
        card4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()){
            case R.id.c1:
                intent = new Intent(this,One.class);
                startActivity(intent);
                break;

            case R.id.c2:
                intent= new Intent(this, two.class);
                startActivity(intent);
                break;

            case R.id.c3:
                intent= new Intent(this, Three.class);
                startActivity(intent);
                break;

            case R.id.c4:
                intent= new Intent(this, Four.class);
                startActivity(intent);
                break;
        }

    }
}