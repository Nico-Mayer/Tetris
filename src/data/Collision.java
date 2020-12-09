package data;

import game.Block;
import game.Game;
import infrastructure.Main;

public class Collision {

    public static void checkBottomCollision(Block block)
    {
        for (int row = 0; row < block.map.length; row++) {
            for (int col = 0; col < block.map[0].length; col++) {
                if (block.map[row][col] == 1 && block.getCellRow(row) >= Main.ROWS - 1) {
                    Game.spawnNewBlock = true;
                    Game.addBlockToMap(block);
                    System.out.println("Bottom Collision on x: "+ col + " y: "+ row);
                }
            }
        }
    }
    public static boolean canRotete(Block block)
    {
        Block tmpBlock = new Block(Main.CELL_SIZE);
        tmpBlock.setPos(block.getxPos(), block.getyPos());
        tmpBlock.map = block.rotate();
        for (int row = 0; row < tmpBlock.map.length; row++) {
            for (int col = 0; col < tmpBlock.rotate()[0].length; col++) {
                if(tmpBlock.map[row][col] == 1){
                    if (tmpBlock.getCellColl(col) > Main.COLUMS - 1) {
                        System.out.println("Cant rotate right collison");
                        return false;
                    }
                    else if (tmpBlock.getCellColl(col) < 0) {
                        System.out.println("Cant rotate left collison");
                        return false;
                    }
                    else if(Game.map[tmpBlock.getCellRow(row)][tmpBlock.getCellColl(col)] > 0){
                        System.out.println("Cant rotate block collision");
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static boolean canMoveRight(Block block)
    {
        for (int row = 0; row < block.map.length; row++) {
            for (int col = 0; col < block.map[0].length; col++) {
                if (block.map[row][col] == 1 && block.getCellColl(col) >= Main.COLUMS - 1) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean canMoveLeft(Block block)
    {
        for (int row = 0; row < block.map.length; row++) {
            for (int col = 0; col < block.map[0].length; col++) {
                if (block.map[row][col] == 1 && block.getCellColl(col) <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void checkBlockOnBlockCollision(Block block)
    {
        for (int row = 0; row < block.map.length; row++) {
            for (int col = 0; col < block.map[0].length; col++) {
                if (block.map[row][col] == 1) {
                   // if(if)
                }
            }
        }
    }
}
