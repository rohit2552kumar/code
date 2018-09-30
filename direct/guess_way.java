import java.util.Scanner;

public class D {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long h = in.nextLong();
        long n = in.nextLong();

        n = ((long) Math.pow(2, h)) + n - 1L;
        long a = 0;

        for(long i=h;i>=1;i--){

            if(n%2==1){
                if((n/2)%2==1){
                    a= a + ((long) Math.pow(2,h-i+1));
                } else {
                    a= a + 1;
                }
                n/=2;
            } else {
                if((n/2)%2==0)  {
                    a= a + ((long) Math.pow(2,h-i+1));
                } else {
                    a=a+1;
                }
                n=n/2;
            }

        }
        System.out.println(a);
    }
}
