package algorithm;

/**
 * @author Zuohaitao
 * @date 2023-04-13 9:20
 * @describe
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class Solution_070 {

    /**
     * 动态规划: f(x) = f(x-1) + f(x-2)
     * 爬到第x级台阶的方案数是爬到第 x−1 级台阶的方案数和爬到第 x−2 级台阶的方案数的和。
     * 爬第0阶的方案数是1, f(0) = 1; 爬第1阶的方案数是1, f(1) = 1; 爬第2阶的方案数是2, f(2) = 2;
     * @param n
     * @return
     */

//    1-递归, 超出时间限制
    public static int climbStairs_1(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs_1(n-1) + climbStairs_1(n-2);
    }
//    2-迭代
    public static int climbStairs_2(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs_1(5));
        System.out.println(climbStairs_2(5));
    }
}
