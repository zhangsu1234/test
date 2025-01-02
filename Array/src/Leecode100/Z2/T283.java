package Leecode100.Z2;
/*
* /*
283. 移动零
简单
相关标签
相关企业
提示
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

请注意 ，必须在不复制数组的情况下原地对数组进行操作。

示例 1:
输入: nums = [0,1,0,3,12]
输出: [1,3,12,0,0]

示例 2:
输入: nums = [0]
输出: [0]
* */

import java.util.Scanner;
public class T283 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]= sc.nextInt();
        }
        T283 test=new T283();
        test.Solution(nums);
        for (int num:nums) {
            System.out.print(num+"  ");

        }
    }
    public void Solution(int[] nums) {
        int slow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != slow) {
                    int temp = nums[slow];
                    nums[slow] = nums[i];
                    nums[i] = temp;
                }
                slow++;
            }
        }
    }
}
