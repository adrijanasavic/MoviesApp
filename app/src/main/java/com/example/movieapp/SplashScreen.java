package com.example.movieapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.movieapp.UI.MainActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends Activity {

    public static final int SPLASH_TIMEOUT = 2000;
    // private final int SPLASH_DISPLAY_LENGTH = 1000;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

        setContentView( R.layout.splash_screen );
        imageView = findViewById( R.id.imageSplash );
        InputStream is;
        try {
            is = getAssets().open( "android_pink.jpg" );
            Drawable drawable = Drawable.createFromStream( is, null );
            imageView.setImageDrawable( drawable );
        } catch (IOException e) {
            e.printStackTrace();
        }

        new Timer().schedule( new TimerTask() {
            @Override
            public void run() {
                startActivity( new Intent( SplashScreen.this, MainActivity.class ) );
                finish();
            }
        }, SPLASH_TIMEOUT );
    }
//, SPLASH_DISPLAY_LENGTH
}
