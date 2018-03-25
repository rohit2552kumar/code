/*
ID: 201101991
LANG: JAVA
TASK: beads
*/

import java.io.*;
import java.util.*;

public class beads {
	 static class FastReader
	    {
	        BufferedReader br;
	        StringTokenizer st;
	 
	        public FastReader()
	        {
	            try {
                    br = new BufferedReader(new FileReader("beads.in"));
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
    
        public static void main(String[] args) throws IOException 
        {
            FastReader sc = new FastReader();
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
            int n= sc.nextInt();
            String s = sc.nextLine();
            
            char p = s.charAt(0);
            int count=1,max=0;
           
   
            for(int i=1;i<n;i++){
                char c=s.charAt(i);
   
               if((p=='b'&&c=='r')||(p=='r'&&c=='b'))
                   break;
               else
                   count++;
               
               if(p=='w')
                   p=c;
            }
   
            if(count==n)
            {
                out.println(n);
                out.close();
                System.exit(0);
            }
            else{
               count=0;
               p = s.charAt(0);
            }
            
   
            
            for(int i=1;i<n;i++){
                
                char c = s.charAt(i);
                
                if(p!=c)
                {
                    
                    if((p=='b'&&c=='r')||(p=='r'&&c=='b'))
                    {
                    
                        count =0;
                        int j=i-1,k=i;
                        char a=p,b=c;
                        
                        while(true){
                            j--;
                            if(j==-1)j=n-1;
                   
                            if(s.charAt(j)!=b)
                                count++;
                            else
                                break;
                        }
                        while(true)
                        { 
                            k++;
                            if(k==n)k=0;
                            
                            if(s.charAt(k)!=a)
                                count++;
                            else
                                break;
                       
                        }
                        
                    }
                
                    else if(p=='w')
                    {
                        int j=i-1,k=i;
                        count = 0;
                        
                        while(true){
                            j--;
                            if(j==-1)j=n-1;
                   
                            if(s.charAt(j)=='w'||s.charAt(j)==c)
                                count++;
                            else if(s.charAt(j)!=c){
                                break;
                            }
                        }
                        count++;
                        
                   
                        char a=s.charAt(j),b=c;
                        
                        while(true){
                            j--;
                            if(j==-1)j=n-1;
                   
                            if(s.charAt(j)!=b)
                                count++;
                            else
                                break;
                        }
                        while(true)
                        { 
                            k++;
                            if(k==n)k=0;
                            
                            if(s.charAt(k)!=a)
                                count++;
                            else
                                break;
                       
                        }
                    }
                    
                    else if(c=='w')
                    {
                        int j=i-1,k=i;
                        count = 0;
                        
                        while(true){
                            k++;
                            if(k==n)k=0;
                   
                            if(s.charAt(k)=='w'||s.charAt(k)==p)
                                count++;
                            else if(s.charAt(k)!=p){
                                break;
                            }
                        }
                        count++;
                        
                   
                        char a=p,b=s.charAt(k);
                        
                        while(true){
                            j--;
                            if(j==-1)j=n-1;
                   
                            if(s.charAt(j)!=b)
                                count++;
                            else
                                break;
                        }
                        while(true)
                        { 
                            k++;
                            if(k==n)k=0;
                            
                            if(s.charAt(k)!=a)
                                count++;
                            else
                                break;
                       
                        }
                    }
                }
                
                max = (max>count)?max:count;
                
               
                p=c;
                
            }
                     
            out.println(max+2);
            out.close();
        }
   
   }

