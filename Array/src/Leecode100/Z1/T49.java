package Leecode100.Z1;

import java.util.*;

/*
* 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
*
*
示例 1:
输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
*
示例 2:
输入: strs = [""]
输出: [[""]]
*
示例 3:
输入: strs = ["a"]
输出: [["a"]]
* */
public class T49 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String [] strs=new String[n];
        for (int i = 0; i < n; i++) {
            strs[i]= sc.next();
        }
        T49 test=new T49();

        List<List<String>> result = test.Solution(strs);

        // 输出字母异位词分组
        System.out.println("字母异位词分组为：");
        for (List<String> group : result) {
            System.out.println(group);
        }
    }



    public List<List<String>> Solution(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String strs1 = new String(chars);
            if (!map.containsKey(strs)) {
                map.put(strs1, new ArrayList<>());
            }
            map.get(strs1).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
