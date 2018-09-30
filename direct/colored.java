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

    static class IntegerPair{
        int a=0, b=0;
        public IntegerPair(int a1, int a2){
            a=a1;b=a2;
        }
    }
    static HashMap<Integer, ArrayList<IntegerPair>> map;
    static int dp[][];
    static int ninf = Integer.MIN_VALUE;

    static int solveDP(int n, int p){
        if(n==0) return 0;

        if(dp[n][p]!=-1){
            return dp[n][p];
        }

        ArrayList<IntegerPair> curlist = map.get(n);
        int ans = ninf;
        for(IntegerPair cur : curlist){
            if(cur.a!=p)
                ans = Math.max(ans, cur.b + solveDP(n-1,cur.a));
        }

        return dp[n][p]=ans;
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            map = new HashMap<Integer, ArrayList<IntegerPair>>();
            dp = new int[n+1][10];

            for(int i=0;i<m;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                ArrayList<IntegerPair> pr = map.get(a);
                if(pr==null) pr = new ArrayList<IntegerPair>();
                pr.add(new IntegerPair(b, c));
                map.put(a, pr);
            }

            for(int i=0;i<=n;i++){
                for(int j=0;j<=9;j++){
                    dp[i][j] = -1;
                }
            }

            int res = solveDP(n, 9);
            out.println((res<0)?-1:res);
        }

        out.close();
    }

}
