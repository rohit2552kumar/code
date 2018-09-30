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
        int a,b;
        public IntegerPair(int a1, int a2){
            a=a1;b=a2;
        }
    }

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    static int bfs(int s, int d){

        Queue<IntegerPair> q = new LinkedList<IntegerPair>();

        q.add(new IntegerPair(s, 0));
        visited[s] = true;

        while(q.size()>0){
            IntegerPair el = q.remove();
            if(el.a==d){
                q.clear();
                return el.b;
            }

            ArrayList<Integer> curlist = (ArrayList<Integer>)graph[el.a];

            for(int cur: curlist){
                if(!visited[cur]){
                    q.add(new IntegerPair(cur, el.b+1));
                    visited[cur]=true;
                }
            }
        }

        return -1;
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            int e = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();

            graph = new ArrayList[n+1];
            visited = new boolean[n+1];

            for(int i=0;i<=n;i++)
                graph[i] = new ArrayList<Integer>();

            for(int i=0;i<e;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                graph[a].add(b);
                graph[b].add(a);
            }

            out.println( bfs(s,d) );
        }
        out.close();
    }

}
