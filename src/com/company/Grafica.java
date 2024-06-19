package com.company;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Grafica
extends JPanel
implements ActionListener{
    private Timer t = new Timer(100, this);
    public String state;

    private Snake s;
    private Puncte p;
    private Joc Joc;

    public Grafica(Joc g) {
        t.start();
        state = "START";

        Joc = g;
        s = g.getjucator();
        p = g.getPuncte();

        //adauga un keyListener
        this.addKeyListener(g);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, Joc.latime * Joc.dimensiune + 5 , Joc.inaltime * Joc.dimensiune + 5);

        if(state == "START") {
            g2d.setColor(Color.white);
            g2d.drawString("Apasa orice tasta", Joc.latime/2 * Joc.dimensiune - 40, Joc.inaltime / 2 * Joc.dimensiune - 20);
        }
        else if(state == "RUNNING") {
            g2d.setColor(Color.red);
            g2d.fillRect(p.getX() * Joc.dimensiune, p.getY() * Joc.dimensiune, Joc.dimensiune, Joc.dimensiune);

            g2d.setColor(Color.green);
            for(Rectangle r : s.getcorp()) {
                g2d.fill(r);
            }
        }
        else {
            g2d.setColor(Color.white);
            g2d.drawString("Scorul tau: " + (s.getcorp().size() - 3), Joc.latime/2 * Joc.dimensiune - 40, Joc.inaltime / 2 * Joc.dimensiune - 20);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        Joc.update();
    }

}