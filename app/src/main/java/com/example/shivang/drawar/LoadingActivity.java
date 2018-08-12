package com.example.shivang.drawar;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.github.jorgecastillo.FillableLoader;
import com.github.jorgecastillo.FillableLoaderBuilder;
import com.github.jorgecastillo.State;
import com.github.jorgecastillo.clippingtransforms.WavesClippingTransform;
import com.github.jorgecastillo.listener.OnStateChangeListener;

public class LoadingActivity extends AppCompatActivity implements OnStateChangeListener {

    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loading);
        getSupportActionBar().hide();
        rootView = findViewById(R.id.rootView);
        int viewSize = getResources().getDimensionPixelSize(R.dimen.fourthSampleViewSize);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(viewSize, viewSize);
        params.gravity = Gravity.CENTER;

        FillableLoaderBuilder loaderBuilder = new FillableLoaderBuilder();
        final FillableLoader fillableLoader = loaderBuilder.parentView((FrameLayout) rootView)
                .svgPath(getString(R.string.svgPath))
                .layoutParams(params)
                .originalDimensions(220, 275)
                .strokeColor(Color.parseColor("#ffffff"))
                .fillColor(Color.parseColor("#00B551"))
                .strokeDrawingDuration(2000)
                .clippingTransform(new WavesClippingTransform())
                .fillDuration(5000)
                .build();
        fillableLoader.setOnStateChangeListener(this);
        fillableLoader.postDelayed(new Runnable() {
            @Override public void run() {
                fillableLoader.start();
            }
        }, 250);
    }

    @Override
    public void onStateChange(int state) {
        if(state== State.FINISHED) {
            Intent i = new Intent(getApplicationContext(),DrawAR.class);
            startActivity(i);
        }
    }
}
