class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];



        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                
                int k = 3*(i/3)+(j/3);

                int val = 1 << (board[i][j] - '1');

                if ((rows[i] & val) > 0 || (cols[j] & val) > 0 || (boxes[k] & val) > 0) return false;
                else {
                    rows[i] |= val;
                    cols[j] |= val;
                    boxes[k] |= val;
                }
            }
        }

        return true;
    }
}