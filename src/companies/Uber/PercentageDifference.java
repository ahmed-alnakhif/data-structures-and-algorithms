package Companies.Uber;

/**
 * Find the maximum percentage change between min and max numbers in an
 * unsortedarray rounded to the nearest integer.
 * 
 * eg: [2,9,15,5], the answer should be 650% (2->15 is a 650% increase)
 * eg: [78,53], the answer should be 47%
 */

public class PercentageDifference {

    public int percentageDifference(int[] nums) {
        double percentage = 0.0;
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        percentage = (max - min) / min * 100;

        return (int) percentage;
    }

    public void run() {
        int[] nums = { 2, 9, 15, 5 };
        int[] nums2 = { 78, 53 };
        System.out.println(percentageDifference(nums));
        System.out.println(percentageDifference(nums2));
    }
}
