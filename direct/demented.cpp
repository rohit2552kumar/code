#include<stdio.h>

long long int sum_of_squares(int n){
    if(n/10==0)
        return n*n;

    return sum_of_squares(n/10) + (n%10)*(n%10);

}

void main(){
    long long int a,b, ans=0, i;
    scanf("%lld %lld", &a, &b);


    for(i=a; i<=b; i++){
        int j = sum_of_squares(i);
        while(j/10){
            j = sum_of_squares(j);
            //printf("%d\n",j);
        }

        if(j == 1)
            ans++;
    }

    printf("%d", ans);


}
