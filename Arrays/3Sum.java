/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start

//Brute force solution first
//Slow time complexity of O(n^3) because of three nested loops
//slow because of sorting inside the loops and checking for duplicates with contains()
import java.util.*;

/*class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        // Array list to store the result
        List<List<Integer>> result = new ArrayList<>();

        //iterate through array to collect first, second and third numbers
        for(int i=0; i < nums.length-2; i++){
            for(int j=i+1; j < nums.length-1; j++){
                for(int k=j+1; k < nums.length; k++){
                    //check if the sum of all 3 numbers == 0 at any point
                    if(nums[i] + nums[j] + nums[k] == 0){
                        //store the triplet
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        //Sort to handle duplicate triplets
                        Collections.sort(triplet);
                        //avoid adding duplicate triplets
                        if(!result.contains(triplet)){
                            //add our triplet to the result list
                            result.add(triplet);
                        }
                    }
                }
            }
        }
        //return the list of unique triplets adding to 0
        return result;
    }
}
    */
    //Faster solution using sorting and two pointers
    //Sorting takes O(n logn).
    //Each i iteration runs Two Pointers (O(n)), leading to O(n^2) total time complexity
    //Sorting helps avoid duplicates
    //Two Pointers help avoid unnecessary nested loops
    //Skipping duplicates ensures only unique triplets are added

    class Solution {
        // returns a list of integers
        public List<List<Integer>> threeSum(int[] nums){
            //sort the input array in ascending order so pointers can be used
            Arrays.sort(nums);
            //create an array list to store the result to be returned
            List<List<Integer>> result = new ArrayList();
            //isolate first value to be added to next two to equal 0
            for(int i = 0; i < nums.length-2; i++){
                // negate duplicates
                //check that the value at i is not equal to the value of the index before it
                if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                    // create pointers starting at the value after i
                    // and ending at the last index of the input array
                    int a_pointer = i+1;
                    int b_pointer = nums.length-1;
                    // store the value we want the 2 pointers to equal to
                    int sum = 0 - nums[i];
                    
                    while(a_pointer < b_pointer){
                        if(nums[a_pointer] + nums[b_pointer] == sum){
                            //found a valid triplet so append it to the result
                            result.add(Arrays.asList(nums[i], nums[a_pointer], nums[b_pointer]));

                            //Move pointers to the next different numbers to avoid duplicates
                            while (a_pointer < b_pointer && nums[a_pointer] == nums[a_pointer+1]) a_pointer++;
                            while (a_pointer < b_pointer && nums[b_pointer] == nums[b_pointer-1]) b_pointer--;

                            a_pointer++;
                            b_pointer--;
                        }
                        //if number is too large reduce larger number
                        else if(nums[a_pointer] + nums[b_pointer] > sum){
                            b_pointer--;
                        } else 
                        //else if number is too small increase smaller number
                        {
                            a_pointer++;
                        }
                    }
                }
            }
            //return the output
            return result;
        }
    }
    
// @lc code=end

