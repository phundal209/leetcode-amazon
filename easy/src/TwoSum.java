import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 7, 11, 15};
        int[] nums2 = new int[]{3, 2, 4};
        int[] nums3 = new int[]{3, 3};

        int[] output1 = twoSumEnhanced(nums1, 9);
        int[] output2 = twoSumEnhanced(nums2, 6);
        int[] output3 = twoSumEnhanced(nums3, 6);

        printOutput(output1);
        System.out.println();
        printOutput(output2);
        System.out.println();
        printOutput(output3);
    }

    public static void printOutput(int[] output) {
        System.out.print("[" + output[0] + ", " + output[1] + "]");
    }

    /**
     * A simple O(N^2) solution, where you go through the array and check the pair
     * combinations to see if there are any that sum up to the target.
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * An enhanced version of the O(N^2) algorithm, this optimization
     * uses O(N) space by hashing the numbers and their locations in a map.
     *
     * As we iterate through the loop, we check if the difference already exists
     * as a key (a number) in our map. If so, this means at some point in time
     * we had found a number, which if added to the current number, would account
     * for the target value.
     */
    public static int[] twoSumEnhanced(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = Math.abs(nums[i] - target);
            if (map.containsKey(difference)) {
                result[0] = i;
                result[1] = map.get(difference);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void printMap(Map<Integer, Integer> map) {
        for (Integer i : map.keySet()) {
            System.out.println("[" + i + ", " + map.get(i) + "]");
        }
    }
}
