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

    static int lcm(int a, int b){
        return (a*b)/gcd(a,b);
    }

    static int gcd(int a, int b){
        if(a==0)
            return b;
        return gcd(b%a, a);
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            int[] p = new int[n+1];
            int[] arr = new int[n+1];
            boolean zero = true;

            for(int i=1;i<=n;i++){
                p[i] = i;
                arr[i] = sc.nextInt();
                if(i!=arr[i]) zero=false;
            }

            if(zero){
                out.println(0);
                continue;
            }

            for(int i=1;i<=n;i++){
                int pa = find(p, i);
                int pb = find(p, arr[i]);

                if(pa!=pb){
                    p[pa]=pb;
                }

            }

            for(int i=1;i<=n;i++){
                int pa = find(p, i);
                p[i] = pa;
            }

            /*
            for(int i=1;i<=n;i++)
                out.print(" "+p[i]);
            out.println("");
            */

            int[] res = new int[110];
            for(int i=1;i<=n;i++){
                res[p[i]]++;
            }

            int ans=1; boolean fg = true;
            for(int i=1;i<110;i++)
                if(res[i]!=0){
                    if(fg){
                        ans = res[i];
                        fg = false;
                    }
                    ans = lcm(ans, res[i]);
                }

            out.println(ans);
        }
        out.close();
    }

}
