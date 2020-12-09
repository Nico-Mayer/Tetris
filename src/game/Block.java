package game;

import data.Conversion;

import java.awt.*;

public class Block {
    private final int[][] I_BLOCK = {{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}};
    private final int[][] O_BLOCK = {{1, 1}, {1, 1}};
    private final int[][] T_BLOCK = {{0, 1, 0}, {1, 1, 1}, {0, 0, 0}};
    private final int[][] L_BLOCK = {{0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
    private final int[][] J_BLOCK = {{1, 0, 0}, {1, 1, 1}, {0, 0, 0}};
    private final int[][] Z_BLOCK = {{1, 1, 0}, {0, 1, 1}, {0, 0, 0}};
    private final int[][] S_BLOCK = {{0, 1, 1}, {1, 1, 0}, {0, 0, 0}};

    public int[][] map;

    public BlockType type;
    public Color color;
    public int xPos = 0;
    private int yPos = 0;
    private int cellSize;
    public int size;


    public Block(int cellSize) {

        this.cellSize = cellSize;
        this.type = BlockType.random();

        switch (this.type) {
            case IBlock:
                map = I_BLOCK;
                this.size = 4;
                color = Color.CYAN;
                break;
            case OBlock:
                map = O_BLOCK;
                this.size = 2;
                color = Color.YELLOW;
                break;
            case TBlock:
                map = T_BLOCK;
                this.size = 3;
                color = Color.MAGENTA;
                break;
            case LBlock:
                map = L_BLOCK;
                this.size = 3;
                color = Color.PINK;
                break;
            case JBlock:
                map = J_BLOCK;
                this.size = 3;
                color = Color.BLUE;
                break;
            case ZBlock:
                map = Z_BLOCK;
                this.size = 3;
                color = Color.RED;
                break;
            case SBlock:
                map = S_BLOCK;
                this.size = 3;
                color = Color.GREEN;
                break;
        }

    }

    public void drawBlock(Graphics g) {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (map[row][col] == 1) {
                    g.setColor(color);
                    g.fillRect(col * cellSize + Conversion.intToCell(xPos),
                            row * cellSize + Conversion.intToCell(yPos), cellSize, cellSize);
                }
            }
        }
    }

    public int[][] rotate() {
        int[][] rotatedMap = new int[map.length][map.length];
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map.length; col++) {
                rotatedMap[row][col] = map[map.length - col - 1][row];
            }
        }
        return rotatedMap;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public int getCellColl(int cellCol)
    {
        return xPos + cellCol;
    }
    public int getCellRow(int cellRow)
    {
        return yPos + cellRow;
    }

    public Color getColor() {
        return color;
    }

    public void setPos(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }
    public void moveRight(){
        this.xPos++;
    }
    public void moveLeft(){
        this.xPos--;
    }
    public void moveDown(){
        this.yPos++;
    }
}