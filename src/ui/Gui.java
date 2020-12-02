package ui;

import io.KeyHandler;

import javax.swing.*;

public class Gui {
    private JFrame jf;
    private DrawGame drawGame;
    private DrawInterface drawInterface;

    public void create(){
        jf = new JFrame("Tetris");
        jf.setSize(DrawGame.gameWidth + 17 + 200, DrawGame.gameHeight + 41);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setResizable(false);
        jf.setLayout(null);
        jf.addKeyListener(new KeyHandler());
        jf.requestFocus();

        drawInterface = new DrawInterface();
        setupDraw(drawInterface, DrawGame.gameWidth +1 ,1, DrawGame.gameWidth , DrawGame.gameHeight);
        drawGame = new DrawGame();

        setupDraw(drawGame,0,0, DrawGame.gameWidth , DrawGame.gameHeight);

        jf.setVisible(true);
    }

    private void setupDraw(JLabel draw, int x, int y, int width, int height){
        draw.setBounds(x,y,width,height);
        draw.setVisible(true);
        jf.add(draw);
    }
}
