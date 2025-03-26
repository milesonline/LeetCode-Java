import java.util.HashMap;
import java.util.Map;
/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */


 
  // Brute force solution, Works but slow time complexity
  /* 
  class Solution {
    public int[] twoSum(int[] nums, int target) {

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                 return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("no match found");
    }
}
    Time complexity O(n^2) because of a nested for loop that both loop over elements of the array
  */

// // @lc code=start

//HashMap solution ( a collection of Key -> Value Pairs)

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> complements = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer complementIndex = complements.get(nums[i]);
            if(complementIndex != null){
                return new int[]{complementIndex, i};
            }
            complements.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("no match found");

    }
}

// only loop through array once
//Hashmaps use constant time look up
//time complexity = O(n)  or linear

//Another hashmap solution  for variety
/*class Solution{
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> num_map = new HashMap<>();
        
        for(int i =0; i < nums.length; i++){
            int complement = target - nums[i];

            if(num_map.containsKey(complement)){
                return new int[] {num_map.get(complement), i};
            }
            num_map.put(nums[i], i);
        }
        throw new IllegalArgumentException("NO MATCH FOUND!");
    }
}
    */
// @lc code=end

