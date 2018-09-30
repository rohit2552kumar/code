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
            int[][] arr = new int[n+1][n+1];
            int[][] dp = new int[n+1][n+1];

            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    arr[i][j] = sc.nextInt();
                }
            }

            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    dp[i][j] = arr[i][j];
                    if(i==1){
                        dp[i][j] += dp[i][j-1];
                    }
                    else if(j>i){
                        if(i==j-1)
                            dp[i][j] += dp[i-1][j];
                        else if(i-1==j)
                            dp[i][j] += dp[i][j-1];
                        else
                            dp[i][j] += Math.min(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }

            dp[n][n]+=dp[n-1][n];


            for(int i=n;i>=1;i--){
                for(int j=n;j>=1;j--){

                    if(i==n && j<n){
                        dp[i][j] += dp[i][j+1];
                    }
                    else if(i>j){
                        if(i==j+1)
                            dp[i][j] += dp[i+1][j];
                        else if(i+1==j)
                            dp[i][j] += dp[i][j+1];
                        else
                            dp[i][j] += Math.min(dp[i+1][j], dp[i][j+1]);
                    }
                }
            }

            for(int i=0;i<=n;i++){
                for(int j=0;j<=n;j++)
                    out.print(" "+dp[i][j]);
                out.println("");
            }

            if(n>=2)
                dp[1][1]+=dp[2][1];
            out.println(dp[1][1]);
        }

        out.close();
    }

}
