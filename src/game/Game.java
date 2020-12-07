package game;

import infrastructure.Main;

import java.util.ArrayList;

public class Game {
    public static int score = 0, highscore = 0, scoreToAdd = 0;
    public static boolean spawnNewBlock = false, speedup = false;
    public static Block currentBlock, nextBlock;
    public static int[][] map = new int[Main.COLUMS][Main.ROWS];
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

    public static void addBlockToMap(Block block){
        for (int x = 0; x < block.map.length; x++) {
            for (int y = 0; y < block.map[x].length; y++) {
                if (block.map[y][x] == 1) {
                    map[block.getxPos() + x][block.getyPos() + y] = 1;
                }
            }
        }
    }

}
