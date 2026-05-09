class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];
        
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                int box = 3 * (row / 3) + col / 3;

                char character = board[row][col];
                if (character == '.') {
                    continue;
                }
                
                int num = character - '1';
                int mask = 1 << num;

                if ((rows[row] & mask) != 0 || 
                    (cols[col] & mask) != 0 ||
                    (boxes[box] & mask) != 0 ) {
                        return false;
                } else {
                    rows[row] |= mask;
                    cols[col] |= mask;
                    boxes[box] |= mask;
                }
            }
        }

        return true;
    }
}
