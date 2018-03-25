/*
ID: 201101991
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

public class gift1 {
	
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            try {
				br =  new BufferedReader(new FileReader("gift1.in"));
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
	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
	    
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
                int n = sc.nextInt();
                String[] arr = new String[n];
                for(int i=0;i<n;i++){
                    
                    String key = sc.nextLine();
                    arr[i]=key;
                    if(!map.containsKey(key)){
                        map.put(key, 0);
                    }
                }
                int amt,no;
                String line;
                while ((line = sc.nextLine()) != null) {

                    String name=line;
                    if(Character.isAlphabetic(line.charAt(0))){
                        
                        String line2 = sc.nextLine();
                        //System.out.println(line2);
                        amt = Integer.parseInt(line2.substring(0,line2.indexOf(' ')));
                        no = Integer.parseInt(line2.substring(line2.indexOf(' ')+1));
                        if(no==0)
                        	continue;
                        int add=amt/no;
                        amt = amt - (amt%no);
                        amt = map.get(name) - amt;
                        map.put(name, amt);
                        
                        for(int i=0;i<no;i++){
                            String take = sc.nextLine();
                            int temp = (map.get(take)+add);
                            map.put(take,temp);
                        }
                    }else{
                        out.println("problem");
                    }
                    
                }
                for(int i=0;i<n;i++){
                    out.println(arr[i]+" "+map.get(arr[i]));
                }
                out.close();           
                   
    }
}
