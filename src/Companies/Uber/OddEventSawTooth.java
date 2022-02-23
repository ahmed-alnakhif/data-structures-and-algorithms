package Companies.Uber;

public class OddEventSawTooth {

    public int countSawtooth(int[] nums) {
        int prevLongest = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i - 1] % 2 == 0 && nums[i] % 2 == 1) || (nums[i - 1] % 2 == 1 && nums[i] % 2 == 0)) {
                prevLongest++;
            } else {
                prevLongest = 1;
            }

            result += prevLongest;
        }

        return result;
    }

    public void run() {
        int[] nums = { 1, 2, 3, 7, 6, 5 };
        System.out.println(countSawtooth(nums));
    }
}
