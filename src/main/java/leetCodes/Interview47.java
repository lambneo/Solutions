package leetCodes;

/**
 * 礼物最大值，简单dp
 */
public class Interview47 {
    public int maxValue(int[][] grid) {
        int w = grid[0].length, h = grid.length;
        for (int i = 1; i < w; i++){
            grid[0][i] += grid[0][i - 1];
        }
        for(int i = 1; i < h; i++){
            grid[i][0] += grid[i - 1][0];
            for(int j = 1; j < w; j++){
                grid[i][j] += Math.max(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[h-1][w-1];
    }
}
