package com.anwesome.games.gamemodule;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by anweshmishra on 09/01/17.
 */
public class GameView extends SurfaceView{
    private SurfaceHolder surfaceHolder;
    private Thread gameThread;
    private GameRunner gameRunner;
    public GameView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        gameRunner = new GameRunner(surfaceHolder);
        gameThread = new Thread(gameRunner);
        gameThread.start();
    }
    public void pause() {
        gameRunner.pause();
        while (true) {
            try {
                gameThread.join();
                break;
            }
            catch (Exception ex) {

            }
        }
    }
    public void resume() {
        gameRunner.resume();
        gameThread = new Thread(gameRunner);
        gameThread.start();
    }
    public boolean onTouchEvent(MotionEvent event) {
        gameRunner.handleTouch(event);
        return true;
    }
}
