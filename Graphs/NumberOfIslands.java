/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start

//time and space compexity O(m*n) as each cell is visited at most once
class Solution {
    public int numIslands(char[][] grid) {
        
        //create variable to store the number of islands 
        int count = 0;

        //traverse through grid 
        for(int i = 0; i < grid.length; i++){ //each row
            for(int j = 0; j < grid[i].length; j++){ //each column in row
                //if we find land this is the start of an island
                if(grid[i][j] == '1'){
                    //increase count because we found an island
                    count++;
                    //mark that island as visited
                    callDFS(grid, i , j);
                }
            }
        }
        //after checking everything return result total
        return count;
    }


        //helper dfs function to sink islands
        public void callDFS(char[][] grid, int i, int j){
            //base case, if we are out of bounds or hit water(0), stop recursion
            if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') return;

            //mark the current cell as visited
            grid[i][j] = '0';

            //recursively visit all four directions
            //up
            callDFS(grid, i+1, j);
            //down
            callDFS(grid, i-1, j);
            //right
            callDFS(grid, i, j+1);
            //left
            callDFS(grid, i, j-1);

    }
}
// @lc code=end

