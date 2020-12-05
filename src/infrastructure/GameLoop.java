package infrastructure;

import data.Collision;
import game.Block;
import game.Game;
import game.GameState;
import ui.DrawGame;
import ui.DrawInterface;
import ui.Gui;

public class GameLoop extends Thread{
    private boolean running = true;
    Game game;
    Gui gui;

    public GameLoop(Game game, Gui gui) {
       this.game = game;
       this.gui = gui;
    }

    @Override
    public void run(){
        while(running){
            try {
                if(Game.spawnNewBlock){
                    Game.blocks.add(Game.nextBlock);
                    Game.currentBlock = Game.nextBlock;
                    Game.nextBlock = new Block(Main.CELL_SIZE);
                    Game.spawnNewBlock = false;
                }
                if(Game.gameState == GameState.ingame){
                    Collision.checkBottomCollision(Game.currentBlock);
                    Game.currentBlock.moveDown();

                    if(Game.speedup){
                        sleep(50);
                    }else {
                        sleep(1000);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Running");
        }
    }
}
