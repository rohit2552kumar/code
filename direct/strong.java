#include<bits/stdc++.h>
using namespace std;
#define f 1000000007
bool isvalid(int i,int j,int n,int m)
{
    if(i<0 || j<0 || i>=n || j>=m)
        return false;
    else
        return true;
}
long long dfs(int i,int j,int r,int c,char mat[100][100])
{
    long long ans=0;

        for(int l=-1;l<=1;l++)
        {
            for(int m=-1;m<=1;m++)
            {
                if(isvalid(i+l,j+m,r,c) && mat[i+l][j+m]-mat[i][j]==1)
                {
                    ans=max(ans,1+dfs(i+l,j+m,r,c,mat));
                }
            }
        }
    return ans;
}

int main()
{

       int n,m;cin>>n>>m;
        char mat[100][100];
        long long int dp[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                cin>>mat[i][j];
            }
        }
        int c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dp[i][j]=dfs(i,j,n,m,mat);
            }
        }
        //for(int i=0;i<n;i++)
        //{
        //    for(int j=0;j<m;j++)
        //        cout<<dp[i][j]<<" ";
        //    cout<<endl;
        //}

        int t;cin>>t;
        while(t--)
        {
            char c;
            cin>>c;
            long long int max=0;
            int flag=0;
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<m;j++)
                {
                    if(mat[i][j]==c)
                    {
                        flag=1;
                        if(dp[i][j]>max)
                            max=dp[i][j];
                    }
                }
            }
            if(flag==1)
            cout<<"Strong "<<max+1<<"\n";
            else
                cout<<"Weak\n";

        }



}
