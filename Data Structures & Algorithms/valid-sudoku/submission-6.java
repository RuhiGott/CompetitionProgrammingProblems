class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (cols[i] == null) cols[i] = new HashSet<>();
                if (rows[j] == null) rows[j] = new HashSet<>();
                if (boxes[3*(i/3)+(j/3)] == null) boxes[3*(i/3)+(j/3)] = new HashSet<>();


                char val = board[i][j];

                if (cols[i].contains(val) || rows[j].contains(val) || boxes[3*(i/3)+(j/3)].contains(val)) {
                    return false;
                } else {
                    cols[i].add(val);
                    rows[j].add(val);
                    boxes[3*(i/3)+(j/3)].add(val);
                }
            }
        }

        return true;
    }
}

/*
col = y / 3
row = x / 3

00 01 02
10 11 12
20 21 22

0 1 2
3 4 5
6 7 8

0+0 0+1 0+2
1+0+2 1+1+2 1+2+2
2+0+4 2+1+4 2+2+4

0 1 2
3 4 5
6





00 01 02  03 04 05  06 07 08  
10 11 12  13 14 15  16 17 18
20 21 22  23 24 25  26 27 28

30 31 32  33 34 05  36 37 38  
40 41 42  43 44 45  46 47 48
50 51 52  53 54 55  56 57 58

60 61 62  63 64 65  66 67 68  
70 71 72  73 74 75  76 77 78
80 81 82  83 84 85  86 87 88 */