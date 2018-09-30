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

    static int maxArea(int[] hist, int n){
        int max = 0;
        int i=0;
        Stack<Integer> stack = new Stack<Integer>();

        while(i<n){
            if(stack.empty() || ( hist[stack.peek()] <= hist[i]) ){
                stack.push(i);
                i++;
            }else{
                int tp = stack.pop();
                int area = hist[tp]*(stack.empty()? i: (i-stack.peek()-1));
                max = Math.max(max, area);
            }
        }

        while(!stack.empty()){
            int tp = stack.pop();
            int area = hist[tp]*( stack.empty()? i:(i-stack.peek()-1) );
            max = Math.max(area, max);
        }

        return max;
    }

    public static void main (String[] args) {

        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[4][n+1];

            for(int i=0;i<m;i++){
                int r = sc.nextInt();
                int a = sc.nextInt();
                int b = sc.nextInt();

                arr[r][a-1] +=1;
                arr[r][b] -=1;
            }

            for(int i=1;i<4;i++){
                for(int j=1;j<n;j++){
                    arr[i][j] += arr[i][j-1];
                }
            }

            for(int i=1;i<4;i++){
                for(int j=0;j<n;j++){
                    arr[i][j] = (arr[i][j]>0)?1:0;
                }
                arr[i][n] = 0;
            }

            for(int i=1;i<4;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][j]!=0)
                        arr[i][j] += arr[i-1][j];
                }
            }


            /*for(int i=1;i<4;i++){
                for(int j=0;j<n;j++){
                    out.print(arr[i][j]+" ");
                }
                out.println("");
            }*/

            int max = 0 ;
            for(int i=1;i<4;i++){
               max = Math.max(max, maxArea(arr[i], n) );
            }
            out.println(max);
        }
        out.close();
    }

}
