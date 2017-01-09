package com.anwesome.games.continueroller;

import android.content.pm.ActivityInfo;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.anwesome.games.gamemodule.GameView;

public class MainActivity extends AppCompatActivity {
    private GameView gameView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new GameView(this);
        setContentView(gameView);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }
    public void onPause() {
        super.onPause();
        gameView.pause();
    }
    public void onResume() {
        super.onResume();
        gameView.resume();
    }
}
