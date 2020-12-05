package game;

import infrastructure.Main;

import java.util.ArrayList;

public class Game {
    public static int score = 0, highscore = 0, scoreToAdd = 0;
    public static boolean spawnNewBlock = false, speedup = false;
    public static Block currentBlock, nextBlock;
    public int[][] map = new int[Main.COLUMS][Main.ROWS];
    public static GameState gameState = GameState.start;

    public static ArrayList<Block> blocks = new ArrayList<Block>();

    public Game() {
        initMap();
        this.currentBlock = new Block(Main.CELL_SIZE);
        this.currentBlock.setPos(4, -3);
        this.nextBlock = new Block(Main.CELL_SIZE);
    }

    public void initMap()
    {
        for (int i = 0; i < Main.COLUMS; i++) {
            for (int j = 0; j < Main.ROWS; j++) {
                this.map[i][j] = 0;
            }
        }
    }

}
