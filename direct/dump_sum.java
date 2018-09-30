import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ssaxena36
 * Solution is at the Top
 *
 */
class Time {
    int mod = 1000000007;
    void solve() {

        int t = inpi();
        while(t--> 0){
            int n = inpi();
            if(n == 0)
            out.println(0);
            else
            out.println(DumbSum(n)%mod);
        }
    }
    public boolean isPrime(long n) {
        return BigInteger.valueOf(n).isProbablePrime(5);
    }
 long summer[] = new long[1001];
    public void SieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        // Print all prime numbers
        for (int p = 2; p <= n; p++) {
            if (prime[p]) {
                //  System.out.print(p+" ");
                // primes[p] = true;
            }
        }
        // return list;
    }

long mul(long n){
    return (n * 2) % mod;
}
    InputStream obj;
    PrintWriter out;
    String check = "";

    public static void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new Time().main1();
                } catch (IOException ex) {
                    Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }, "child-thread", 1 << 26).start();

    }

    void main1() throws IOException {
        out = new PrintWriter(System.out);
        obj = check.isEmpty() ? System.in : new ByteArrayInputStream(check.getBytes());
        // obj=check.isEmpty() ? new FileInputStream("/home/ssaxena36/Desktop/input.txt") : new ByteArrayInputStream(check.getBytes());
        solve();
        out.flush();
        out.close();
    }
    byte inbuffer[] = new byte[1024];
    int lenbuffer = 0, ptrbuffer = 0;

    int readByte() {
        if (lenbuffer == -1) {
            throw new InputMismatchException();
        }
        if (ptrbuffer >= lenbuffer) {
            ptrbuffer = 0;
            try {
                lenbuffer = obj.read(inbuffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }
        if (lenbuffer <= 0) {
            return -1;
        }
        return inbuffer[ptrbuffer++];
    }

    boolean isSpaceChar(int c) {
        return (!(c >= 33 && c <= 126));
    }

    int skip() {
        int b;
        while ((b = readByte()) != -1 && isSpaceChar(b));
        return b;
    }

    String inps() {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while (!(isSpaceChar(b))) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    int inpi() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    long inpl() {
        long num = 0;
        int b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') {
                num = num * 10 + (b - '0');
            } else {
                return minus ? -num : num;
            }
            b = readByte();
        }
    }

    float inpf() {
        return Float.parseFloat(inps());
    }

    double inpd() {
        return Double.parseDouble(inps());
    }

    char inpc() {
        return (char) skip();
    }

    int[] inpia(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = inpi();
        }
        return a;
    }

    long[] inpla(int n) {
        long a[] = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = inpl();
        }
        return a;
    }

    String[] inpsa(int n) {
        String a[] = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = inps();
        }
        return a;
    }
long DumbSum(int sum ){
    long total=0L, count = 0L;
    if (sum==0)
    return 1L;
    int i = 1;
    while(i <= 3){
        /*
        termination condition
        */
        if (sum-i<0) {
        break;
        }
        if(summer[sum-i] == 0) {
        count = DumbSum(sum-i);
        }
        else {
        count = summer[sum-i];
        }
        if(i==1) {
        count = mul(count);
        }
        total = (total + count) %mod;
        i += 1;
    }
    summer[sum] = total;
    return total;
}

    double[][] inpdm(int n, int m) {
        double a[][] = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = inpd();
            }
        }
        return a;
    }

    int[][] inpim(int n, int m) {
        int a[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = inpi();
            }
        }
        return a;
    }
}
