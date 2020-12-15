package xyz.xionglei.year2020.december;

import java.util.ArrayList;
import java.util.Arrays;
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
        System.out.println(new Solution().groupAnagramsReferenceAnswer1(strs));
        System.out.println(new Solution().groupAnagramsReferenceAnswer2(strs));
    }

    static class Solution{

        // my answer just so so
        public List<List<String>> groupAnagrams(String[] strs) {
            // 返回值
            List<List<String>> res = new ArrayList<>();
            if (strs == null || strs.length == 0) return res;
            // 记录每一个字符串中各个字符的个数
            List<Map<Character, Integer>> mapList = new ArrayList<>();
            a: for (String str: strs) {
                Map<Character, Integer> map = new HashMap<>();
                for (int i = 0; i < str.length(); i++) {
                    Character c = str.charAt(i);
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                    } else {
                        map.put(c, 1);
                    }
                }
                // 将该字符串生成的map与其他的进行比较
                for (int i = 0; i < mapList.size(); i++) {
                    // 两个map相等, 则map舍弃, 字符存添加到res对应的list下
                    if (map.equals(mapList.get(i))) {
                        res.get(i).add(str);
                        continue a;
                    }
                }
                // 不相等需要添加mapList和res
                mapList.add(map);
                List<String> list = new ArrayList<>();
                list.add(str);
                res.add(list);
            }
            return res;
        }



//      tip: 模式识别 一旦需要根据特征进行归类, 就应该想到散列表.
//      Reference answer 参考答案

        // 方法一: 排序
        // time: O(NKlog(K))
        // 遍历单词: O(N)
        // 排序字符: O(Klog(K))
        // space: O(NK)
        public List<List<String>> groupAnagramsReferenceAnswer1(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str: strs) {
                char[] characters = str.toCharArray();
                Arrays.sort(characters);
                String key = new String(characters);
                List<String> list = map.getOrDefault(key, new ArrayList<String>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<>(map.values());
        }

        // 方法一: 计数
        // time: O(NK)
        // 遍历单词: O(N)
        // 计数: O(K)
        // space: O(NK)
        public List<List<String>> groupAnagramsReferenceAnswer2(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            int[] count = new int[26];
            for (String str: strs) {
                Arrays.fill(count, 0);
                // 记录每个字符的使用个数
                for (int i = 0; i < str.length(); i++) {
                    count[str.charAt(i) - 'a']++;
                }
                // 制造key
                StringBuilder sb = new StringBuilder("");
                for (int i: count) {
                    sb.append("#").append(i);
                }
                String key = sb.toString();
                List<String> list = map.getOrDefault(key, new ArrayList<>());
                list.add(str);
                map.put(key, list);
            }
            return new ArrayList<>(map.values());
        }
    }
}
