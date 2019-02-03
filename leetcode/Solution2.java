import java.util.Arrays; 
import java.util.ArrayList; 
import java.util.List;
import java.util.Collections; 

class WaterContainer {
    public int maxArea(int[] height) {
        List<Integer> heights = new ArrayList<Integer>();
        List<Integer> areas = new ArrayList<Integer>();
        for (int i : height) {
            heights.add(i); 
        }
        for(int i = 0; i < heights.size(); i++) {
            int h1 = heights.get(i);
            int w = 0; 
            for(int j = i+1; j < heights.size(); j++) {
                w++; 
                int h2 = heights.get(j);
                areas.add(Math.min(h1, h2)*w); 
            }
        }
        return Collections.max(areas);
    }
}

class Solution2 {
    public static void main(String[] args) {
        WaterContainer wc = new WaterContainer(); 
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(wc.maxArea(height)); 
    }
}