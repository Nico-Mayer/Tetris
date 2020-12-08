package ui;

import infrastructure.Main;
import io.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame{
    int guiWidth;
    int guiHeight;
    DrawGame game;
    DrawInterface drawInterface;

    public Gui(int x, int y) {
        this.guiWidth = x;
        this.guiHeight = y;
        this.addKeyListener(new KeyHandler());
        this.game = new DrawGame();
        this.drawInterface = new DrawInterface();
        this.add(game);
        this.add(drawInterface);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
        this.setSize(this.guiWidth, this.guiHeight);
        this.getContentPane().setBackground(Color.darkGray);

    }

    public void refresh() {
        this.game.repaint();
        this.drawInterface.repaint();
    }
}
