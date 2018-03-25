/*
ID: 201101991
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.*;

class obj{
	int p;
	int a;
	public obj(int i,int j){
		p=i;
		a=j;
	}
}

class comp implements Comparator<obj>{
	public int compare(obj a1,obj a2){
		return a1.p-a2.p;
	}
}

public class milk {

	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            try {
				br =  new BufferedReader(new FileReader("milk.in"));
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

	
	public static void main(String[] args) throws java.lang.Exception
	{
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int price = 0;
		obj[] arr = new obj[m];
		
		for(int i=0;i<m;i++){
			int p = sc.nextInt();
			int a = sc.nextInt();
			arr[i] = new obj(p,a);
		}
		
		Arrays.sort(arr,new comp());
		
		for(int i=0;i<m;i++){
			int p = arr[i].p;
			int a = arr[i].a;
			
			if(n-a>=0)
				price+=a*p;
			else{
				price+=n*p;
				break;
			}
			n-=a;
		}
		
        out.println(price);
        out.close();
	}

}