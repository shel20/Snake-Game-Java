package com.company;

import java.awt.Rectangle;

public class Puncte {
    private int x;
    private int y;

    public Puncte(Snake jucator) {
        this.random_spawn(jucator);
    }

    public void random_spawn(Snake jucator) {
        boolean onSnake = true;
        while(onSnake) {
            onSnake = false;

            x = (int)(Math.random() * Joc.latime - 1);
            y = (int)(Math.random() * Joc.inaltime - 1);

            for(Rectangle r : jucator.getcorp()){
                if(r.x == x && r.y == y) {
                    onSnake = true;
                }
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}