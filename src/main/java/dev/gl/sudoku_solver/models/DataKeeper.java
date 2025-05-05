package dev.gl.sudoku_solver.models;

import dev.gl.sudoku_solver.gui.SudokuBox;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gl
 */
public class DataKeeper {

    private char[][] matrix = new char[9][9];
    private Map<BoxPosition, SudokuBox> grid = new HashMap<>();

    public DataKeeper() {

        for (BoxPosition position : BoxPosition.values()) {
            grid.put(position, new SudokuBox(position));
        }
    }

    public void updateMatrix() {

        for (BoxPosition position : BoxPosition.values()) {
            updateBox(grid.get(position));
        }
    }

    public SudokuBox getBox(BoxPosition position) {
        return grid.get(position);
    }

    private void updateBox(SudokuBox box) {
        switch (box.getPosition()) {
            case NORTHWEST:
                matrix[0][0] = box.getValue(1, 1);
                matrix[0][1] = box.getValue(1, 2);
                matrix[0][2] = box.getValue(1, 3);

                matrix[1][0] = box.getValue(2, 1);
                matrix[1][1] = box.getValue(2, 2);
                matrix[1][2] = box.getValue(2, 3);

                matrix[2][0] = box.getValue(3, 1);
                matrix[2][1] = box.getValue(3, 2);
                matrix[2][2] = box.getValue(3, 3);
                break;
            case NORTH:
                matrix[0][3] = box.getValue(1, 1);
                matrix[0][4] = box.getValue(1, 2);
                matrix[0][5] = box.getValue(1, 3);

                matrix[1][3] = box.getValue(2, 1);
                matrix[1][4] = box.getValue(2, 2);
                matrix[1][5] = box.getValue(2, 3);

                matrix[2][3] = box.getValue(3, 1);
                matrix[2][4] = box.getValue(3, 2);
                matrix[2][5] = box.getValue(3, 3);
                break;
            case NORTHEAST:
                matrix[0][6] = box.getValue(1, 1);
                matrix[0][7] = box.getValue(1, 2);
                matrix[0][8] = box.getValue(1, 3);

                matrix[1][6] = box.getValue(2, 1);
                matrix[1][7] = box.getValue(2, 2);
                matrix[1][8] = box.getValue(2, 3);

                matrix[2][6] = box.getValue(3, 1);
                matrix[2][7] = box.getValue(3, 2);
                matrix[2][8] = box.getValue(3, 3);
                break;
            case WEST:
                matrix[3][0] = box.getValue(1, 1);
                matrix[3][1] = box.getValue(1, 2);
                matrix[3][2] = box.getValue(1, 3);

                matrix[4][0] = box.getValue(2, 1);
                matrix[4][1] = box.getValue(2, 2);
                matrix[4][2] = box.getValue(2, 3);

                matrix[5][0] = box.getValue(3, 1);
                matrix[5][1] = box.getValue(3, 2);
                matrix[5][2] = box.getValue(3, 3);
                break;
            case MIDDLE:
                matrix[3][3] = box.getValue(1, 1);
                matrix[3][4] = box.getValue(1, 2);
                matrix[3][5] = box.getValue(1, 3);

                matrix[4][3] = box.getValue(2, 1);
                matrix[4][4] = box.getValue(2, 2);
                matrix[4][5] = box.getValue(2, 3);

                matrix[5][3] = box.getValue(3, 1);
                matrix[5][4] = box.getValue(3, 2);
                matrix[5][5] = box.getValue(3, 3);
                break;
            case EAST:
                matrix[3][6] = box.getValue(1, 1);
                matrix[3][7] = box.getValue(1, 2);
                matrix[3][8] = box.getValue(1, 3);

                matrix[4][6] = box.getValue(2, 1);
                matrix[4][7] = box.getValue(2, 2);
                matrix[4][8] = box.getValue(2, 3);

                matrix[5][6] = box.getValue(3, 1);
                matrix[5][7] = box.getValue(3, 2);
                matrix[5][8] = box.getValue(3, 3);
                break;
            case SOUTHWEST:
                matrix[6][0] = box.getValue(1, 1);
                matrix[6][1] = box.getValue(1, 2);
                matrix[6][2] = box.getValue(1, 3);

                matrix[7][0] = box.getValue(2, 1);
                matrix[7][1] = box.getValue(2, 2);
                matrix[7][2] = box.getValue(2, 3);

                matrix[8][0] = box.getValue(3, 1);
                matrix[8][1] = box.getValue(3, 2);
                matrix[8][2] = box.getValue(3, 3);
                break;
            case SOUTH:
                matrix[6][3] = box.getValue(1, 1);
                matrix[6][4] = box.getValue(1, 2);
                matrix[6][5] = box.getValue(1, 3);

                matrix[7][3] = box.getValue(2, 1);
                matrix[7][4] = box.getValue(2, 2);
                matrix[7][5] = box.getValue(2, 3);

                matrix[8][3] = box.getValue(3, 1);
                matrix[8][4] = box.getValue(3, 2);
                matrix[8][5] = box.getValue(3, 3);
                break;
            case SOUTHEAST:
                matrix[6][6] = box.getValue(1, 1);
                matrix[6][7] = box.getValue(1, 2);
                matrix[6][8] = box.getValue(1, 3);

                matrix[7][6] = box.getValue(2, 1);
                matrix[7][7] = box.getValue(2, 2);
                matrix[7][8] = box.getValue(2, 3);

                matrix[8][6] = box.getValue(3, 1);
                matrix[8][7] = box.getValue(3, 2);
                matrix[8][8] = box.getValue(3, 3);
                break;
        }
    }

    public void printMatrix() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < matrix.length; r++) {
            if (r == 0 || r == 3 || r == 6) {
                sb.append(" ___ ___ ___ ");
                sb.append(System.lineSeparator());
            }
            
            for (int c = 0; c < matrix[0].length; c++) {
                if (c == 0) {
                    sb.append("|");
                }

                sb.append(matrix[r][c]);

                if (c == 2 || c == 5 || c == 8) {
                    sb.append("|");
                }

                if (c == 8) {
                    sb.append(System.lineSeparator());
                }
            }
            if (r == 2 || r == 5) {
                sb.append(" ¯¯¯ ¯¯¯ ¯¯¯ ");
                sb.append(System.lineSeparator());
            }
            if (r == 8) {
                sb.append(" ¯¯¯ ¯¯¯ ¯¯¯ ");
                sb.append(System.lineSeparator());
            }
        }
        System.out.println(sb.toString());
    }
}
