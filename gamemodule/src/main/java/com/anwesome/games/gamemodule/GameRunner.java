package com.anwesome.games.gamemodule;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import com.anwesome.games.gameobjects.RollingBall;
import com.anwesome.games.gameobjects.Screen;

/**
 * Created by anweshmishra on 09/01/17.
 */
public class GameRunner implements Runnable {
    private boolean isRunning = true;
    private Screen screen;
    private int w,midX,time = 0;
    private RollingBall rollingBall;
    private SurfaceHolder surfaceHolder;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public void run() {
        while(isRunning) {
            if(surfaceHolder.getSurface().isValid()) {
                Canvas canvas = surfaceHolder.lockCanvas();
                if(time == 0) {
                    initObjects(canvas.getWidth(),canvas.getHeight());
                }
                canvas.drawColor(Color.parseColor("#00E676"));
                canvas.save();
                canvas.translate(screen.getX(),screen.getY());
                rollingBall.draw(canvas,paint);
                rollingBall.move();
                if(rollingBall.crossesDistance(midX)) {
                    screen.setX(screen.getX()-w);
                    midX+=w;
                }
                canvas.restore();
                surfaceHolder.unlockCanvasAndPost(canvas);
                time++;
                try {
                    Thread.sleep(GameConstants.GAME_DELAY);
                }
                catch (Exception ex) {

                }
            }
        }
    }
    public void initObjects(int w,int h) {
        this.w = w;
        midX=w;
        screen = new Screen(0,0);
        rollingBall = RollingBall.newInstance(h/2);
    }
    public GameRunner(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }
    public void handleTouch(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN && rollingBall.containsTouch(event.getX()-screen.getX(),event.getY())) {
            rollingBall.toggleSpeed();
        }
    }
    public void pause() {
        if(isRunning) {
            isRunning = false;
        }
    }
    public void resume() {
        if(!isRunning) {
            isRunning = true;
        }
    }
}
