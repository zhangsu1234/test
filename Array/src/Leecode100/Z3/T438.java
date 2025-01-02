package Leecode100.Z3;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/*
* 给定两个字符串 s 和 p，找到 s 中所有 p 的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

示例 1:
输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

示例 2:
输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
*
*
*
*  静态窗口
窗口大小固定，不根据条件调整。
仅左右边界滑动，窗口的大小保持不变。
常见问题：固定长度子串、子数组等。

* */
public class T438 {
    public static void main(String[] args) {
        T438 method = new T438();
       Scanner sc=new Scanner(System.in);
       String s= sc.next();
       String p=sc.next();
        List<Integer> A = method.find(s, p);
        System.out.println(A);
    }

    public List<Integer> find(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> Pwin = new HashMap<>();
        for (char c : p.toCharArray()
        ) {
            Pwin.put(c, Pwin.getOrDefault(c, 0) + 1);

        }
        HashMap<Character, Integer> Win = new HashMap<>();
        for (int i = 0; i < p.length() - 1; i++) {
            Win.put(s.charAt(i), Win.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = p.length() - 1; i < s.length(); i++) {
            Win.put(s.charAt(i), Win.getOrDefault(s.charAt(i), 0) + 1);
            if (Win.equals(Pwin)) {
                result.add(i - p.length() + 1);
            }
            char leftChar = s.charAt(i - p.length() + 1);
            Win.put(leftChar, Win.get(leftChar) - 1);
            if (Win.get(leftChar) == 0) {
                Win.remove(leftChar);
            }
        }

        return result;
    }
}


