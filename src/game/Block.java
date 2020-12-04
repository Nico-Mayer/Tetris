package game;

import data.Conversion;
import infrastructure.Main;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Block {
    private final int[][] I_BLOCK = {{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}};
    private final int[][] O_BLOCK = {{1, 1}, {1, 1}};
    private final int[][] T_BLOCK = {{0, 1, 0}, {1, 1, 1}, {0, 0, 0}};
    private final int[][] L_BLOCK = {{0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
    private final int[][] J_BLOCK = {{1, 0, 0}, {1, 1, 1}, {0, 0, 0}};
    private final int[][] Z_BLOCK = {{1, 1, 0}, {0, 1, 1}, {0, 0, 0}};
    private final int[][] S_BLOCK = {{0, 1, 1}, {1, 1, 0}, {0, 0, 0}};

    public int[][] block;

    private BlockType type;
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
                block = I_BLOCK;
                this.size = 4;
                color = Color.CYAN;
                break;
            case OBlock:
                block = O_BLOCK;
                this.size = 2;
                color = Color.YELLOW;
                break;
            case TBlock:
                block = T_BLOCK;
                this.size = 3;
                color = Color.MAGENTA;
                break;
            case LBlock:
                block = L_BLOCK;
                this.size = 3;
                color = Color.ORANGE;
                break;
            case JBlock:
                block = J_BLOCK;
                this.size = 3;
                color = Color.BLUE;
                break;
            case ZBlock:
                block = Z_BLOCK;
                this.size = 3;
                color = Color.RED;
                break;
            case SBlock:
                block = S_BLOCK;
                this.size = 3;
                color = Color.GREEN;
                break;
        }

    }

    public void drawBlock(Graphics g) {
        for (int row = 0; row < block.length; row++) {
            for (int col = 0; col < block[0].length; col++) {
                if (block[row][col] == 1) {
                    g.setColor(color);
                    g.fillRect(col * cellSize + Conversion.intToCell(xPos),
                            row * cellSize + Conversion.intToCell(yPos), cellSize, cellSize);
                }
            }
        }
    }

    public void rotate() {
        int[][] tmpArray = new int[block.length][block.length];
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block.length; j++) {
                tmpArray[i][j] = block[block.length - j - 1][i];
            }
        }
        block = tmpArray;
    }
    public int getCell_X(int x)
    {
        return xPos + x;
    }
    public int getCell_Y(int y)
    {
        return yPos + y;
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