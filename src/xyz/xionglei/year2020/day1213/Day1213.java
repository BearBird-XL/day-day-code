package xyz.xionglei.year2020.day1213;

/**
 * 兴业数金2021校招题目:
 * 输入一段字符串, 输出二进制表达与16进制表达,中间用","分隔。输入数字最大不能超过两个字节表示的二进制数。
 * 数字超限返回"NUM_ERROR", 输入的不是数字返回"INPUT_ERROR"
 * <p>
 * 提示:
 * 输入: 16
 * 输出: 0000000000010000,0010
 */
public class Day1213 {

    public static void main(String[] args) {
        String number = "-1";
        System.out.println(new Solution().getBinaryAndHexadecimal(number));
    }

    static class Solution {

        public String getBinaryAndHexadecimal(String number) {
            StringBuilder resPrefix = new StringBuilder();
            StringBuilder resSuffix = new StringBuilder();
            try {
                int num = Integer.parseInt(number);
                if (num > Short.MAX_VALUE || num < Short.MIN_VALUE) {
                    return "NUM_ERROR";
                }
                // 由于是只要16个字节, 循环16即可
                int hexSum = 0; // 一个16进制数的10进制表示
                int power = 0; // 幂
                for (int i = 0; i < 16; i++) {
                    // 记录二进制位
                    resPrefix.insert(0, (num & 1));
                    // 记录16进制位
                    hexSum += (num & 1) * Math.pow(2, power++);
                    // 16进制以四个字节为分割
                    if (power == 4) {
                        resSuffix.insert(0, this.getHexString(hexSum));
                        power = 0;
                        hexSum = 0;
                    }
                    num >>>= 1;
                }
                return resPrefix + "," + resSuffix;
            } catch (NumberFormatException e) {
                return "INPUT_ERROR";
            }
        }

        /**
         * 获取单个数字16进制的字符串表达
         *
         * @param num 数字
         * @return 字符串
         */
        private String getHexString(int num) {
            if (num < 0 || num > 15) return null;
            if (num >= 10) {
                switch (num) {
                    case 10:
                        return "A";
                    case 11:
                        return "B";
                    case 12:
                        return "C";
                    case 13:
                        return "D";
                    case 14:
                        return "E";
                    case 15:
                        return "F";
                }
            }
            return String.valueOf(num);
        }
    }
}
