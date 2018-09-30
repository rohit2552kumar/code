import java.util.*;
import java.io.*;

class GFG {

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

    static List<Integer> findMinHeightTrees(int n, int[][] edges) {
         if (n == 1) return Collections.singletonList(0);

        List<HashSet<Integer>> adj = new ArrayList<HashSet<Integer>>();
        for(int i=0;i<n;i++){
            adj.add(new HashSet<Integer>());
        }

        for(int edge[] : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        ArrayList<Integer> leaves = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            int size  = adj.get(i).size();
            if(size==1){
                leaves.add(i);
            }
        }

        int tsize = n;

        while(tsize>2){

            tsize-=leaves.size();
            ArrayList<Integer> newleaves = new ArrayList<Integer>();

            for(int i:leaves){

                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if(adj.get(j).size()==1)
                    newleaves.add(j);

            }

            leaves = newleaves;
        }

        return leaves;

    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int r = sc.nextInt();

            int[][] edges = new int[n-1][2];
            int k=0;
            for(int i=0;i<n;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                if(b!=-1){
                    edges[k][0] = a-1;
                    edges[k][1] = b-1;
                    k++;
                }
                if(c!=-1){
                    edges[k][0] = a-1;
                    edges[k][1] = c-1;
                    k++;
                }
            }

            List<Integer> res = findMinHeightTrees(n, edges);
            int root = n+1;
            for(int x: res){
                root = Math.min(root, x+1);
            }

            System.out.println(root);
            return;
        }
    }
}
