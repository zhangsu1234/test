package binary_Search;

/*
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * */
public class T704 {
    public static void main(String[] args) {
        T704 rs = new T704();
        int[] a = {1, 2, 45, 49, 56, 49};
        int t = 4;
        int result = rs.solution(a, t);
        System.out.println(t + "的索引：" + result);

    }

    public int solution(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] == target) {
                return mid;
            }
        }
        return -1;
    }

}