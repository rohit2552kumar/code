import java.util.*;
import java.io.*;
// wrong
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

    public static void main (String[] args){
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while(t-->0){
            String in = sc.nextLine();
            String fi = sc.nextLine();
            int n = in.length();
            int st=0, en=0;
            for(int i=0;i<n;i++){
                if(in.charAt(i)=='_')
                    st = i;
                if(fi.charAt(i)=='_')
                    en = i;
            }

            int count=0,i=st;
            if(st<en){
                while(i!=en){
                    if(i<n-2 && in.charAt(i+1)!=in.charAt(i+2) && (i+1)!=en)
                        i++;
                    count++;
                    i++;
                }
            }else{
                while(i!=en){
                    if(i>1 && in.charAt(i-1)!=in.charAt(i-2) && (i-1)!=en)
                        i--;
                    count++;
                    i--;
                }
            }
            out.println(count);
        }

        out.close();
    }
}
