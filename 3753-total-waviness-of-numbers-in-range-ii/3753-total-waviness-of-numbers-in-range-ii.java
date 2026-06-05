class Solution{
    char[] d;
    Pair[][][] dp;

    static class Pair{
        long cnt,sum;
        Pair(long cnt,long sum){
            this.cnt=cnt;
            this.sum=sum;
        }
    }

    public long totalWaviness(long num1,long num2){
        return calc(num2)-calc(num1-1);
    }

    public long calc(long x){
        if(x<=0) return 0;

        d=String.valueOf(x).toCharArray();
        dp=new Pair[d.length][11][11];

        return dfs(0, 10, 10, true, false).sum;
    }

    public Pair dfs(int pos, int p2 ,int p1 ,boolean tight ,boolean start){
        if(pos==d.length) return start? new Pair(1,0): new Pair(0,0);

        if(!tight && start && dp[pos][p2][p1] != null)
            return dp[pos][p2][p1];

        int lim=tight? d[pos]-'0':9;
        long cnt=0,sum=0;

        for(int dig=0; dig<=lim; dig++){
            boolean nt=tight && dig==lim;

            if(!start && dig==0){

                Pair p=dfs(pos+1, 10 ,10 ,nt ,false);
                cnt+=p.cnt;
                sum+=p.sum;
                continue;
            }

            int add=0;

            if(p2!=10){
                if((p1>p2 && p1>dig) || (p1<p2 && p1<dig))
                    add=1;
            }

            int np2,np1;

            if(!start){
                np2=10;
                np1=dig;
            }
            else{
                np2=p1;
                np1=dig;
            }

            Pair p=dfs(pos+1, np2, np1, nt, true);

            cnt+=p.cnt;
            sum+=p.sum+(long)add*p.cnt;
        }

        Pair ans=new Pair(cnt,sum);

        if(!tight && start)
            dp[pos][p2][p1]=ans;

        return ans;
    }
}