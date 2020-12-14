package xyz.xionglei.year2020.december;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode:49 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 示例:
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明:
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Day1214 {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new Solution().groupAnagrams(strs));
    }

    static class Solution{
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs == null || strs.length == 0) return null;
            Map<Integer, Map<String, List<String>>> map = new HashMap<>();
            a: for (String str: strs) {
                if (map.get(str.length()) == null) {
                    Map<String, List<String>> tempMap = new HashMap<>();
                    List<String> tempList = new ArrayList<>();
                    tempList.add(str);
                    tempMap.put(str, tempList);
                    map.put(str.length(), tempMap);
                    continue;
                }
                Map<String, List<String>> tempMap = map.get(str.length());
                for (String s1 : tempMap.keySet()) {
                    if (check(s1, str)) {
                        tempMap.get(s1).add(str);
                        continue a;
                    }
                }
                List<String> list = new ArrayList<>();
                list.add(str);
                tempMap.put(str, list);
            }

            List<List<String>> res = new ArrayList<>();
            for (Integer k: map.keySet()) {
                Map<String, List<String>> tempMap = map.get(k);
                for (String s: tempMap.keySet()) {
                    res.addAll(Collections.singleton(tempMap.get(s)));
                }
            }
            return res;
        }

        /**
         * 比较两个长度相同的字符串字符是否相同
         * @param str 字符串1
         * @param s 字符串2
         * @return true false
         */
        private boolean check(String str, String s) {
            Map<Character, Integer> map = new HashMap<>();
            // 把str的字符存入到hashMap中
            for (int i = 0; i < str.length(); i++) {
                if (!map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i), 1);
                    continue;
                }
                // 存在此字符 + 1
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == null) {
                    return false;
                }
            }
            return true;
        }


    }
}
