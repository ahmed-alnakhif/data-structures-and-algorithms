package Problems.matrix;

public class BalloonBurst {

    public static void balloonBurst(int[][] board){
        
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
            {3, 1, 1},
            {2, 1, 1},
            {1, 1, 1}
        };
        
        balloonBurst(matrix);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
