package howTo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utils {

    public static int getMaxInList(List<Integer> list) {
        return Collections.max(list);
    }

    public static int getMinInList(List<Integer> list) {
        return Collections.min(list);
    }

    public static int searchList(List<Integer> list, int target) {
        return Collections.binarySearch(list, target);
    }

    public static void sortList(List<Integer> list) {
        Collections.sort(list);
    }

    public static void reverseList(List<Integer> list) {
        Collections.reverse(list);
    }

    public static void rotateList(List<Integer> list, int k) {
        Collections.rotate(list, k);
    }

    public static void swap(List<Integer> list, int i, int j) {
        Collections.swap(list, i, j);
    }

    public static int frequency(List<Integer> list, int k) {
        return Collections.frequency(list, k);
    }

    public static int getTotalSum(List<Integer> list) {
        list.stream().mapToInt(Integer::intValue).sum();
        return list.stream().reduce((a, b) -> a + b).get();
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(5, 2, 1, 3, 7, 3, 4));
        System.out.println(list);
        rotateList(list, 3);
        System.out.println(list);
        System.out.println(frequency(list, 3));
    }
}
