class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rows = new HashMap<>();
        Map<Integer, Set<Integer>> cols = new HashMap<>();
        Map<Integer, Set<Integer>> boxes = new HashMap<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int box = 3 * (i / 3) + j / 3;

                char character = board[i][j];
                if (character == '.') {
                    continue;
                }
                
                int num = Character.getNumericValue(character);

                if (!rows.containsKey(i)) {
                    rows.put(i, new HashSet<>());
                }

                if (!cols.containsKey(j)) {
                    cols.put(j, new HashSet<>());
                }

                if (!boxes.containsKey(box)) {
                    boxes.put(box, new HashSet<>());
                }

                if (rows.get(i).contains(num) || 
                    cols.get(j).contains(num) ||
                    boxes.get(box).contains(num)) {
                        return false;
                } else {
                    rows.get(i).add(num);
                    cols.get(j).add(num);
                    boxes.get(box).add(num);
                }
            }
        }

        return true;
    }
}
