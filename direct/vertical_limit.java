import java.util.*;
import java.io.*;

class GFG {

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
    static String tree;
    static int n;
    static ArrayList<Character> result;

    static int dfs(int u, int col){

        //System.out.println("for u="+u+"--"+tree.charAt(u)+"  "+col);
        if(col==n){
            result.add(tree.charAt(u));
        }

        if(tree.charAt(u)=='.') return u+1;

        int left = 0;
        for(int i=u;i<tree.length();i++){
            if(tree.charAt(i)=='('){
                left = i+1;
                break;
            }
        }
        int right = dfs(left, col-1);
        return dfs(right, col+1)+1;

    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while(t-->0){
            n = sc.nextInt();
            tree = sc.nextLine();
            result = new ArrayList<Character>();

            int res = dfs(0, 0);
            res = 0;
            Collections.sort(result);
            for(char c : result){
                if(c!='.'){
                    out.print(c);
                    res++;
                }
            }
            if(res==0)
                out.println("Hallelujah!");
            else
                out.println("");
            //System.out.println(result);
        }
        out.close();
    }
}
