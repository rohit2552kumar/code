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

    static class StringPair{
        String a; int b;
        public StringPair(String a1, int a2){
            a=a1;b=a2;
        }
    }

    static HashMap<String, Boolean> visited;
    static HashMap<String, ArrayList<String>> graph;

    static int bfs(String s, String d){

        Queue<StringPair> q = new LinkedList<StringPair>();

        q.add(new StringPair(s, 0));
        visited.put(s, true);

        while(q.size()>0){

            StringPair el = q.remove();
            if(el.a.equals(d)){
                q.clear();
                return el.b;
            }

            ArrayList<String> curlist = graph.get(el.a);
            if(curlist==null){
                System.out.println(el.a);
                curlist = new ArrayList<String>();
            }

            for(String cur: curlist){
                if(!visited.get(cur)){
                    q.add(new StringPair(cur, el.b+1));
                    visited.put(cur, true);
                }
            }
        }

        return -1;
    }

    static boolean distance(String ss, String dd){
        int n = ss.length();
        int m = dd.length();
        boolean res = true, first=true;
        if(Math.abs(n-m)>1) return false;

        if(n==m){
            for(int i=0;i<n;i++){
                if(ss.charAt(i)==dd.charAt(i))
                    continue;
                else if(ss.charAt(i)!=dd.charAt(i) && first){
                    first = false;
                }else{
                    res = false;
                    break;
                }
            }
        }else if(n>m){
            int i=0,j=0;
            while(i<n && j<m){
                if(ss.charAt(i)==dd.charAt(j)){
                    i++;j++;
                }
                else if(ss.charAt(i)!=dd.charAt(j) && first){
                    first = false;
                    i++;
                }else{
                    res = false;
                    break;
                }
            }
        }else{
            int i=0,j=0;
            while(i<n && j<m){
                if(ss.charAt(i)==dd.charAt(j)){
                    i++;j++;
                }
                else if(ss.charAt(i)!=dd.charAt(j) && first){
                    first = false;
                    j++;
                }else{
                    res = false;
                    break;
                }
            }
        }

        return res;

    }

    public static void main (String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        graph = new HashMap<String, ArrayList<String>>();
        visited = new HashMap<String, Boolean>();
        ArrayList<String> word = new ArrayList<String>();

        while(true){
            String cur = sc.nextLine();
            if(cur.equals("END")) break;

            word.add(cur);
        }

        String src = sc.next();
        String dest = sc.next();

        for(String w : word){
            visited.put(w, false);
            graph.put(w, new ArrayList<String>());
        }

        for(int i=0;i<word.size();i++){
            for(int j=0;j<word.size();j++){
                if(i==j) continue;

                String ft = word.get(i);
                String snd = word.get(j);
                if(distance(ft, snd)){
                    ArrayList<String> cur = graph.get(ft);
                    if(cur==null)
                        cur = new ArrayList<String>();
                    cur.add(snd);
                    graph.put(ft, cur);
                }
            }
        }

        /*
        for(Map.Entry<String, ArrayList<String>> ent : graph.entrySet())
            out.println(ent.getKey()+"--"+ent.getValue());
        */

        out.println( bfs(src, dest) );
        out.close();
    }

}
