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
        if(p[x]==x)
            return x;

        return p[x] = find(p, p[x]);
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        for(int k=1;k<=t;k++){

            int n = sc.nextInt();
            int[] p = new int[100];
            int[] res = new int[100];

            for(int i=0;i<100;i++){
                p[i] = i;
                res[i] = -1;
            }

            for(int i=0;i<n;i++){
                char[] pair = sc.nextLine().toCharArray();
                int a = (int)(pair[0]-'0');
                int b = (int)(pair[2]-'0');
                int pa = find(p, a);
                int pb = find(p, b);

                if(b>=1 && b<=9){
                    res[pa] = b;
                }
                else if(pa==pb){
                    res[pa]=0;
                }
                else{
                    p[pa]=pb;
                }
            }
            for(int i=0;i<100;i++){
                res[i] = res[find(p,i)];
            }

            int m = sc.nextInt();

            out.println("#"+k);
            while(m-->0){
                String decrp = sc.nextLine();
                StringBuilder resNum = new StringBuilder();

                for(int i=0;i<decrp.length();i++){
                    int ci = (int)(decrp.charAt(i)-'0');
                    int val = res[ci];
                    if(val==-1){
                        resNum = new StringBuilder("-1");
                        break;
                    }
                    resNum.append(""+val);
                }

                out.println(resNum);
            }

        }

        out.close();
    }

}
