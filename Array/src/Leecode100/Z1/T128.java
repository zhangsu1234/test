package Leecode100.Z1;
/*
* 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
* 输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
* */

import java.util.HashSet;
import java.util.Scanner;

public class T128 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];

        for (int i = 0; i < n; i++) {
          nums[i] = sc.nextInt();
        }

        // 创建实例并调用Solution方法
        T128 t128 = new T128();
        int result = t128.Solution(nums);
        System.out.println(result);  // 输出最长序列的长度
    }


    public int Solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxlen = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int newnum = num;
                int newlen = 1;
                while (set.contains(newnum + 1)) {
                    newnum++;
                    newlen++;
                }
                maxlen = Math.max(maxlen, newlen);
            }

        }
        return maxlen;
    }
}
