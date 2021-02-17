// 不同的二叉搜索树
/**
 * 设G(n)表示长度为n的序列不同二叉搜索树的个数 设f(i,n)表示以i为根，长度为n的二叉搜索树的个数 那么我们有f(i,n) =
 * G(i-1)*G(n-i),二叉搜索树左边元素的个数i-1，右边是n-i. 对f(i,n)求前n项的和我们就可以得到g(n)的值
 */
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int j = 2; j <= n; j++) {
            for (int i = 1; i <= j; i++) {
                dp[j] += dp[i - 1] * dp[j - i];
            }
        }
        return dp[n];
    }
}