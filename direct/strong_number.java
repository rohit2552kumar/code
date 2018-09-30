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

    static long gcd(long a, long b){
        if(a==0) return b;
        return gcd(b%a, a);
    }

    static HashMap<Long, Long> calPrime(long n){

        HashMap<Long, Long> prime = new HashMap<Long, Long>();

        while(n%2==0){
            Long pow = prime.get(2L);
            if(pow==null) pow=0L;
            prime.put(2L, pow+1);
            n=n/2;
        }

        for(long i=3;i<=Math.sqrt(n);i+=2){
            long count=0;
            while(n%i==0)
            {
                n/=i;
                count++;
            }

            Long pow = prime.get(i);
            if(pow==null) pow=0L;
            prime.put(i, pow+count);
        }


        if(n>2){
            Long pow = prime.get(n);
            if(pow==null) pow=0L;
            prime.put(n, pow+1);
        }

        return prime;
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();

        while(t-->0){
            long n = sc.nextLong();

            HashMap<Long, Long> prime = calPrime(n);
            if(prime.size()==1){
                System.out.println("NO");
                continue;
            }

            long ans=0;
            boolean fg = true;
            for(Map.Entry<Long, Long> ent : prime.entrySet()){
                if(ent.getValue()==1){
                    fg=false;
                    break;
                }
                ans = gcd(ans, ent.getValue());
            }

            out.println((fg && ans==1)?"YES":"NO");
        }
        out.close();
    }
}
