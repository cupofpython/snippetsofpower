import java.util.Arrays; 
import java.util.ArrayList; 
import java.util.List;
import java.util.Collections; 

// Completed. Remove duplicates from a sorted array in place
// Source: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
// Difficulty: Easy
// Runtime: Faster than 35.99% of Java submissions
// Memory: Less than 9.30% of Java submissions 
class RemoveDupes {
    public int removeDuplicates(int[] nums) {
        int i = 0; 
        int dups = 0; 
        if (nums.length == 0)
            return 0; 
        if(nums.length == 1)
            return 1;
        if(nums.length == 2 && nums[0] == nums[1])
            return 1; 
        List<Integer> numsList= new ArrayList<Integer>();  
        while(i < nums.length-1) { 
            if(nums[i] == nums[i+1]) {
                numsList.add(nums[i]); 
                while((i+1) < nums.length && nums[i] == nums[i+1]) {
                    i++;
                    dups++;  
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
        return (nums.length-dups); 
    }
}

class Solution3 {
    public static void main(String[] args) {
        RemoveDupes rd = new RemoveDupes(); 
        int[] test = {1,1,2};
        System.out.println(rd.removeDuplicates(test)); 
    }
}