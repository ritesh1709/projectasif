package com.example.gymmangement;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HomeFragment extends Fragment {
    Activity myactivity;
    View view;
    public CardView card1, card2, card3, card4;

    @Override
    public void onStart() {
        super.onStart();
        card2 = (CardView) card2.findViewById(R.id.c2);
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(myactivity, two.class);
                startActivity(intent2);
            }
        });
        card3 = (CardView) card3.findViewById(R.id.c3);
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(myactivity, Three.class);
                startActivity(intent3);
            }
        });
        card4 = (CardView) card4.findViewById(R.id.c4);
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(myactivity, Four.class);
                startActivity(intent4);
            }
        });
        card1 = (CardView) card1.findViewById(R.id.c1);
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(myactivity, One.class);
                startActivity(intent);

            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myactivity=getActivity();
        view= inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }
}


