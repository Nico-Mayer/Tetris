package game;

import infrastructure.Main;

import java.util.ArrayList;

public class Game {
    public static int score = 0, highscore = 0, scoreToAdd = 0;
    public static boolean spawnNewBlock = false, speedup = false;
    public static Block currentBlock, nextBlock;
    public static int[][] map = new int[Main.ROWS][Main.COLUMS];
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
        for (int row = 0; row < Main.ROWS; row++) {
            for (int col = 0; col < Main.COLUMS; col++) {
                this.map[row][col] = 0;
            }
        }
    }

    public static void addBlockToMap(Block block){
        for (int row = 0; row < block.map.length; row++) {
            for (int col = 0; col < block.map.length; col++) {
                if (block.map[row][col] == 1) {
                    switch(block.type){
                        case IBlock:
                            map[block.getyPos() + row][block.getxPos() + col] = 1;
                            break;
                        case JBlock:
                            map[block.getyPos() + row][block.getxPos() + col] = 2;
                            break;
                        case LBlock:
                            map[block.getyPos() + row][block.getxPos() + col] = 3;
                            break;
                        case OBlock:
                            map[block.getyPos() + row][block.getxPos() + col] = 4;
                            break;
                        case ZBlock:
                            map[block.getyPos() + row][block.getxPos() + col] = 5;
                            break;
                        case SBlock:
                            map[block.getyPos() + row][block.getxPos() + col] = 6;
                            break;
                        case TBlock:
                            map[block.getyPos() + row][block.getxPos() + col] = 7;
                            break;
                    }
                }
            }
        }
    }

}
