package binary_Search;

import java.util.Arrays;

/*给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

示例 1：

输入：nums = [-4,-1,0,3,10]
输出：[0,1,9,16,100]
解释：平方后，数组变为 [16,1,0,9,100]，排序后，数组变为 [0,1,9,16,100]
示例 2：

输入：nums = [-7,-3,2,3,11]
输出：[4,9,9,49,121]
*/
public class T977 {
    public static void main(String[] args) {
        T977 jieguo = new T977();
        int[] t1 = {-5, -6, 1, 2, 8};
        int[] t2 = jieguo.solution1(t1);
        System.out.println(Arrays.toString(t2));
    }

    //普通方法
    public int[] solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];

        }
        Arrays.sort(arr);
        return arr;
    }

    // 双指针
    public int[] solution1(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int[] result = new int[arr.length];
        int index = result.length - 1;
        while (l <= r) {
            if (arr[l] * arr[l] > arr[r] * arr[r]) {
                result[index--] = arr[l] * arr[l];
                l++;
            } else {
                result[index--] = arr[r] * arr[r];
                r--;
            }
        }
        return result;
    }
}
