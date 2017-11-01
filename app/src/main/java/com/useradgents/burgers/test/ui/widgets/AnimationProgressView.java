package com.useradgents.burgers.test.ui.widgets;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.arellomobile.mvp.sample.github.R;

public class AnimationProgressView extends ImageView {

    private final AnimationDrawable frameAnimation;

    public AnimationProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundResource(R.drawable.spin_animation);
        frameAnimation = (AnimationDrawable) getBackground();
        frameAnimation.start();
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        if (visibility == VISIBLE) {
            frameAnimation.start();
        } else {
            frameAnimation.stop();
        }
    }
}