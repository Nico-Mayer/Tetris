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

        this.setBackground(Color.darkGray);
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
        g.setColor(Color.WHITE);
        g.drawRect(0, 0,  Main.gameWidth, Main.gameHeight);
    }
    private void drawMap(Graphics g){
        for (int row = 0; row < Game.map.length; row++) {
            for (int col = 0; col < Game.map[row].length; col++) {
                if(Game.map[row][col] > 0){
                    switch (Game.map[row][col]){
                        // IBlock
                        case 1:
                            g.setColor(Color.CYAN);
                            break;
                        // JBlock
                        case 2:
                            g.setColor(Color.BLUE);
                            break;
                        // LBlock
                        case 3:
                            g.setColor(Color.PINK);
                            break;
                        // OBlock
                        case 4:
                            g.setColor(Color.YELLOW);
                            break;
                        // ZBlock
                        case 5:
                            g.setColor(Color.RED);
                            break;
                        // SBlock
                        case 6:
                            g.setColor(Color.GREEN);
                            break;
                        // TBlock
                        case 7:
                            g.setColor(Color.MAGENTA);
                            break;
                    }
                    g.fillRect(Conversion.intToCell(col),
                             Conversion.intToCell(row), Main.CELL_SIZE, Main.CELL_SIZE);
                }
            }
        }
    }

}
