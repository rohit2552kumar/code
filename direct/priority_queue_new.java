import java.util.*;
import java.io.*;

public class Main{

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
        int a,b,c;
        public IntegerPair(int a1, int a2, int a3){
            a=a1;b=a2;c=a3;
        }
        public int getA(){
            return -1*a;
        }
        public int getB(){
            return -1*b;
        }
        public int getC(){
            return -1*c;
        }
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);



        PriorityQueue<IntegerPair> pq = new PriorityQueue<>(Comparator.comparingInt(IntegerPair::getA)
                                        .thenComparingInt(IntegerPair::getB)
                                        .thenComparingInt(IntegerPair::getC));


        pq.add(new IntegerPair(1,9,1));
        pq.add(new IntegerPair(1,9,2));
        pq.add(new IntegerPair(2,3,1));
        pq.add(new IntegerPair(3,3,2));
        pq.add(new IntegerPair(1,5,3));
        pq.add(new IntegerPair(1,0,3));
        pq.add(new IntegerPair(1,0,2));
        pq.add(new IntegerPair(1,0,0));

        while(pq.size()>0){
            IntegerPair el = pq.remove();
            out.println(el.a+" "+el.b+" "+el.c);
        }

        out.close();
    }
}
