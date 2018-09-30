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

    static int[][] dp;
    static String a, b;

    static int lcs(int m, int n){
        if(m<0||n<0) return 0;

        if(dp[m][n]!=-1) return dp[m][n];

        int ans=0;
        if(a.charAt(m)==b.charAt(n))
            ans = (((int)a.charAt(m))-48) + lcs(m-1, n-1);
        else
            ans = Math.max( lcs(m-1,n) , lcs(m,n-1) );

        return dp[m][n]=ans;
    }

    public static void main(String[] args){
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while(t-->0){
            a = sc.nextLine();
            b = sc.nextLine();

            dp = new int[a.length()][b.length()];
            for(int i=0;i<a.length();i++){
                for(int j=0;j<b.length();j++){
                    dp[i][j] = -1;
                }
            }

            int sum=0;
            for(int i=0;i<a.length();i++)
                sum += (int)(a.charAt(i)-48);

            for(int i=0;i<b.length();i++)
                sum += (int)(b.charAt(i)-48);

            int ans= sum - (2 * lcs(a.length()-1, b.length()-1));
            out.println(ans);
        }
        out.close();
    }
}
