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
        int ans=0, max=0;
        public IntegerPair(int a, int b){
            ans = a;
            max = b;
        }
    }

    static int n;
    static int inf = Integer.MIN_VALUE;

    static int dfs(IntegerPair[] graph, int i){

        if(i>n){return inf;}

        int left = dfs(graph, 2*i);
        int right = dfs(graph, 2*i+1);

        if(right==inf && left==inf)
            return graph[i].max;

        graph[i].max += Math.max(right, left);

        right = (right==inf)?0:right;
        left = (left==inf)?0:left;

        graph[i].ans += (right+left);

        return graph[i].max;
    }

    public static void main (String[] args) {

        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-->0){
            n = sc.nextInt();
            IntegerPair[] graph = new IntegerPair[n+1];

            graph[0] = new IntegerPair(-1,-1);
            for(int i=1;i<=n;i++){
                int a = sc.nextInt();
                graph[i] = new IntegerPair(a, a);
            }

            dfs(graph, 1);

            int res = inf;
            for(int i=1;i<=n;i++){
                res = Math.max(res, graph[i].ans);
            }

            System.out.println(res);
        }
    }

}
