package com.wz.lanyue.banke;


import android.support.annotation.Nullable;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro2;
import com.wz.lanyue.banke.Fragment.LoginYingDaoYe;
import com.wz.lanyue.banke.Fragment.Yindaoye0;

public class WBAuthActivity extends AppIntro2 {

    @Override
    public void init(@Nullable Bundle savedInstanceState) {

     addSlide(new Yindaoye0());
        addSlide(new LoginYingDaoYe());
        setProgressButtonEnabled(false);
        setZoomAnimation();
    }

    @Override
    public void onDonePressed() {

    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onSlideChanged() {

    }

   @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
