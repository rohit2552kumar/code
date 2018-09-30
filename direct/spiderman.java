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
        int i,j,d;
        public IntegerPair(int a1, int a2, int a3){
            i=a1;j=a2;d=a3;
        }
    }

    static int[][] dist;
    static boolean[][] visited;
    static int[][] allmove = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};

    static int D,n,m;

    static boolean validPoint(int x, int y, int i, int j){
        if(x<=0 || x>m || y<=0 || y>n)
            return false;

        return (Math.abs(dist[x][y]-dist[i][j])<=D)?true:false;
    }

    static int bfs(int si, int sj, int di, int dj){

        Queue<IntegerPair> q = new LinkedList<IntegerPair>();

        q.add(new IntegerPair(si, sj, -1));
        visited[si][sj] = true;

        while(q.size()>0){
            IntegerPair el = q.remove();
            if(el.i==di && el.j==dj){
                q.clear();
                return el.d;
            }

            for(int move[] : allmove){
                int x = el.i+move[0];
                int y = el.j+move[1];
                if( validPoint(x, y, el.i, el.j) && !visited[x][y]){
                    q.add(new IntegerPair(x, y, el.d+1));
                    visited[x][y]=true;
                }
            }
        }

        return -1;
    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();

        while(t-->0){
            n = sc.nextInt();
            m = sc.nextInt();
            int di = sc.nextInt();
            int dj = sc.nextInt();
            D = sc.nextInt();

            visited = new boolean[m+1][n+1];
            dist = new int[m+1][n+1];

            for(int i=1;i<=m;i++){
                for(int j=1;j<=n;j++){
                    dist[i][j] = sc.nextInt();
                }
            }

            out.println( bfs(1, 1, di, dj) );
        }
        out.close();
    }

}
