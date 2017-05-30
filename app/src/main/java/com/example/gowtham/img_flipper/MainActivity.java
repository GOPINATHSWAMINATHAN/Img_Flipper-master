package com.example.gowtham.img_flipper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2;
    Button bu1, bu2, startImg, stopImg, previousImg, nextImg;
    TextView tv1;
    int images[] = {R.drawable.apple, R.drawable.banana, R.drawable.chrries, R.drawable.greenapple, R.drawable.orange};
    String names[] = {"apple", "banana", "cherries", "greenapple", "orange"};

    String getName;
    HashMap<Integer, String> check = new HashMap();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewFlipper VF1 = (ViewFlipper) findViewById(R.id.viewflipper1);
        VF1.startFlipping();
        VF1.setFlipInterval(500);
        final int currentIndex = VF1.getDisplayedChild());
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        bu1 = (Button) findViewById(R.id.bu1);
        tv1 = (TextView) findViewById(R.id.tv1);
        startImg = (Button) findViewById(R.id.startImg);
        stopImg = (Button) findViewById(R.id.stopImg);
        nextImg = (Button) findViewById(R.id.nextImg);
        check.put(0, names[0]);
        check.put(1, names[1]);
        check.put(2, names[2]);
        check.put(3, names[3]);
        check.put(4, names[4]);

        getName = check.get(currentIndex);

        previousImg = (Button) findViewById(R.id.previousImg);
        startImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                VF1.startFlipping();
            }
        });
        stopImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                VF1.stopFlipping();

            }
        });
        previousImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                VF1.showPrevious();
            }
        });
        nextImg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                VF1.showNext();
            }
        });
        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fruitName = ed1.getText().toString();
                for (int i = 0; i < names.length; i++) {
                    if (fruitName.equals(getName)) {
                        Toast.makeText(getApplicationContext(), "Correct!! good"+currentIndex, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong!"+currentIndex, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}
