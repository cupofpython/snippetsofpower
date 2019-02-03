import java.util.Arrays; 
import java.util.ArrayList; 
import java.util.List;
import java.util.Collections; 

// Completed. Keep at most two dupcicates in a sorted array
// Source: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
// Difficulty: Medium
// Runtime: Faster than 34.46% of Java submissions
// Memory: Less than 60.00% of Java submissions 

class RemoveDupes {
    public int removeDuplicates(int[] nums) {
        int i = 0; 
        if (nums.length == 0)
            return 0; 
        if(nums.length == 1)
            return 1;
        // up to 2 duplicates
        if(nums.length == 2 && nums[0] == nums[1])
            return 2; 
        List<Integer> numsList= new ArrayList<Integer>();  
        while(i < nums.length-1) { 
            // if duplicate
            if(nums[i] == nums[i+1]) {
                numsList.add(nums[i]);
                numsList.add(nums[i+1]);  
                while((i+1) < nums.length && nums[i] == nums[i+1]) {
                    i++;
                }
            }
            // first num unique or unique in middle
            else if ((nums[i] != nums[i+1] && i == 0) || (nums[i] != nums[i-1])) {
                numsList.add(nums[i]); 
                i++;
            }
            else {
                i++; 
            }
        }
        // unique at end
        if(nums[nums.length-1] != nums[nums.length-2]) {
            numsList.add(nums[nums.length-1]);
        }
        for(int j = 0; j < numsList.size(); j++) {
            nums[j] = numsList.get(j); 
        }
        return numsList.size(); 
    }
}

class Solution4 {
    public static void main(String[] args) {
        RemoveDupes rd = new RemoveDupes(); 
        int[] test = {1,1};
        System.out.println(rd.removeDuplicates(test)); 
    }
}