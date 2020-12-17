package xyz.xionglei.year2020.december.day1216;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * leetcode: 290 单词规律
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * 示例1:
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 *
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class Solution {

    // reference answer
    public boolean wordPattern(String pattern, String s) {
        String[] strArr = s.split(" ");
        if (strArr.length != pattern.length()) return false;
        Map<Character, String> ch2StrMap = new HashMap<>();
        Map<String, Character> strCh2Map = new HashMap<>();
        for (int i = 0; i < strArr.length; i++) {
            Character ch = pattern.charAt(i);
            String str = strArr[i];
            if (ch2StrMap.containsKey(ch) && !Objects.equals(ch2StrMap.get(ch), str) || !Objects.equals(strCh2Map.get(str), ch)) {
                return false;
            }
            ch2StrMap.put(ch, str);
            strCh2Map.put(str, ch);
        }
        return true;
    }
}
