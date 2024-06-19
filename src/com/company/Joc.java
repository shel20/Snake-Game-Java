package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Joc
        implements KeyListener{
    private Snake jucator;
    private Puncte puncte;
    private Grafica grafica;

    private JFrame fereastra;

    public static final int latime = 30;
    public static final int inaltime = 30;
    public static final int dimensiune = 20;

    public Joc() {
        fereastra = new JFrame();

        jucator = new Snake();

        puncte = new Puncte(jucator);

        grafica = new Grafica(this);

        fereastra.add(grafica);

        fereastra.setTitle("Snake");
        fereastra.setSize(latime * dimensiune + 2 , inaltime * dimensiune + dimensiune + 4);
        fereastra.setVisible(true);
        fereastra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fereastra.setResizable(false);
    }

    public void start() {
        grafica.state = "RUNNING";
    }

    public void update() {
        if(grafica.state == "RUNNING") {
            if(check_food_collision()) {
                jucator.grow();
                puncte.random_spawn(jucator);
            }
            else if(check_wall_collision() || check_self_collision()) {
                grafica.state = "END";
            }
            else {
                jucator.move();
            }
        }
    }

    private boolean check_wall_collision() {
        if(jucator.getX() < 0 || jucator.getX() >= latime * dimensiune
                || jucator.getY() < 0|| jucator.getY() >= inaltime * dimensiune) {
            return true;
        }
        return false;
    }

    private boolean check_food_collision() {
        if(jucator.getX() == puncte.getX() * dimensiune && jucator.getY() == puncte.getY() * dimensiune) {
            return true;
        }
        return false;
    }

    private boolean check_self_collision() {
        for(int i = 1; i < jucator.getcorp().size(); i++) {
            if(jucator.getX() == jucator.getcorp().get(i).x &&
                    jucator.getY() == jucator.getcorp().get(i).y) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {	}

    @Override
    public void keyPressed(KeyEvent e) {

        int tasta = e.getKeyCode();

        if(grafica.state == "RUNNING") {
            if(tasta == KeyEvent.VK_W && jucator.getMove() != "JOS") {
                jucator.up();
            }

            if(tasta == KeyEvent.VK_S && jucator.getMove() != "SUS") {
                jucator.down();
            }

            if(tasta == KeyEvent.VK_A && jucator.getMove() != "DREAPTA") {
                jucator.left();
            }

            if(tasta == KeyEvent.VK_D && jucator.getMove() != "STANGA") {
                jucator.right();
            }
        }
        else {
            this.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {	}

    public Snake getjucator() {
        return jucator;
    }

    public void setjucator(Snake jucator) {
        this.jucator = jucator;
    }

    public Puncte getPuncte() {
        return puncte;
    }

    public void setPuncte(Puncte puncte) {
        this.puncte = puncte;
    }

    public JFrame getfereastra() {
        return fereastra;
    }

    public void setfereastra(JFrame fereastra) {
        this.fereastra = fereastra;
    }

}