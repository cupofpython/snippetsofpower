import java.util.Arrays; 
import java.util.ArrayList; 
import java.util.List;

class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        List<Integer> numsList = new ArrayList<Integer>();
        for (int i : nums) {
        	numsList.add(i); 
        }
        for(int i = 0; i < numsList.size(); i++) {
        	int val = target - numsList.get(i);
        	int idx = numsList.indexOf(val);
        	if(idx != -1 && idx != i)
        		return new int[] {i, idx};
        }
        // never reach
        return nums; 
    }
}

class Solution1 {
	public static void main(String[] args) {
		TwoSum ts = new TwoSum(); 
    	int[] nums = {3,2,4};
    	int target = 6; 
		System.out.println(Arrays.toString(ts.twoSum(nums, target)));
	}
}