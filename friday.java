/*
ID: 201101991
LANG: JAVA
TASK: friday
*/


import java.io.*;
import java.util.*;

public class friday {
	     static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            try {
				br = new BufferedReader(new FileReader("friday.in"));
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
		
	 static int swift(int n,int k){
		 n=n+k;
		 return (n%7);
	 }
	 
	 static boolean leap(int yr){
		 if(yr%400==0)
			 return true;
		 if(yr%4==0&&yr%100!=0)
			 return true;
		 
		 return false;
	 }
	 
	 public static void main(String[] args) throws IOException {
         FastReader sc = new FastReader();
         PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));

		 int n = sc.nextInt();
		 
		 int[] month = new int[]{6,2,2,5,0,3,5,1,4,6,2,4};
		 int[] count  = new int[]{1,1,3,1,2,2,2};
		 int k=0;
		 for(int yr=1901;yr<=1900+n-1;yr++){
			 
			 if(leap(yr)){
				 for(int i=0;i<2;i++){
					 month[i]=swift(month[i],1);
				 }
				 for(int i=2;i<12;i++){
					 month[i]=swift(month[i],2);
				 }
				 k=1;
			 }
			 else{
				 if(k==1){
					 for(int i=0;i<2;i++){
						 month[i]=swift(month[i],2);
					 }
					 for(int i=2;i<12;i++){
						 month[i]=swift(month[i],1);
					 }
					 k=0;
				 }
				 else{
					 for(int i=0;i<12;i++){
						 month[i]=swift(month[i],1);
					 }
				 }
			 }
			 
			 for(int i=0;i<12;i++){
				 count[month[i]]++;
			 }
         }
         
		 out.print(count[6]+" ");
		 for(int i=0;i<5;i++){
			 out.print(count[i]+" ");
         }
         out.println(count[5]);         
         out.close();
	 }

}
