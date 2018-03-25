/*
ID: 201101991
LANG: JAVA
TASK: namenum
*/

import java.io.*;
import java.util.*;

class Store{
    String s;
    String num;
    public Store(String a,String b){
        s=a;
        num=b;
    }

    public static String getNum(String cur){
        String res="";
        for(int i=0;i<cur.length();i++){
            char c = cur.charAt(i);
            int n= 0;
            switch(c){
                case 'A':
                case 'B':
                case 'C': n=2;break;

                case 'J':
                case 'K':
                case 'L': n=5;break;

                case 'T':
                case 'U':
                case 'V': n=8;break;

                case 'D':
                case 'E':
                case 'F': n=3;break;

                case 'M':
                case 'N':
                case 'O': n=6;break;
                
                case 'W':
                case 'X':
                case 'Y': n=9;break;

                case 'G':
                case 'H':
                case 'I': n=4;break;

                case 'P':
                case 'R':
                case 'S': n=7;break;

                default: n=-1;

            }
            if(n==-1){
                return "-1";
            }

            res = res+Integer.toString(n);

        }
        return res;
    }
}

public class namenum{
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(String s)
        {
            try {
                br = new BufferedReader(new FileReader(s));
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
        FastReader sc = new FastReader("namenum.in");
        FastReader dic = new FastReader("dict.txt");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
    
        Store[] arr = new Store[5000];
        int len =0;
        for(int i=0;i<5000;i++){
            String cur = dic.nextLine();
            if(cur==null)break;
            len++;
            String num = Store.getNum(cur);
            arr[i] = new Store(cur,num);
        }

        String n = sc.nextLine();
        int k=0;
        for(int i=0;i<len;i++){
            if(n.equals(arr[i].num)){
                out.println(arr[i].s);
                k=1;
            }
        }
        if(k==0){
            out.println("NONE");
        }
        out.close();
    }
}