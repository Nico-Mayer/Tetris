package data;

import infrastructure.Main;

public class Conversion {
    public static int intToCell(int coord){
        return coord * Main.CELL_SIZE;
    }
}
