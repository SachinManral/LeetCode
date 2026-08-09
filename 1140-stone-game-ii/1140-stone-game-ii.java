class Solution {
    int n;
    Integer[][][] dp;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new Integer[2][n+1][n+1];

        return solveForAlice(piles, 1, 0, 1);    // person, idx, M
    }

    public int solveForAlice(int[] piles, int person, int idx, int m){
        if(idx>=n) return 0;

        if(dp[person][idx][m]!=null) return dp[person][idx][m];

        int res=(person==1)?-1:Integer.MAX_VALUE;
        int stones=0;

        for(int i=1; i<=Math.min(n-idx, 2*m); i++){
            stones+=piles[idx+i-1];

            if(person==1){   //alice
                res = Math.max(res, stones+solveForAlice(piles, 0, idx+i, Math.max(i,m)));
            }else {      //bob
                res = Math.min(res, solveForAlice(piles, 1, idx+i, Math.max(i, m)));
            }
        }

        return dp[person][idx][m]=res;
    }
}