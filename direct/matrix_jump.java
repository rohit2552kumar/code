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
    static int inf = Integer.MAX_VALUE;
    static int n,m;
    
    static int findPath(int[][] mat, int x, int y, int depth){
        
        if(x>=m || y>=n){
            return inf;
        }
        if(x==m-1 && y==n-1){
            return depth;
        }
        int val = mat[x][y];
        return Math.min(findPath(mat, x+val, y, depth+1), findPath(mat, x, y+val, depth+1));
        
    }
    
	public static void main (String[] args) {
		FastReader sc = new FastReader();
	    n = sc.nextInt();
	    m = sc.nextInt();
	    
	    int[][] mat = new int[m][n];
	    for(int i=0;i<m;i++)
	        for(int j=0;j<n;j++)
	            mat[i][j] = sc.nextInt();
	            
	    int res = findPath(mat, 0, 0, 1);
	    res = (res==inf)?0:res;
	    System.out.println(res);
	
	}
	
}