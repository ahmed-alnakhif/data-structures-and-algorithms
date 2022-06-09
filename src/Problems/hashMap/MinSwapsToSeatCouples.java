package Problems.hashMap;

import java.util.HashMap;
import java.util.Map;

public class MinSwapsToSeatCouples {
    
    //wrong
    public int minSwaps(String[] row){
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < row.length; i++) {
            map.put(row[i], i);
        }

        int count = 0;
        for (int i = 0; i < row.length; i++) {
            if(map.containsKey((row[i]))){
                if(row[i] != row[i+1]){
                   swap(row, i+1, map.get(row[i]));
                   count++;
                }
                map.remove(row[i]);
            }
        }
        
        return count;
    }

    public void swap(String[] row, int i, int j){
        String temp = row[i];
        row[i] = row[j];
        row[j] = temp;
    }

    public static void main(String[] args) {
        MinSwapsToSeatCouples min = new MinSwapsToSeatCouples();
        String[] seats = {"a", "d", "c", "b", "d", "b", "c", "a"};
        System.out.println(min.minSwaps(seats));
        String[] seats2 = {"a", "c", "b", "b", "c", "a"};
        System.out.println(min.minSwaps(seats2));
    }
}
