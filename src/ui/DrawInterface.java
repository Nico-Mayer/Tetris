package ui;

import javax.swing.*;
import java.awt.*;

public class DrawInterface extends JLabel {
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.LIGHT_GRAY);

        for (int x = 0; x < 4 ; x++) {
            for (int y = 0; y < 4 ; y++) {
                g.drawRect(x * DrawGame.BLOCK_SIZE + DrawGame.BLOCK_SIZE, y * DrawGame.BLOCK_SIZE,
                        DrawGame.BLOCK_SIZE, DrawGame.BLOCK_SIZE );
            }
        }
        g.setColor(Color.BLACK);
        g.drawRect(DrawGame.BLOCK_SIZE, 0,  4 * DrawGame.BLOCK_SIZE, 4 * DrawGame.BLOCK_SIZE);

        repaint();
    }
}
