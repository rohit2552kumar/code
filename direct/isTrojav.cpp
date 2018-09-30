#include<math.h>
#include <stdio.h>
#include <assert.h>
#define bool int
#define true 1
#define false 0
bool isTrozan(int n)
{
    while (n%2 == 0)
    {
        int power = 0;
        while (n % 2 == 0)
        {
            n /= 2;
            power++;
        }
        if (power == 1)
          return false;
    }
    for (int factor=3;  factor<=sqrt(n); factor += 2)
    {
        int power = 0;
        while (n % factor == 0)
        {
            n = n/factor;
            power++;
        }

        if (power == 1)
          return false;
    }

    return (n == 1);
}

bool isPower(unsigned n)
{
    if (n==1)  return true;

    for (int x=2; x<=sqrt(n); x++)
    {
        unsigned y = 2;
        unsigned p = pow(x, y);

        while (p<=n && p>0)
        {
            if (p==n)
                return true;
            y++;
            p = pow(x, y);
         }
    }
    return false;
}

int main()
{
    int T,n;
    scanf("%d",&T);
    for(int i=0;i<T;i++)
    {
        scanf("%d",&n);
        bool a=isTrozan(n);
        if(a==1)
        {
            if(isPower(n))
            printf("NO\n");
            else
            printf("YES\n");
        }
        else
        printf("NO\n");
    }

    return 0;
}
