package ui;

import javax.swing.*;
import java.awt.*;

public class DrawGame extends JLabel {
    // Game width and Hight in Blocks
    private static final int HEIGHT = 18;
    private static final int WIDTH = 10;
    public static final int BLOCK_SIZE = 32;
    public static int gameWidth = WIDTH * DrawGame.BLOCK_SIZE;
    public static int gameHeight = HEIGHT * DrawGame.BLOCK_SIZE;

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);

        for (int x = 0; x < WIDTH ; x++) {
            for (int y = 0; y < HEIGHT ; y++) {
                g.drawRect(x * BLOCK_SIZE, y *BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE );
            }
        }
        g.setColor(Color.BLACK);
        g.drawRect(0, 0,  gameWidth, gameHeight);

        repaint();
    }
}
