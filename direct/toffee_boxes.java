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

    static boolean check(int[] arr, int val, int m){
        int count =1, sum = 0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]>val)
                return false;
            else if((sum+arr[i])>val){
                count++;
                sum=arr[i];
                if(count>m){
                    return false;
                }
            }
            else{
                sum += arr[i];
            }
        }

        return true;
    }

    static int binarySearch(int[] arr, int l, int r, int m){
        if(arr.length < m)
            return -1;

        int res=Integer.MAX_VALUE;
        while(l<=r){
            int mid = (l+r)/2;
            if(check(arr, mid, m)){
                res = Math.min(res, mid);
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return res;
    }

    public static void main (String[] args){
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            int sum = 0 ;
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                sum+=arr[i];
            }
            int bs = binarySearch(arr, 0, sum, m);
            out.println(bs);
        }
        out.close();
    }

}
