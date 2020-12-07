package ui;

import data.Conversion;
import game.Block;
import game.Game;
import infrastructure.Main;

import javax.swing.*;
import java.awt.*;

public class DrawGame extends JPanel {

    public DrawGame() {
        this.setSize(Main.gameWidth, Main.gameHeight);
        this.setBounds(20,20, Main.gameWidth, Main.gameHeight);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        drawMap(g);
        g.setColor(Game.currentBlock.getColor());
        Game.currentBlock.drawBlock(g);

        drawGridLines(g);
        repaint();
    }

    private void drawGridLines(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        for (int x = 0; x < Main.COLUMS ; x++) {
            for (int y = 0; y < Main.ROWS ; y++) {
                g.drawRect(x * Main.CELL_SIZE, y * Main.CELL_SIZE, Main.CELL_SIZE, Main.CELL_SIZE );
            }
        }
        g.setColor(Color.BLACK);
        g.drawRect(0, 0,  Main.gameWidth, Main.gameHeight);
    }
    private void drawMap(Graphics g){
        for (int x = 0; x < Game.map.length; x++) {
            for (int y = 0; y < Game.map[x].length; y++) {
                if(Game.map[x][y] == 1){
                    g.setColor(Color.RED);
                    g.fillRect(Conversion.intToCell(x),
                             Conversion.intToCell(y), Main.CELL_SIZE, Main.CELL_SIZE);
                }
            }
        }
    }

}
