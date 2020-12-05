package io;

import data.Collision;
import game.Block;
import game.Game;
import game.GameState;
import infrastructure.Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(Collision.canRotete(Game.currentBlock)) {
                Game.currentBlock.map = Game.currentBlock.rotate();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_D){
            if(Collision.canMoveRight(Game.currentBlock)){
                    Game.currentBlock.moveRight();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_A){
            if(Collision.canMoveLeft(Game.currentBlock)){
                Game.currentBlock.moveLeft();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_S){
            Game.speedup = true;
        }

        if(Game.gameState == GameState.start){
            if(e.getKeyCode() == KeyEvent.VK_ENTER){
                Game.gameState = GameState.ingame;
                System.out.println(Game.gameState);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_S){
            Game.speedup = false;
        }
    }
}
