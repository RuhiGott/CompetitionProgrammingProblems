class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int box = 3 * (row / 3) + col / 3;

                char character = board[row][col];
                if (character == '.') {
                    continue;
                }
                
                int num = character - '1';

                if (rows[row][num] || 
                    cols[col][num] ||
                    boxes[box][num]) {
                        return false;
                } else {
                    rows[row][num] = true;
                    cols[col][num] = true;
                    boxes[box][num] = true;
                }
            }
        }

        return true;
    }
}
