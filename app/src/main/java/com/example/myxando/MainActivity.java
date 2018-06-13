package com.example.myxando;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static boolean player;
    char[][] board;
    int size;
    TextView[] et;
    int count=0;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = true; //  x player(false) o player(true)
        size = 3;
        mContext = this;
        board = new char[size][size];
        et = new TextView[size*size];
        for(int i=0;i<size*size;i++) {
            Resources res = getResources();
            int id = res.getIdentifier("text"+i, "id", this.getPackageName());
            et[i] = findViewById(id);
        }
        for(int i=0;i<size;i++)
            for(int j=0;j<size;j++)
                board[i][j]=0;
    }

    @Override
    protected void onStart() {
        super.onStart();

        for (int i=0;i<size*size;i++) {
            final int x = i;
            et[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (player) {
                        et[x].setText("O");
                        board[x/size][x%size] = 'O';
                    }
                    else
                    {
                        et[x].setText("X");
                        board[x/size][x%size] = 'X';
                    }
                    count++;
                    checkPlayerWin();//checks whether a player wins or not
                    if(count==size*size)
                    {
                        Intent intent = new Intent(mContext,WinActivity.class);
                        intent.putExtra("draw","DRAW");
                        startActivity(intent);
                        finish();
                    }
//                    et[x].setClickable(false);
                    player = !player;
                }
            });
        }

//        for(int i=0;i<size*size;i++) {
//            final int x = i;
//            et[i].addTextChangedListener(new TextWatcher() {
//                @Override
//                public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
//
//                @Override
//                public void onTextChanged(CharSequence s, int start, int before, int count) { }
//
//                @Override
//                public void afterTextChanged(Editable s) {
//                    board[x/size][x%size] = Integer.parseInt(String.valueOf(et[x].getText()));
//                    Log.d("board["+x/size+"]["+x%size+"]",""+board[x/size][x%size]);
//
//                }
//            });
//        }
    }

    private void checkPlayerWin() {
        if (player) //  For O
            for(int i=0;i<size*size;i++)
            {
                int row = i/size;
                int col = i%size;
                if(board[row][col]=='O')
                {
                    if(row==0) {
                        if (board[row + 1][col] == 'O' && board[row + 2][col] == 'O') {
                            Intent intent = new Intent(this,WinActivity.class);
                            intent.putExtra("player",player);
                            startActivity(intent);
                            finish();
                        }
                        else if (col == 0)
                        {
                            if (board[row+1][col+1] == 'O' && board[row+2][col+2] == 'O'){
                                Intent intent = new Intent(this,WinActivity.class);
                                intent.putExtra("player",player);
                                startActivity(intent);
                                finish();
                            }
                        }
                        else if(col==2)
                        {
                            if (board[row+1][col-1] == 'O' && board[row+2][col-2] == 'O'){
                                Intent intent = new Intent(this,WinActivity.class);
                                intent.putExtra("player",player);
                                startActivity(intent);
                                finish();
                            }
                        }
                    }
                    else if (col == 0)
                    {
                        if (board[row][col + 1] == 'O' && board[row][col + 2] == 'O') {
                            Intent intent = new Intent(this,WinActivity.class);
                            intent.putExtra("player",player);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            }
        else
        {
            for(int i=0;i<size*size;i++)
            {
                int row = i/size;
                int col = i%size;
                if(board[row][col]=='X')
                {
                    if(row==0) {
                        if (board[row + 1][col] == 'X' && board[row + 2][col] == 'X') {
                            Intent intent = new Intent(this,WinActivity.class);
                            intent.putExtra("player",player);
                            startActivity(intent);
                            finish();
                        }
                        else if (col == 0)
                        {
                            if (board[row+1][col+1] == 'X' && board[row+2][col+2] == 'X'){
                                Intent intent = new Intent(this,WinActivity.class);
                                intent.putExtra("player",player);
                                startActivity(intent);
                                finish();
                            }
                        }
                        else if(col==2)
                        {
                            if (board[row+1][col-1] == 'X' && board[row+2][col-2] == 'X'){
                                Intent intent = new Intent(this,WinActivity.class);
                                intent.putExtra("player",player);
                                startActivity(intent);
                                finish();
                            }
                        }
                    }
                    else if (col == 0)
                    {
                        if (board[row][col + 1] == 'X' && board[row][col + 2] == 'X') {
                            Intent intent = new Intent(this,WinActivity.class);
                            intent.putExtra("player",player);
                            startActivity(intent);
                            finish();
                        }
                    }
                }
            }
        }
    }

}