import java.util.*;
import java.io.*;

class Main{
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int b = sc.nextInt();
            int[][] dp = new int[n+1][b+1];
            int[] cal = new int[n+1];
            int[] wt = new int[n+1];

            for(int i=1;i<=n;i++){
                cal[i] = sc.nextInt();
            }

            for(int i=1;i<=n;i++){
                wt[i] = sc.nextInt();
            }

            for(int i=0;i<=n;i++){
                for(int j=0;j<=b;j++){
                    if(i==0||j==0)
                        dp[i][j]=0;
                    else if(j>=wt[i])
                        dp[i][j] = Math.max( dp[i-1][j-wt[i]]+cal[i] , dp[i][j-1] );
                    else
                        dp[i][j] = dp[i-1][j];

                }
            }

            out.println( dp[n][b] );
        }
        out.close();

    }
}
