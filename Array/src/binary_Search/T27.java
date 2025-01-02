package binary_Search;

/*给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。

元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。

示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。*/
public class T27 {
    public static void main(String[] args) {
int[] ar1={1,2,3,4,5,4,5,4,6};
int val=6;
int jieguo=Solution1(ar1,val);
        System.out.println(jieguo);

    }

    /*暴力法*/
    public static int Solution(int[] arr, int val) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == val) {
                for (int j = i; j < len; j++) {
                    arr[j - 1] = arr[j];
                }
                len--;
                i--;
            }
        }
        return len;
    }


/*
* 双指针
 */
    public static  int Solution1(int [] arr,int val){
        int slowindex=0;
        for (int fastindex = 0; fastindex < arr.length; fastindex++) {
            if(arr[fastindex]!=val){
                arr[slowindex]=arr[fastindex];
                slowindex++;
            }

        }  return slowindex;
    }
}

