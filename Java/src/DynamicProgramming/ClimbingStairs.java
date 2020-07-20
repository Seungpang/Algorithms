package DynamicProgramming;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStaris(n));
    }
    public static int climbStaris(int n){
        int[] dp = new int[n+1];
        if(n==1) return 1;
        if(n==2) return 2;
        dp[0] =2;
        dp[1] =1;
        dp[2] =2;
        for(int i=3; i<=n; i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
