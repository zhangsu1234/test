package binary_Search;
/*给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。

示例：

输入：s = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的子数组。
提示：

1 <= target <= 10^9
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
*/
// 滑动窗口
public class T209 {
    public static void main(String[] args) {
        T209 method=new T209();
        int ta=7;
        int[] n1={2,3,1,2,4,3};
        int re=method.find(ta,n1);
        System.out.println(re);
    }
    public int find(int targe,int[] num){
        int n=num.length;
        int left=0;
        int sum=0;
        int minl=Integer.MAX_VALUE;
        for (int right = 0; right < n; right++) {
            sum=sum+num[right];
            while (sum>=targe){
                minl=Math.min(right-left+1,minl);
                sum=sum-num[left];
                left++;
            }

        }
        return minl==Integer.MAX_VALUE?0:minl;
    }
}
