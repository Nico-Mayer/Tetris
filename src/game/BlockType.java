package game;

import java.util.concurrent.ThreadLocalRandom;

public enum BlockType {
    IBlock,OBlock,TBlock,LBlock,JBlock,ZBlock,SBlock;

    public static BlockType random(){
        return values()[ThreadLocalRandom.current().nextInt(0, values().length)];
    }

}
