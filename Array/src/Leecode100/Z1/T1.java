package Leecode100.Z1;


import java.util.HashMap;
import java.util.Scanner;



/*
* 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
你可以按任意顺序返回答案。
示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
*
示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]
*
示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]。
* */
public class T1 {
    // 方法：在数组中找到和为目标值的两个元素的下标
    public static int[] find(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // 返回答案
            }
            map.put(nums[i], i); // 将当前元素和下标存入map
        }
        return new int[0]; // 如果没有找到，返回空数组
    }

    // 主函数：处理输入输出
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        // 读取输入
        int n = sc.nextInt();  // 数组的长度
        int target = sc.nextInt();  // 目标值
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();  // 读取数组元素
        }

        // 调用find方法得到结果
        int[] result = find(nums, target);

        // 输出结果，两个下标之间用空格隔开
        System.out.println(result[0] + " " + result[1]);

        sc.close();

}}
