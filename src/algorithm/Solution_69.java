package algorithm;

/**
 * @author Zuohaitao
 * @date 2023-02-27 20:23
 * @describe
给你一个非负整数 x ，计算并返回 x 的 算术平方根 。

由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。

注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。


 */
public class Solution_69 {

//    效率更高
    public static int mySqrt_1(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        long l = 0, r = x;
        while (l <= r) {
            long mid = (l + r)/2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return (int)r;
    }
//    更通俗易懂
    public static int mySqrt_2(int x) {
        int sqrt = 0;
        while (sqrt * sqrt < x) {
            sqrt++;
        }
        if (sqrt * sqrt == x) {
            return sqrt;
        }
        else {
            return sqrt-1;
        }
    }

    public static void main(String[] args) {
//        最后l=3, r=2. 输出2
        System.out.println(mySqrt_2(2147395600));
    }
}
