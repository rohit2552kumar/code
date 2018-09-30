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

        int n = sc.nextInt();
        int[] arr = new int[n+1];

        for(int i=1;i<=n;i++)
            arr[i] = sc.nextInt();

        int bud = sc.nextInt();
        int[][] dp = new int[n+1][bud+1];

        for(int i=0;i<=n;i++)
            dp[i][0]=0;

        for(int i=0;i<=bud;i++)
            dp[0][i]=-1;

        for(int i=0;i<=bud;i++)
        {
            if(arr[1]==i)
                dp[1][i]=1;
            else
                dp[1][i]=-1;
        }

        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<=bud;j++)
            {
                dp[i][j]=dp[i-1][j];
                if(arr[i]<=j)
                {
                    if(dp[i-1][j-arr[i]]!=-1)
                        dp[i][j]=Math.max(dp[i][j],1+dp[i-1][j-arr[i]]);
                }
            }
        }
/*
        for(int i=0;i<=n;i++){
            for(int j=0;j<=b;j++)
                cout<<dp[i][j]<<" ";
            cout<<"\n";
        }
*/
        out.println((dp[n][bud]!=-1)?dp[n][bud]:-1);
        out.close();
    }

}
