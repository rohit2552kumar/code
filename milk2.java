/*
ID: 201101991
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

class Comp1 implements Comparator<Con1>{
	public int compare(Con1 a1,Con1 b1){
		return a1.a - b1.a;
	}
}

class Con1{
	int a=0;
	int b=0;
	public Con1(int i,int j){
		a=i;
		b=j;
	}
}

public class milk2 {
	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            try {
                br = new BufferedReader(new FileReader("milk2.in"));
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

	public static void main(String[] args) throws IOException{
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		
		int n = sc.nextInt();
		if(n==0){
		    out.println(0+" "+0);
			System.exit(0);
		}
		Con1[] arr = new Con1[n];
		
		for(int i=0;i<n;i++){
			int k = sc.nextInt();
			int t = sc.nextInt();
			arr[i] = new Con1(k,t);
			
		}
		
		
		Arrays.sort(arr, ( new Comp1() ));
		
		int begin = arr[0].a;
		int end = arr[0].b;
		int dur = end - begin;
        int max=dur,min=0;
        
		for(int i=1;i<n;i++){
			
			begin = arr[i].a;	
            int temp = Math.min(end,begin);
            
			if(temp==begin){
				dur+=Math.max((arr[i].b-end),0);
            }
            
            else{
				min = Math.max(min,begin-end);
				max = Math.max(max,dur);
				dur=arr[i].b-begin;
			}
			end = Math.max(arr[i].b,end);
		}
		
        out.println(max+" "+min);
        out.close();
	}
}
