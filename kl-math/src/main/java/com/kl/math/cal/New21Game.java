package com.kl.math.cal;

/**
 * @author: 18060903(iTeller_zc)
 * date:2020/6/3 9:12
 * description:
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。
 * 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。
 * 每次抽取都是独立的，其结果具有相同的概率。当爱丽丝获得不少于 K 分时，她就停止抽取数字。
 * 爱丽丝的分数不超过 N 的概率是多少？
 * 示例 1：
 * 输入：N = 10, K = 1, W = 10 输出：1.00000
 * 说明：爱丽丝得到一张卡，然后停止。
 * 示例 2：
 * 输入：N = 6, K = 1, W = 10 输出：0.60000
 * 说明：爱丽丝得到一张卡，然后停止。在 W = 10 的 6 种可能下，她的得分不超过 N = 6 分。
 * 示例 3：
 * 输入：N = 21, K = 17, W = 10 输出：0.73278
 * 提示：
 * 0 <= K <= N <= 10000
 * 1 <= W <= 10000
 * 如果答案与正确答案的误差不超过 10^-5，则该答案将被视为正确答案通过。
 * 此问题的判断限制时间已经减少。
 */
public class New21Game {

    public static void main(String[] args) {
        int n = 21;
        int k = 17;
        int w = 10;
        System.out.println(cal(n, k, w));
    }

    private static double cal(int N, int K, int W) {
        // 先判断 K - 1 + W 是否在 N 的里面，如果在的话，说明肯定能赢得游戏，返回 1.0，也就是 100%
        if (N - K + 1 >= W) {
            return 1.0;
        }
        double[] dp = new double[K + W];
        // 将能赢得游戏的点数的概率设置为 1
        for (int i = K; i <= N; i++) {
            dp[i] = 1.0;
        }
        // 计算K + W 这几个点数的概率和
        double sumProb = N - K + 1;
        // 从 K - 1 开始计算，
        for (int i = K - 1; i >= 0; i--) {
            // 点数为 i 的赢得游戏的概率为 i + 1 ~ i + W 的概率和除以 W
            dp[i] = sumProb / W;
            sumProb = sumProb - dp[i + W] + dp[i];
        }

        return dp[0];
    }
}
