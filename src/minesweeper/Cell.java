package minesweeper;

import java.util.List;

/**
 * Created by Ireneusz Zagan on 25.04.18, 20:28
 * Contact: sefrys@gmail.com
 */
class Cell {
    boolean isMine;
    char symbol;
    int mineNeighbours;

    Cell(boolean isMine, char symbol) {
        this.isMine = isMine;
        this.symbol = symbol;
    }

    void setMine(boolean mine) {
        isMine = mine;
    }

    void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    void incrementNeighbours() {
        mineNeighbours++;
    }
}
