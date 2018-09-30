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

        int tt = sc.nextInt();

        while(tt-->0){
            double ve = sc.nextDouble();
            double vy = sc.nextDouble();
            double l = sc.nextDouble();
            double t = sc.nextDouble();

            double ans = 1.0/ve;
            ans = ans- 1.0/(ve+vy);
            ans = ans*l;
            ans = ans/t;

            if(ans>1.0)
                ans=1.0;
            out.printf("%.7f\n",ans);
        }
        out.close();
    }

}
