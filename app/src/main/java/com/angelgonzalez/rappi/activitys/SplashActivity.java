package com.angelgonzalez.rappi.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.angelgonzalez.rappi.R;
import com.angelgonzalez.rappi.fragments.IntroFragment;
import com.angelgonzalez.rappi.util.Util;
import com.github.paolorotolo.appintro.AppIntro2;

/**
 * Created by angel.gonzalez on 11/11/2015.
 */
public class SplashActivity extends AppIntro2 {

    @Override
    public void init(Bundle savedInstanceState) {
        Util.setRequestedOrientation(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        addSlide(IntroFragment.newInstance(R.layout.activity_splash));
        addSlide(IntroFragment.newInstance(R.layout.activity_splash_two));
        /*setZoomAnimation();
        setFlowAnimation();
        setSlideOverAnimation();*/
        setDepthAnimation();

    }

    private void loadMainActivity(){
        Intent intent = new Intent(this, MainActivityNavigator.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onDonePressed() {
        loadMainActivity();
    }

    public void getStarted(View v){
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();

        loadMainActivity();

    }


}
