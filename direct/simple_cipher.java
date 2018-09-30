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

    static void calFact(int[] fact, int n){
        fact[0]=1;
        for(int i=1;i<=n;i++){
            fact[i] = i*fact[i-1];
        }
        return;
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        int[] fact = new int[11];
        calFact(fact,10);

        while(t-->0){
            int n = sc.nextInt();
            int[] mask = new int[26];
            int[] res = new int[100];

            for(int i=1;i<=n;i++){
                String s = sc.next();
                for(int j=0;j<s.length();j++){
                    int cur = (int)(s.charAt(j)-'A');
                    int submask = mask[cur];
                    submask |= (1<<i);
                    mask[cur] = submask;
                }
            }

            for(int i=0;i<26;i++){
                res[mask[i]]++;
            }
            int count = 1;

            for(int i=1;i<100;i++){
                count *= fact[res[i]];
            }

            out.println(count);
        }
        out.close();
    }

}
