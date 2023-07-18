package algorithm;

/**
 * @author Zuohaitao
 * @date 2023-02-21 20:31
 * @describe
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 */
public class Solution_67 {

//    将二进制转成十进制
//    字符串数字 - 字符串数字 = 值的数字
    /**
     * 1101 => 1*2^0 + 0*2^1 + 1*2^2 + 1*2^3 = 13
     * **/
    public static Integer Bin2Dec(String s) {
        int res = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c > '2' || c < '0') {
                throw new NumberFormatException(String.valueOf(i));
            }
            res += (c-'0') * Math.pow(2, s.length()-i-1);
        }
        return res;
    }

//    将十进制转成二进制
    /**
     * 5 => 5%2 = 2 ... 1
     *      2%2 = 1 ... 0
     *      1%2 = 0 ... 1
     *  从下往上
     * 5 = (101)2
     * */
    public static String Dec2Bin(Integer a) {
        StringBuilder res = new StringBuilder();

        if (a == 0) {
            return "0";
        }

        while (a != 0) {
            int m = a / 2;
            int n = a % 2;
            res.insert(0,n);
            a = m;
        }
        return res.toString();
    }

//    官方解答, 对应位置相加, 逢二进一, 最后反转reverse
    /**
     *      1010
     * +    1011
     *     10101
     * */
    public static String addBinary(String a, String b) {
        StringBuffer str = new StringBuffer();

        int carry = 0; //进位
        int length = Math.max(a.length(), b.length());

        for (int i = 0; i < length; i++) {
//            如果有个字符串的长度不足, n,m=0就可以充当补位, 给字符串填充0
            int n = 0, m = 0;
            if (i < a.length()) {
                n = a.charAt(a.length() - 1 - i) - '0';
            }
            if (i < b.length()) {
                m = b.charAt(b.length() - 1 - i) - '0';
            }
            carry += n + m;
            char c = (char)(carry % 2 + '0');
            str.append(c);
            carry /= 2;
        }

//        等循环到最后一位, 如果进位>0, 说明carry=1, 还得往后加1;
        if (carry > 0) {
            str.append('1');
        }
        str.reverse();

        return str.toString();
    }


    public static void main(String[] args) {
//        事实证明, 二进制转成十进制相加后, 再转成二进制的方法, 对于超长字符串不管用
//        事实上, 在 Java 中:
//          如果字符串超过33位, 不能转化为 Integer
//          如果字符串超过65位，不能转化为 Long
//          如果字符串超过500000001位，不能转化为 BigInteger
//        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
//        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
//        System.out.println(Dec2Bin(Bin2Dec(a) + Bin2Dec(b)));

        System.out.println(addBinary("1010", "1011"));


    }
}
