package com.example.a07_facing;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private static float rotateFrom = 0;
    private static float rotateTo = 45;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageview = (ImageView) findViewById(R.id.imageView);
        TextView textview = (TextView) findViewById(R.id.textView);


        ImageView imageViewThumb = (ImageView) findViewById(R.id.imageView);
        imageViewThumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rotate(imageViewThumb);
                textview.setText(rotateFrom + " Degrees");
            }
        });
    }

    private void rotate(ImageView caller){
        RotateAnimation r = new RotateAnimation(rotateFrom, rotateTo, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        r.setDuration((long) 2*500);
        r.setRepeatCount(0);
        r.setFillAfter(true);
        caller.startAnimation(r);
        rotateFrom = rotateTo;
        if (rotateTo != 360)
            rotateTo += 45;
        else
            rotateTo = 45;
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}