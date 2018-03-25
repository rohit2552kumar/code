/*
ID: 201101991
LANG: JAVA
TASK: ride
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ride {
	
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
        	
            try {
				br = new BufferedReader(new FileReader("ride.in"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
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
	
	
	public static void main (String [] args) throws IOException {
	    
	    FastReader sc = new FastReader();
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
	    					     
	   String c = sc.nextLine();
       String g = sc.nextLine();
       String res = "";
       int num1=1,num2=1;
       for (int i=0;i<c.length();i++) {
           char ch = c.charAt(i);
           num1 *= ch-'A'+1;
       }

       for (int i=0;i<g.length();i++) {
        char ch = g.charAt(i);
        num2 *= ch-'A'+1;
    }

    if(num1%47==num2%47)
        res = "GO";
    else res = "STAY";

	    out.println(res);      
	    out.close();           
}
}
