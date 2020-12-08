package ui;

import game.Game;
import infrastructure.Main;

import javax.swing.*;
import java.awt.*;

public class DrawInterface extends JPanel {
    public DrawInterface() {
        this.setBounds(20+ Main.gameWidth + 2 * Main.CELL_SIZE, 20,
                4*Main.CELL_SIZE, 4* Main.CELL_SIZE);

    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Game.nextBlock.getColor());
        Game.nextBlock.drawBlock(g);
        this.setBackground(Color.darkGray);

        g.setColor(Color.LIGHT_GRAY);

        for (int x = 0; x < 4 ; x++) {
            for (int y = 0; y < 4 ; y++) {
                g.drawRect(x * Main.CELL_SIZE, y * Main.CELL_SIZE,
                        Main.CELL_SIZE, Main.CELL_SIZE );
            }
        }
        g.setColor(Color.WHITE);
        g.drawRect(0, 0,  4 * Main.CELL_SIZE, 4 * Main.CELL_SIZE);

        repaint();
    }
}
