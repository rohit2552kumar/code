#include<bits/stdc++.h>
using namespace std;
typedef long long int ll;
int main()
{
  int t;
  cin>>t;
  while(t--)
   {
    int m,k,P;
    cin>>m>>k>>P;
    ll ar[100001]={0};
    ll br[100001]={0};
    for(int i=0;i<m;i++)
      {
       cin>>ar[i];
      }
    for(int i=0;i<m;i++)
     { cin>>br[i];
     }

   int dp[2][m+1]={0};
    dp[0][0]=ar[0];
    dp[1][0]=br[0];
    int ans=INT_MAX;
    for(int i=1;i<m;i++)
     {
        ans=INT_MAX;
        for(int j=1;j<=k;j++)
        {  if(i-j>=0)
           ans = ar[i]+min(ans,min(dp[0][i-j],dp[1][i-j]+P));
           else
            break;
         } dp[0][i]=ans;
       ans=INT_MAX;
       for(int j=1;j<=k;j++)
        {  if(i-j>=0)
           ans =br[i]+ min(ans,min(P+dp[0][i-j],dp[1][i-j]));
           else
            break;
         } dp[1][i]=ans;

     }
   cout<<min(dp[1][m-1],dp[0][m-1])<<endl;
    }
return 0;
}
