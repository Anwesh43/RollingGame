package com.anwesome.games.gameobjects;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

/**
 * Created by anweshmishra on 09/01/17.
 */
public class RollingBall {
    private static float RADIUS_OF_BALL = 100;
    private float rolling_deg = 0,speed=0;
    private float x,y;
    private RollingBall(float x,float y) {
        this.x = x;
        this.y = y;
    }
    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.translate(x,y);
        canvas.rotate(rolling_deg);
        paint.setColor(Color.parseColor("#f44336"));
        canvas.drawArc(new RectF(-RADIUS_OF_BALL,-RADIUS_OF_BALL,RADIUS_OF_BALL,RADIUS_OF_BALL),0,180,true,paint);
        paint.setColor(Color.parseColor("#FAFAFA"));
        canvas.drawArc(new RectF(-RADIUS_OF_BALL,-RADIUS_OF_BALL,RADIUS_OF_BALL,RADIUS_OF_BALL),180,180,true,paint);
        canvas.restore();
    }
    public void move() {
        rolling_deg+=speed*2;
        x+=speed;
    }
    public void toggleSpeed() {
        speed = speed == 0?10:0;
    }
    public boolean containsTouch(float x,float y) {
        return x>=this.x-RADIUS_OF_BALL && x<=this.x+RADIUS_OF_BALL && y>=this.y-RADIUS_OF_BALL && y<=this.y+RADIUS_OF_BALL;
    }
    public boolean crossesDistance(float x) {
        return this.x>=x;
    }
    public static RollingBall newInstance(float y) {
        return new RollingBall(RADIUS_OF_BALL,y);
    }
}
