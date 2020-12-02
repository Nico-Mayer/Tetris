package infrastructure;

import ui.Gui;

public class Main {
    private static Gui gui;

    public static void main(String[] args) {
        gui = new Gui();
        gui.create();
    }
}
