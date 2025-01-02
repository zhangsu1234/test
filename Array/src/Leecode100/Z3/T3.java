package Leecode100.Z3;

import java.util.*;


/*
* 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。



示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
 1. 动态窗口
窗口大小可变，根据某些条件动态调整。
左右边界根据约束条件滑动，可能会缩小或扩大。
常见问题：最长子串、最小子串、滑动窗口最大/最小值等。
* */
public class T3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       String s= sc.next();
        T3 method = new T3();
        int result = method.find(s);

        // 输出结果
        System.out.println(result);
    }
    public int find(String s) {
        int left=0;
        int maxlen=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            if(map.containsKey(s.charAt(right)))
            {
                left=Math.max(left,map.get(s.charAt(right)) +1);   //防止出现回退现象
            }
            map.put(s.charAt(right),right);
            maxlen = Math.max(maxlen,right- left + 1);

        }
return  maxlen;
    }

}
