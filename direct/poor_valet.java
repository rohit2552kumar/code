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

    static int find(int[] p, int x){
        return (p[x]==x)?x:find(p, p[x]);
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n+1];
            int[] p = new int[n+1];

            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                p[i] = i;
            }

            for(int i=0;i<n;i++){
                int pa = find(p, i);
                int pb = find(p, arr[i]);

                if(pa!=pb){
                    p[pa]=pb;
                }
            }

            for(int i=0;i<n;i++){
                p[i] = find(p, i);
            }

            int[] res = new int[n+1];

            for(int i=0;i<n;i++){
                res[p[i]]++;
            }

            int count=0;
            for(int i=0;i<=n;i++){
                if(res[i]>1)
                    count+=res[i]+1;
            }

            out.println((count<0)?-1:count);
        }

        out.close();
    }

}
