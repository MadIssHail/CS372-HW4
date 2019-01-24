package com.example.firstapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

/**
 * MainActivity created so that once the user presses the roll button, the ImageViews change to emulate rolling dice
 * I found this very difficult, and I tried really hard to implement the threads, but the app kept crashing when I pressed
 * the roll button. So, I settled on creating a more basic version that does not have threads and only rolls once.  In the
 * future I would like to amp up this project; I just have had a hard time with the Android Studio learning curve/syntax.
 * @author Madi Binyon
 * @version 1.23.19
 */
public class MainActivity extends AppCompatActivity {

    public static final Random RANDOM = new Random();
    private Button button;
    private ImageView die1, die2, die3, die4, die5;
    /**
     * When the app is emulated and the dice ImageViews are created and set on the screen
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        die1 = (ImageView) findViewById(R.id.ImageView1);
        die2 = (ImageView) findViewById(R.id.ImageView2);
        die3 = (ImageView) findViewById(R.id.ImageView3);
        die4 = (ImageView) findViewById(R.id.ImageView4);
        die5 = (ImageView) findViewById(R.id.ImageView5);

        /**
         * When the button is pressed, five random numbers are accessed and set to new resources.
         * The resources can then be set on the ImageViews so the user can see the dice change.
         * I had a hard time with the resource syntax but eventually found a good example online to go off of
         */
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 50; i++) {
                int int1 = randomVal();
                int int2 = randomVal();
                int int3 = randomVal();
                int int4 = randomVal();
                int int5 = randomVal();

                int res1 = getResources().getIdentifier("die_face_" + int1 + "_t", "drawable", "com.example.firstapplication");
                int res2 = getResources().getIdentifier("die_face_" + int2 + "_t", "drawable", "com.example.firstapplication");
                int res3 = getResources().getIdentifier("die_face_" + int3 + "_t", "drawable", "com.example.firstapplication");
                int res4 = getResources().getIdentifier("die_face_" + int4 + "_t", "drawable", "com.example.firstapplication");
                int res5 = getResources().getIdentifier("die_face_" + int5 + "_t", "drawable", "com.example.firstapplication");

                die1.setImageResource(res1);
                die2.setImageResource(res2);
                die3.setImageResource(res3);
                die4.setImageResource(res4);
                die5.setImageResource(res5);
                }
            }
        });

    }

    /**
     *
     * @return A random number that will be used to change the ImageView resources to make it look like the dice are rolling
     */
    public static int randomVal() {
        return RANDOM.nextInt(6) + 1;
    }
}
