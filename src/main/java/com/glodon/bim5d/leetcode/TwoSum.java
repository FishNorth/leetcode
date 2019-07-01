package com.glodon.bim5d.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: guanl-c
 * @date: 2019/6/29 14:28
 * @description: 两数求和:给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    public static void main(String[] args) {
        int a[] = new int[]{3, 2, 4};
        TwoSum twoSum = new TwoSum();
        twoSum.twoSum_1(a, 6);
    }

    public int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int j = target - nums[i];
            for (int k = i + 1; k < nums.length; k++) {
                if (j == nums[k]) {
                    result[0] = i;
                    result[1] = k;
                }
            }
        }
        return result;
    }

    // error：没有考虑重复值存在的情况
    public int[] twoSum_1(int[] nums, int target) {
        int result[] = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int index = 0; index < nums.length; index++) {
            if (map.get(nums[index]) == null) {
                List keyList = new ArrayList<Integer>();
                keyList.add(index);
                map.put(nums[index], keyList);
            } else {
                map.get(nums[index]).add(index);
            }
        }
        for (int index = 0; index < nums.length; index++) {
            int other = target - nums[index];
            if (map.get(other) != null) {
                if (!map.get(other).contains(index)) {
                    result[0] = index;
                    result[1] = map.get(other).get(0);
                    break;
                }
                if (map.get(other).contains(index) && map.get(other).size() > 1) {
                    result[0] = map.get(other).get(0);
                    result[1] = map.get(other).get(1);
                    break;
                }
            }
        }
        return result;
    }

    // error：没有考虑重复值存在的情况
    public int[] twoSum_2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int index = 0; index < nums.length; index++) {
            map.put(nums[index], index);
        }
        for (int index = 0; index < nums.length; index++) {
            int other = target - nums[index];
            if (map.get(other) != null && map.get(other) != index) {
                return new int[]{index, map.get(other)};
            }
        }
        throw new IllegalArgumentException();
    }

}
