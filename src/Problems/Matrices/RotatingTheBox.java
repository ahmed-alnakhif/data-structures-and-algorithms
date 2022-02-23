package Problems.Matrices;

/**
 * You are given an m x n matrix of characters box representing a side-view of a
 * box. Each cell of the box is one of the following:
 * 
 * A stone '#'
 * A stationary obstacle '*'
 * Empty '.'
 * 
 * The box is rotated 90 degrees clockwise, causing some of the stones to fall
 * due to gravity. Each stone falls down until it lands on an obstacle, another
 * stone, or the bottom of the box. Gravity does not affect the obstacles'
 * positions, and the inertia from the box's rotation does not affect the
 * stones' horizontal positions.
 * 
 * It is guaranteed that each stone in box rests on an obstacle, another stone,
 * or the bottom of the box.
 * 
 * Return an n x m matrix representing the box after the rotation described
 * above
 */

public class RotatingTheBox {
    private final char STONE = '#';
    private final char OBSTACLE = '*';
    private final char EMPTY = '.';

    public char[][] rotateTheBox(char[][] box) {
        applyGravity(box);
        return rotate(box);
    }

    protected void applyGravity(char[][] box) {
        for (char[] row : box) {
            int emptyPos = row.length - 1;

            for (int col = row.length - 1; col >= 0; col--) {
                if (row[col] == STONE) {
                    row[col] = EMPTY;
                    row[emptyPos--] = STONE;
                } else if (row[col] == OBSTACLE) {
                    emptyPos = col - 1;
                }
            }
        }
    }

    protected char[][] rotate(char[][] box) {
        int rowLen = box.length;
        int colLen = box[0].length;
        char[][] newBox = new char[colLen][rowLen];

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                newBox[col][rowLen - 1 - row] = box[row][col];
            }
        }

        return newBox;
    }
}
