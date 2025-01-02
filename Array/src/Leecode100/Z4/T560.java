package Leecode100.Z4;

import java.util.HashMap;

/*
* 你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
子数组是数组中元素的连续非空序列。  ！！！得是连续
示例 1：
输入：nums = [1,1,1], k = 2
输出：2
*
示例 2：
输入：nums = [1,2,3], k = 3
输出：2
* */
public class T560 {
    public static void main(String[] args) {
        T560 method=new T560();
        int [] s={1, 2,3};
        int k=3;
        int r=method.Find(s,k);
        System.out.println(r);
    }
    public int Find(int[] s, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int result = 0;
        map.put(0,1);
        for (int num : s) {
            count += num;
            if (map.containsKey(count - target)) {
                result += map.get(count-target);
            }
            map.put(count, map.getOrDefault(count, 0) + 1);
        }
        return result;
    }
}
