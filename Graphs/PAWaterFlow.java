/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;

        //matrices to track which cells can reach the respective oceans
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        //start dfs from top and bottom edges (pacific and atlantic respectively)
        for (int col = 0; col< cols; col++){
            dfs(0, col, pacific, heights[0][col], heights); //pacific top edge
            dfs(rows-1, col, atlantic, heights[rows-1][col], heights); // atlantic bottom edge
        }
        
        //start dfs from left and right edges (pacific and atlantic respectively)
        for (int row = 0; row<rows; row++){
            dfs(row, 0, pacific, heights[row][0], heights); //pacific left edge
            dfs(row, cols-1, atlantic, heights[row][cols-1], heights); //atlantic right edge
        }
        
        //collect cells that are reachable from both oceans
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                if (pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i,j));
            }
        }
        return result;
    }
    
    //standard dfs traversal with elevation condiiton
    private void dfs(int row, int col, boolean[][] visited, int prevHeight, int[][] heights){
        //boundary and constraint checks
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || visited[row][col] || prevHeight > heights[row][col])
            return;
            //mark the current cell as visited for the current ocean
        visited[row][col]= true;

        //explore all 4 directions
        dfs(row+1, col, visited, heights[row][col], heights);
        dfs(row-1, col, visited, heights[row][col], heights);
        dfs(row, col+1, visited, heights[row][col], heights);
        dfs(row, col-1, visited, heights[row][col], heights);
    }
    
}
// @lc code=end


