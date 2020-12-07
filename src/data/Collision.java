package data;

import game.Block;
import game.Game;
import infrastructure.Main;

public class Collision {

    public static void checkBottomCollision(Block block)
    {
        for (int y = 0; y < block.map.length; y++) {
            for (int x = 0; x < block.map[0].length; x++) {
                if (block.map[y][x] == 1 && block.getCell_Y(y) >= Main.ROWS - 1) {
                    Game.addBlockToMap(block);
                    System.out.println("Bottom Collision on x: "+ x + " y: "+ y);
                    Game.spawnNewBlock = true;
                }
            }
        }
    }
    public static boolean canRotete(Block block)
    {
        Block tmpBlock = new Block(Main.CELL_SIZE);
        tmpBlock.setPos(block.getxPos(), block.getyPos());
        tmpBlock.map = block.rotate();
        for (int y = 0; y < tmpBlock.map.length; y++) {
            for (int x = 0; x < tmpBlock.rotate()[0].length; x++) {
                if (tmpBlock.map[y][x] == 1 && tmpBlock.getCell_X(x) > Main.COLUMS - 1) {
                    System.out.println("Cant rotate right collison");
                    return false;
                }
                if (tmpBlock.map[y][x] == 1 && tmpBlock.getCell_X(x) < 0) {
                    System.out.println("Cant rotate left collison");
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean canMoveRight(Block block)
    {
        for (int y = 0; y < block.map.length; y++) {
            for (int x = 0; x < block.map[0].length; x++) {
                if (block.map[y][x] == 1 && block.getCell_X(x) >= Main.COLUMS - 1) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean canMoveLeft(Block block)
    {
        for (int y = 0; y < block.map.length; y++) {
            for (int x = 0; x < block.map[0].length; x++) {
                if (block.map[y][x] == 1 && block.getCell_X(x) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
