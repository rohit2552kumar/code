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

    static int findFirst(StringBuilder s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='b') return i;
        }
        return s.length();
    }

    static String swapString(StringBuilder s, int st , int end){
        StringBuilder temp1 = new StringBuilder(s.substring(st, end));
        StringBuilder temp2 = new StringBuilder(s.toString());

        temp1.reverse();

        return (temp2.replace(st, end, temp1.toString())).toString();
    }

    public static void main (String[] args){
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while(t-->0){
            String str = sc.nextLine();
            StringBuilder s = new StringBuilder(str);
            int firstindex = findFirst(s);

            String ans = str;
            int res = 0;

            for(int i=s.length();i>0 && i>firstindex ;i--){

                if(s.charAt(i-1)=='b')
                    continue;

                String cur = swapString(s, firstindex, i);
                //System.out.println(cur+" "+i);
                if(cur.compareTo(ans)<0){
                    ans = cur;
                    res = i-1;
                }
            }
            if(firstindex==s.length()){
                res = 0;
                firstindex = 0;
            }
            out.println(firstindex+","+res);
        }

        out.close();
    }

}
