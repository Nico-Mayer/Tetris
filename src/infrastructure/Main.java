package infrastructure;

import game.Block;
import game.Game;
import ui.DrawGame;
import ui.Gui;

public class Main {
    private static Gui gui;
    private static Game game;

    // Game width and Hight in Blocks
    public static final int ROWS = 20;
    public static final int COLUMS = 10;
    public static final int GUI_WDITH = 700;
    public static final int GUI_HEIGHT = 700;
    public static final int CELL_SIZE = 32;
    public static int gameWidth = COLUMS * CELL_SIZE;
    public static int gameHeight = ROWS * CELL_SIZE;

    public static void main(String[] args) {

        game = new Game();
        gui = new Gui(GUI_WDITH, GUI_HEIGHT);
        startLoop();

    }

    public static void startLoop(){
        GameLoop loop = new GameLoop(game , gui);
        loop.start();
    }
}
