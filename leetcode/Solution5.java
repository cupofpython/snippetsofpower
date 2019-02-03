import java.util.Arrays; 

// Source: https://leetcode.com/problems/median-of-two-sorted-arrays/
// Difficulty: Hard
// Runtime: Faster than 6.57%  of Java submissions
// Memory: Less than 17.47% of Java submissions 

class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length; 
        int[] comb = new int[len]; 
        for(int i = 0; i < nums1.length; i++) {
            comb[i] = nums1[i]; 
        }
        int j = nums1.length; 
        for(int i = 0; i < nums2.length; i++) {
            comb[j] = nums2[i];
            j++; 
        }
        Arrays.sort(comb);
        // odd length
        if(comb.length % 2 == 1) {
            int mid = ((comb.length)-1)/2;
            return comb[mid]; 
        }
        // even length
        else {
            int mid1 = ((comb.length/2)-1);
            int mid2 = mid1+1; 
            return ((double)comb[mid1]+comb[mid2])/2;
        }
    }
}

class Solution5 {
    public static void main(String[] args) {
        Median med = new Median(); 
        int[] t1 = {1,9,10,11,12,25};
        int[] t2 = {2,4,7,12,13};
        double median = med.findMedianSortedArrays(t1, t2);
        assert median == 10 : "Fail"; 
        System.out.println("Test Case: " + median); 
    }
}