package com.anwesome.games.gameobjects;

/**
 * Created by anweshmishra on 09/01/17.
 */
public class Screen {
    private float x,y;
    public Screen(float x,float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public int hashCode() {
        return (int)x+(int)y;
    }
}
