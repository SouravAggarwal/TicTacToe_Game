package com.souravv.demo4connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//0=yellow,circle    ;   1=cross,red
    int activePlayer =0;
    boolean isover;
    int pos[]={2,2,2,2,2,2,2,2,2};
    int winingposition[][]={{0,1,2},{3,4,5,},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

public void dropin(View view) {
    ImageView counter = (ImageView) view;
    int tappedCounter = Integer.parseInt(counter.getTag().toString());

    if (pos[tappedCounter] == 2) {

        pos[tappedCounter] = activePlayer;
        counter.setTranslationY(-1000f);

        if (activePlayer == 0) {
            counter.setImageResource(R.drawable.button1);
            activePlayer = 1;
        } else {
            counter.setImageResource(R.drawable.button2);
            activePlayer = 0;
        }

        counter.animate().translationYBy(1000f).setDuration(500);

        for (int[] win : winingposition) {
            if (pos[win[0]] == pos[win[1]] && pos[win[1]] == pos[win[2]] && pos[win[1]] != 2) {
                //Someone has won...
                System.out.println("Won" + pos[win[0]]);

                LinearLayout linearlay = (LinearLayout) findViewById(R.id.linearlay);
                linearlay.setVisibility(View.VISIBLE);
                TextView message = (TextView) findViewById(R.id.textView);
                message.setText("Player " + (pos[win[0]] + 1) + "has won");

            }

       else {
                boolean isover = true;
                for (int countstate : pos) {
                    if (countstate == 2) isover = false;
                }

            if(isover){
                LinearLayout linearlay = (LinearLayout) findViewById(R.id.linearlay);
                linearlay.setVisibility(View.VISIBLE);
                TextView message = (TextView) findViewById(R.id.textView);
                message.setText("Its a draw!!");

            }


            }


        }
    }





}


public void playagain(View view){
    LinearLayout linearlay= (LinearLayout) findViewById(R.id.linearlay);
    linearlay.setVisibility(View.INVISIBLE);
    activePlayer=0;
//int pos[]=0
    for(int i=0 ; i<pos.length;i++)
    {
        pos[i]=2;
    }
    //removing imagesof counter
    GridLayout gridLayout= (GridLayout) findViewById(R.id.gridlay);
    for( int i=0; i<gridLayout.getChildCount();i++)
    {
        ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
    }


}




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
