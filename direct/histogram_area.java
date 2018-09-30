import java.util.*;
import java.io.*;

class Main{
    //input output
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
        }}

    //histogram value
    static int maxArea(int[] hist){
        int max = 0;
        int i=0;
        Stack<Integer> stack = new Stack<Integer>();

        while(i<hist.length){
            if(stack.empty() || ( hist[stack.peek()] <= hist[i]) ){
                stack.push(i);
                i++;
            }else{
                int tp = stack.pop();
                int area = hist[tp]*(stack.empty()? i: (tp-stack.peek()-1));
                max = Math.max(max, area);
            }
        }

        while(!stack.empty()){
            int tp = stack.pop();
            int area = hist[tp]*( stack.empty()? i:(tp-stack.peek()-1) );
            max = Math.max(area, max);
        }

        return max;}

    public static void main (String[] args) {
        //Fast input output
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int[] hist = new int[]{5,5,4,5,5,5};
        out.println(maxArea(hist));

        out.close();

    }
}
