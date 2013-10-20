package com.example.HomeTask2;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.example.HomeTask2.R;

/**
 * Created with IntelliJ IDEA.
 * User: sergey
 * Date: 10/20/13
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Animations {
    Context context;

    public Animations(Context context) {
        this.context = context;
    }

    public Animation getFadeInAnim() {
        return AnimationUtils.loadAnimation(context, R.anim.fade_in);
    }

    public Animation getBlibkAnim() {
        return AnimationUtils.loadAnimation(context, R.anim.blink);
    }

    public Animation getMoveAnim() {
        return AnimationUtils.loadAnimation(context, R.anim.move);
    }

    public Animation getRotateAnim() {
        return AnimationUtils.loadAnimation(context, R.anim.rotate);
    }

    public Animation getSequentialAnim() {
        return AnimationUtils.loadAnimation(context, R.anim.sequential);
    }

    public Animation getSlideAnim() {
        return AnimationUtils.loadAnimation(context, R.anim.slide_down);
    }
}
