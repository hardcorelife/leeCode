import java.util.Arrays;

/**
 * @author qiweigang
 * @date 2019-12-19 18:00
 *
 * 版权声明：本文为CSDN博主「梅森上校」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/seagal890/article/details/79425163
 */

/*
 * 这个问题实际上是 Lagrange四平方定理，即 任何一个正整数都可以表示成不超过4个整数的平方之和。
 * dp[n] 代表表示给定整数n的平方数的数组
 *
 * 分析过程：
 * dp[0] = 0
 * dp[1] = dp[0]+1 = 1
 * dp[2] = dp[1]+1 = 2
 * dp[3] = dp[2]+1 =3
 * dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1} = Min {dp[3]+1,dp[1]+1} = 1
 * dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1} = Min {dp[4]+1,dp[1]+1} = 2
 * ....
 *
 * dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1} = Min {dp[12]+1,dp[9]+1,dp[4]+1} = 2
 *
 * 对于一般情况，推导出：
 * dp[n] = Min{dp[n-i*i]+1}, n-i*i>=0 && i>=1
 * */
public class numSquares {
    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        //初始化dp[0]为0
        dp[0] = 0;
        for(int i = 1; i <= n; ++i) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j*j >= 0) {
                min = Math.min(min, dp[i - j*j] + 1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int target=(int)(Math.random()*2000)+1;
        int ANSWER=numSquares(target);
        System.out.println(numSquares(ANSWER));;

    }
}
