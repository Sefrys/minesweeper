package minesweeper;


/**
 * Created by Ireneusz Zagan on 25.04.18, 18:07
 * Contact: sefrys@gmail.com
 */
public class Minesweeper {
    private final Integer dimension = 6;


    public void displayTable() {
        Cell[][] field = generateField();
        field = placeMines(field);
        for (int x = 0; x < dimension; x++) {
            for (int y = 0; y < dimension; y++) {
                if (field[x][y].isMine) {
                    System.out.print("*   ");
                } else {
                    System.out.print(field[x][y].mineNeighbours + "   ");
                }
            }
            System.out.println("\n");
        }

    }

    private Cell[][] generateField() {
        Cell[][] field = new Cell[dimension][dimension];
        for (int x = 0; x < dimension; x++) {
           for (int y = 0; y < dimension; y++) {
                   field[x][y] = new Cell(false, '0');
           }
        }
        return field;
    }

    private Cell[][] placeMines(Cell[][] field) {
        int mineMaxCount = (int) Math.round(dimension * dimension * 0.2) - 1;
        int mineCount = 0;

        while(mineCount <= mineMaxCount) {
            int x = random();
            int y = random();
            if(!field[x][y].isMine) {
                field[x][y].setMine(true);
                field[x][y].setSymbol('*');

                // North, South
                if(x - 1 >= 0) field[x - 1][y].incrementNeighbours();
                if(x + 1 <= dimension - 1) field[x + 1][y].incrementNeighbours();

                // West, East
                if(y - 1 >= 0) field[x][y - 1].incrementNeighbours();
                if(y + 1 <= dimension - 1) field[x][y + 1].incrementNeighbours();

                // NW Corner, NE Corner
                if(x - 1 >= 0 && y - 1 >= 0) field[x -1][y - 1].incrementNeighbours();
                if(x - 1 >= 0 && y + 1 <= dimension - 1) field[x - 1][y + 1].incrementNeighbours();

                // SW Corner, SE Corner
                if(x + 1 <= dimension - 1 && y - 1 >= 0) field[x + 1][y - 1].incrementNeighbours();
                if(x + 1 <= dimension - 1 && y + 1 <= dimension - 1) field[x + 1][y + 1].incrementNeighbours();

                mineCount++;
            }
        }
        return field;
    }

    private int random() {
        int min = 0;
        int max = dimension - 1;
        return (int) (min + (Math.random() * ((max - min) + 1)));
    }
}
