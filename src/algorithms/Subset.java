package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
       
        result.add(new ArrayList<>());
        if(nums.length == 0){
            return result;
        }
       
        for(int num : nums){
            int size = result.size();
            for(int i = 0; i<size; i++){
                List<Integer> set = new ArrayList<>(result.get(i));
                set.add(num);
                result.add(set);
            }
        }
        return result;
    }

    public void run(){
        int[] nums = {1, 2, 3};
        System.out.println(nums);
    }
}
