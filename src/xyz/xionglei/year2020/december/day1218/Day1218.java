package xyz.xionglei.year2020.december.day1218;

/**
 * leetcode 389 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * 请找出在 t 中被添加的字母。
 * 示例 1：
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 *  
 * 提示：
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 */
public class Day1218 {

    public static void main(String[] args) {
        String s = "ae";
        String t = "aec";
        System.out.println(new Solution().findTheDifference(s, t));
        System.out.println(new Solution().findTheDifferenceReference1(s, t));
        System.out.println(new Solution().findTheDifferenceReference2(s, t));
        System.out.println(new Solution().findTheDifferenceReference3(s, t));
    }
}
