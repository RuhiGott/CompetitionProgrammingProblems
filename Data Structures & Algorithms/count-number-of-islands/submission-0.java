class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    clearIsland(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    
    private void clearIsland(char[][] grid, int i, int j) {
        //System.out.println("i: " + i + ", j: " + j + Arrays.deepToString(grid));
        if (grid[i][j] == '0') {
            return;
        }
        
        grid[i][j] = '0';
    
        if (i > 0) {
            clearIsland(grid, i - 1 , j);
        }

        if (i < grid.length - 1) {
            clearIsland(grid, i + 1, j);
        } 

        if (j > 0) {
            clearIsland(grid, i , j - 1);
        }

        if (j < grid[0].length - 1) {
            clearIsland(grid, i , j + 1);
        }
    }
}
