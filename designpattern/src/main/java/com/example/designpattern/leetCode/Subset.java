package com.example.designpattern.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: MyDemo
 * @Package: com.example.designpattern.leetCode
 * @ClassName: Subset
 * @Description: 子集
 * @Author: Grechur
 * @CreateDate: 2019/11/13 11:40
 * @UpdateUser: Grechur
 * @UpdateDate: 2019/11/13 11:40
 */
public class Subset {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = subsets(nums);
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer+" ");
            }
            System.out.println("");
        }
    }

    /**
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            int size = result.size();
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(result.get(i));
                temp.add(num);
                result.add(temp);
            }

        }

        return result;
    }
}
