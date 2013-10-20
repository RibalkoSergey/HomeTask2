package com.example.HomeTask2.activities;


import android.app.Activity;

import android.os.Bundle;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.HomeTask2.Animations;
import com.example.HomeTask2.R;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: sergey
 * Date: 10/20/13
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class AnimationActivity extends Activity {
    TextView txtMessage;
    ImageView image;
    Button btnStart;
    Animations animations = new Animations(this);

    // Animation
    //Animation animFadein;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animation);

        txtMessage = (TextView) findViewById(R.id.textView1);
        image = (ImageView) findViewById(R.id.imageAnimation);
    }

    public void startAnimation(View v) {
        switch (v.getId()) {
            case R.id.btnBlink:
                txtMessage.setVisibility(View.VISIBLE);
                txtMessage.startAnimation(animations.getBlibkAnim());
                break;
            case R.id.btnFadeIn:
                txtMessage.setVisibility(View.VISIBLE);
                txtMessage.startAnimation(animations.getFadeInAnim());

                break;
            case R.id.btnMove:
                txtMessage.setVisibility(View.VISIBLE);
                txtMessage.startAnimation(animations.getMoveAnim());
                break;
            case R.id.btnRotate:
                image.startAnimation(animations.getRotateAnim());
                break;
            case R.id.btnSequential:
                image.startAnimation(animations.getSequentialAnim());
                break;
            case R.id.btnSlide:
                image.startAnimation(animations.getSlideAnim());
                break;
        }
    }

}
