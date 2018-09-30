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
    static ArrayList<Integer>[] graph;
    static int[] val;
    static int count, inf=Integer.MAX_VALUE;

    static int dfs(int u, int p){

        ArrayList<Integer> curlist = graph[u];
        int pvl = inf;
        boolean fg = true;

        if(curlist.size()==1) {
            count++;
            return val[u];
        }

        for(int cur: curlist){
            if(cur!=p){
                int vl = dfs(cur, u);
                pvl = (pvl==inf)?vl:pvl;

                if(vl!=pvl || vl==inf)
                    fg = false;

                pvl = vl;
            }
        }

        int res = fg?((pvl==val[u])?val[u]:inf):inf;
        if(res==val[u]) count++;

        return res;
    }

    public static void main (String[] args){
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        graph = new ArrayList[n+1];
        val = new int[n+1];
        for(int i=0;i<=n;i++)
            graph[i] = new ArrayList<Integer>();

        for(int i=1;i<=n;i++){
            val[i] = sc.nextInt();
        }

        for(int i=1;i<n;i++){
            int a = sc.nextInt()+1;
            int b = sc.nextInt()+1;
            graph[a].add(b);
            graph[b].add(a);
        }
        graph[1].add(0);

        /*for(int i=0;i<=n;i++){
            out.println(i+"--"+graph[i]);
        }*/

        count=0;
        dfs(1, 0);
        out.println(count);

        out.close();
    }
}
