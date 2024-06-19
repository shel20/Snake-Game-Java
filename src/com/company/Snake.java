package com.company;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Rectangle> corp;
    private int w = Joc.latime;
    private int h = Joc.inaltime;
    private int d = Joc.dimensiune;

    private String move; //NIMIC, SUS, JOS, STANGA, DREAPTA

    public Snake() {
        corp = new ArrayList<>();

        Rectangle temp = new Rectangle(Joc.dimensiune, Joc.dimensiune);
        temp.setLocation(Joc.latime / 2 * Joc.dimensiune, Joc.inaltime / 2 * Joc.dimensiune);
        corp.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 1) * d, (h / 2) * d);
        corp.add(temp);

        temp = new Rectangle(d, d);
        temp.setLocation((w / 2 - 2) * d, (h / 2) * d);
        corp.add(temp);

        move = "NIMIC";
    }

    public void move() {
        if(move != "NIMIC") {
            Rectangle first = corp.get(0);

            Rectangle temp = new Rectangle(Joc.dimensiune, Joc.dimensiune);

            if(move == "SUS") {
                temp.setLocation(first.x, first.y - Joc.dimensiune);
            }
            else if(move == "JOS") {
                temp.setLocation(first.x, first.y + Joc.dimensiune);
            }
            else if(move == "STANGA") {
                temp.setLocation(first.x - Joc.dimensiune, first.y);
            }
            else{
                temp.setLocation(first.x + Joc.dimensiune, first.y);
            }

            corp.add(0, temp);
            corp.remove(corp.size()-1);
        }
    }

    public void grow() {
        Rectangle first = corp.get(0);

        Rectangle temp = new Rectangle(Joc.dimensiune, Joc.dimensiune);

        if(move == "SUS") {
            temp.setLocation(first.x, first.y - Joc.dimensiune);
        }
        else if(move == "JOS") {
            temp.setLocation(first.x, first.y + Joc.dimensiune);
        }
        else if(move == "STANGA") {
            temp.setLocation(first.x - Joc.dimensiune, first.y);
        }
        else{
            temp.setLocation(first.x + Joc.dimensiune, first.y);
        }

        corp.add(0, temp);
    }

    public ArrayList<Rectangle> getcorp() {
        return corp;
    }


    public void setcorp(ArrayList<Rectangle> corp) {
        this.corp = corp;
    }

    public int getX() {
        return corp.get(0).x;
    }

    public int getY() {
        return corp.get(0).y ;
    }

    public String getMove() {
        return move;
    }

    public void up() {
        move = "SUS";
    }
    public void down() {
        move = "JOS";
    }
    public void left() {
        move = "STANGA";
    }
    public void right() {
        move = "DREAPTA";
    }
}