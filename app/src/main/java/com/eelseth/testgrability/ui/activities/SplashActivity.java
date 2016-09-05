package com.eelseth.testgrability.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.eelseth.testgrability.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.res.AnimationRes;


@EActivity(R.layout.activity_splash)

public class SplashActivity extends AppCompatActivity {

    @ViewById
    ImageView ivLogo;

    @AnimationRes
    Animation bounce;

    @AfterViews
    void init() {
        animateLogo();
    }

    private void animateLogo(){
        bounce.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                goHome();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        ivLogo.startAnimation(bounce);
    }

    private void goHome(){
        Intent intent = new Intent(this, HomeActivity_.class);
        startActivity(intent);
        finish();
    }
}
