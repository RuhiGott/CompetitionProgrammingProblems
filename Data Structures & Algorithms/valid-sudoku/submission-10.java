class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int num = board[i][j] - '0';

                if ((rows[i] & (1 << num)) > 0) {
                    return false;
                } else {
                    rows[i] |= 1 << num;
                }

                if ((cols[j] & (1 << num)) > 0) {
                    return false;
                } else {
                    cols[j] |= 1 << num;
                }

                if ((boxes[3 * (i / 3) + (j / 3)] & (1 << num)) > 0) {
                    return false;
                } else {
                    boxes[3 * (i / 3) + (j / 3)] |= 1 << num;
                }
            }
        }

        return true;
    }
}

