package Leecode100.Z4;

import java.util.HashMap;

/*

提示
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

注意：

对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。
输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
* */
public class T76_hard {
    public static void main(String[] args) {
        T76_hard method=new T76_hard();
        String  s="ADOBECODEBANC";
        String t= "ABC";
        String result= method.Find(s,t);
        System.out.println(result);
    }
    public String Find(String s,String t){
        HashMap<Character,Integer> tmap=new HashMap<>();
        for (char c:t.toCharArray()) {
         tmap.put(c,tmap.getOrDefault(c,0)+1);
        }
        int left=0;
        int right=0;
        int start=0;
        int minLen=Integer.MAX_VALUE;
        int daxiao=0;
        HashMap<Character,Integer> smap=new HashMap<>();
        while (right<s.length()){
            smap.put(s.charAt(right),smap.getOrDefault(s.charAt(right),0)+1);
            if(tmap.containsKey(s.charAt(right))&&smap.get(s.charAt(right))<=tmap.get(s.charAt(right))){
                daxiao++;
            }
            right++;
            while (daxiao==t.length()) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                smap.put(s.charAt(left), smap.get(s.charAt(left)) - 1);
                if (tmap.containsKey(s.charAt(left)) && smap.get(s.charAt(left)) < tmap.get(s.charAt(left))) {
                    daxiao--;
                }
                left++;
            }
        }
        return minLen ==Integer.MAX_VALUE?"":s.substring(start, start + minLen);
    }

}
