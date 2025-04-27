/*
 * This file is for practising LeetCode Questions:
 * 1. TwoSum
 * TwoSum II
 * 3Sum
 * and 4Sum brute force.
 * it will comprise of both the brute force versions
 * and the optimised versions of each problem.
 */

//TwoSum Brute force solution
class Solution{
    public int[] twoSum(int[] nums, int target){
        //loop to pick first value
        for(int i = 0; i<nums.length; i++){
            //loop to pick second value
            for(int j = i+1; j < nums.length; j++){
                //store value of the complement
                int complement = target - nums[i];
                //if the value of one of the values is equal to the complement return the array of both of them
                if(nums[j] == complement){
                    return new int[] {i,j};
                }
            }
        }
        //throw no match found
        throw new IllegalArgumentException("No match Found");
    }
}


 // O(n^2) for going through 2 loops.
 //Can we optimise this?


 class Solution{
    public int[] twoSum(int[] nums, int target){
        //create a hash map that stores key value pairs to hold on to memory of values
        Map<Integer, Integer> num_map = new HashMap<>();
        //loop through array once
        for(int i = 0; i < nums.length; i++){
            //store value of the complement
            int complement = target - nums[i];
            //if the hashmap has a key that is equal to the complement
            if(num_map.containsKey(complement)){
                //return the index of that complement and the index of i as an array
                return new int[]{num_map.get(complement), i};
            }
            //else store the value of i and its index in the hashmap and continue going through the array
            num_map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No Match Found");
    }
 }
//This solution has a time complexity of O(n)
//this is because we avoid using nested loops 
//we can save key value pairs and use them to speed up the complexity

 

 //We will now do TwoSum II
 //An iteration of the first twoSum
//it is sorted already, if something is sorted, think oof pointers.

class Solution{
    public int[] twoSum(int[] numbers, int target){
        //since it is sorted think of using pointers
        //one pointer starting at the beginning and one pointer starting at the end
        int a_pointer = 0;
        int b_pointer = numbers.length-1;

        //a while loop that continues for as logn as the a pointer is smaller than the b
        while(a_pointer <= b_pointer){
            //store the value of the sum of the values at the pointers
            int sum = numbers[a_pointer] + numbers[b_pointer];
            //compare this sum to the target
            if(sum == target){
                //if equal return, else, move the pointers.
                return new int[]{a_pointer + 1, b_pointer + 1};
            }
            else if(sum < target){
                a_pointer++;
            }
            else{
                b_pointer--;
            }
        }
        return new int[]{a_pointer+1, b_pointer+1};
    }
}

//3Sum
//returning triplets that add to 0
//no duplicates
//brute force solution
class Solution{
    public List<List<Integer>> threeSum(int[] nums){
        //array list to store the result
        List<List<Integer>> result = new ArrayList<>();

        //iterate through array to collect first second and third values
        for(int i = 0; i < nums.length-2; i++){
            for(int j = i+1; j < nums.length-1; j++){
                for(int k = j+1; k < nums.length; k++){
                    //check if the sum of all numbers equals o at any point
                    if(nums[i] + nums[j] + nums[k] == 0){
                        //store the triplet
                        List<Integer> triplet =  Arrays.asList(nums[i], nums[j], nums[k]);
                        //Sort to handle duplicate triplets
                        Collections.sort(triplet);
                        //avoidn adding duplicate triplets
                        if(!result.contains(triplet)){
                            //add fresh triplet to result array
                            result.add(triplet);
                        }
                    }
                }
            }
        }
        return result;
    }
}

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


//4Sum brute force solution
//O(n^4) time complexity
//too slow interating and checking for duplicates on each iteration

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target){
        //create an output array to store the solution
        List<List<Integer>> result = new ArrayList<>();
        //sort array to help with avoiding duplicates
        Arrays.sort(nums);
        //find our values
        for(int a = 0; a < nums.length-3; a++){
            //avoid duplicates
            if(a > 0 && nums[a] == nums[a-1]) continue;
            for(int b = a+1; b < nums.length-2; b++){
                if(b > a+1 && nums[b] == nums[b-1]) continue;
                for(int c = b+1; c < nums.length-1; c++){
                    if( c > b+1 && nums[c] == nums[c-1]) continue;
                    for(int d = c+1; d < nums.length; d++){
                        if(d > c+1 && nums[d] == nums[d-1]) continue;

                        long sum = (long) nums[a] + nums[b] + nums[c] + nums[d];
                        if(sum == target){
                            result.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        }
                    }
                }
            }
        }
        return result;
    }
}


//how can we optimise 4Sum?
//Similar to previous solutions we use 2 pointers

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target){
        //create an output array to store the result
        List<List<Integer>> result = new Arraylist<>();
        int size = nums.length;

        Arrays.sort(nums);

        for(int i = 0; i < size - 3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < size - 2; j++){
                if(j > i + 1 && nums[j] == nums[j-1]) continue;
                
                int left = j + 1;
                int right = size -1;

                while(left < right){
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target){
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    } else if(sum < target){
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
 

