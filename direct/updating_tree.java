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

    static class LongPair{
        long ans=0, root=0, child=0;
        public LongPair(long a, long b, long c){
            ans = a;
            root = b;
            child = c;
        }
    }

    static ArrayList<Integer>[] graph;
    static LongPair[] value;
    static int n;

    static LongPair dfs(int u, int p){

        ArrayList<Integer> curlist = graph[u];

        if(curlist.size()==1)
            return value[u];

        LongPair res = value[u];
        for(int cur : curlist){
            if(cur!=p){
                LongPair ch = dfs(cur, u);
                res.child += (ch.ans+ch.child);
                res.root += ch.root;
                res.ans += ch.root;
            }
        }

        return res;
    }

    public static void main (String[] args) {

        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while(t-->0){
            n = sc.nextInt();
            int m = sc.nextInt();
            int q = sc.nextInt();

            graph = new ArrayList[n+1];
            value = new LongPair[n+1];

            for(int i=0;i<=n;i++){
                graph[i] = new ArrayList<Integer>();
                value[i] = new LongPair(0L, 0L, 0L);
            }

            for(int i=1;i<=n;i++){
                int a = sc.nextInt();
                graph[a].add(i);
                graph[i].add(a);
            }

            for(int i=0;i<m;i++){

                String op = sc.next();
                int node = sc.nextInt();
                long nodev = sc.nextLong();
                //System.out.println(op+"--"+node+"--"+nodev);

                if(op.equals("ADD")){
                    value[node].ans += nodev;
                }
                else if(op.equals("ADDUP")){
                    value[node].root += nodev;
                    value[node].ans += nodev;
                }

            }


            /*for(int i=0;i<=n;i++){
                System.out.println(value[i].ans+"-"+value[i].child+"-"+value[i].root);
            }
            System.out.println("\n\ngraph\n\n");
            for(int i=0;i<=n;i++){
                System.out.println(i+"--"+graph[i]);
            }*/


            dfs(1, 0);
            for(int i=0;i<q;i++){
                String op = sc.next();
                int node = sc.nextInt();

                if(op.equals("VAL")){
                    out.println(value[node].ans);
                }
                else if(op.equals("VALTREE")){
                    out.println((value[node].ans+value[node].child));
                }
            }
        }
        out.close();
    }

}
