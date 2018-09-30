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
        int val=0, ind=0;
        public IntegerPair(int a, int b){
            val = a;
            ind = b;
        }
    }

    public static void main (String[] args) {

        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();

        PriorityQueue<IntegerPair> q = new PriorityQueue<IntegerPair>(new Comparator<IntegerPair>(){
            public int compare(IntegerPair a, IntegerPair b){
                return (a.val<=b.val)?( (a.val==b.val)? ((a.ind>b.ind)?1:-1) : 1 ) : -1 ;
            }
        });

        int ball = sc.nextInt();
        for(int i=1;i<=n;i++){
            int a = sc.nextInt();
            q.add(new IntegerPair(a, i));
        }

        while(ball-->0){
            IntegerPair a = q.remove();
            out.print(a.ind+" ");
            a.val--;
            q.add(a);
        }
        out.close();

    }
}
