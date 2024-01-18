class Solution {
    int[] dp = new int[46];

    int help(int s, int n) {
        if(s>n) return 0;
        if(s==n) return 1;
        if(dp[s] != -1) return dp[s];
        dp[s] = help(s+1, n) + help(s+2, n);
        return dp[s];
    }
    public int climbStairs(int n) {
        for(int i=0; i<46; i++) dp[i] = -1;
        return help(0, n);
    }
}