package data;

import game.Block;
import infrastructure.Main;

public class Collision {

    public static void checkBottomCollision(Block block)
    {
        for (int y = 0; y < block.block.length; y++) {
            for (int x = 0; x < block.block[0].length; x++) {
                if (block.block[y][x] == 1 && block.getCell_Y(y) == Main.ROWS - 1) {
                    System.out.println("Bottom Collision on x: "+ x + " y: "+ y);
                    block.setPos(0,0);
                }
            }
        }
    }
    public static boolean canMoveRight(Block block)
    {
        for (int y = 0; y < block.block.length; y++) {
            for (int x = 0; x < block.block[0].length; x++) {
                if (block.block[y][x] == 1 && block.getCell_X(x) == Main.COLUMS - 1) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean canMoveLeft(Block block)
    {
        for (int y = 0; y < block.block.length; y++) {
            for (int x = 0; x < block.block[0].length; x++) {
                if (block.block[y][x] == 1 && block.getCell_X(x) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
