package com.example.myxando;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WinActivity extends AppCompatActivity {

    private String result="";
    String draw="";
    TextView tv_disp;
    boolean player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        player = getIntent().getBooleanExtra("player",true);
        draw = getIntent().getStringExtra("draw");
        if(!draw.equals("")) {
            result = "MATCH DRAWN";
        }
        else {
            if (player)
                result = "Player O Wins";
            else result = "Player X Wins";
        }
        tv_disp = findViewById(R.id.disp_tv);
        tv_disp.setText(result);
    }

    public void new_game(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void quit_game(View view) {
        System.runFinalization();
        finish();
    }
}
