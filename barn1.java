/*
ID: 201101991
LANG: JAVA
TASK: barn1
*/

import java.io.*;
import java.util.*;


public class barn1 {

	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            try {
				br =  new BufferedReader(new FileReader("barn1.in"));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
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

	public static void main(String[] args) throws java.lang.Exception
	{
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        
        int m,s,c,res;
        
        m = sc.nextInt();
		s = sc.nextInt();
		c = sc.nextInt();
        
        int[] arr = new int[c];
		int[] dif = new int[c];
        
        arr[0]=sc.nextInt();
		
		for(int i=1;i<c;i++){
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		for(int i=1;i<c;i++){
			dif[i-1]=arr[i]-arr[i-1];
		}
		res = arr[c-1]-arr[0]+1;
				
		while(m-->1){
			int max = 0,maxi=0;
			
			for(int i=0;i<c;i++){
				if(max<dif[i]){
					max = dif[i];
					maxi = i;
				}
			}
            if(max==0)
            break;
			res= res - dif[maxi]+1;
			dif[maxi]=0;
		}
        out.println(res);
        out.close();
	}
}
