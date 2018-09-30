#include<bits/stdc++.h>
using namespace std;
#define SET(a,b) memset(a,b,sizeof(a))
char G[22][22];

bool V[22][22][5];
bool D[22][22];

// dir : 0 - N, 1 - E, 2 - S, 3 - W

int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};



int getDir(int curr, char c) {
    if (curr == 0) {
        return c == 'l' ? 3 : 1;
    } else if (curr == 1) {
        return c == 'l' ? 0 : 2;
    } else if (curr == 2) {
        return c == 'l' ? 1 : 3;
    }
    else if (curr == 3) {
        return c == 'l' ? 2 : 0;
    }
}

void dfs(int r, int c, int N, int M, int dir, int &cnt) {

    if (!(r >= 0 && r < N && c >= 0 && c < M)) return;

    if (V[r][c][dir]) return;

    V[r][c][dir] = true;
    if (!D[r][c]) {
        ++cnt;
        D[r][c] = true;
    }
    if (G[r][c] == '.') {
        // move in curr direction
        dfs(r + dy[dir], c + dx[dir], N, M, dir, cnt);
     } else {
        int ndir = getDir(dir, G[r][c]);
        dfs(r + dy[ndir], c + dx[ndir], N, M, ndir, cnt);
     }
}

void reset(int N, int M) {
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            D[i][j] = false;
            for (int k = 0; k < 5; ++k) {
                V[i][j][k] = false;
            }
        }
    }
}

int main() {
    int T; cin >> T;
    while (T--) {
    int N, M; cin >> N >> M;
    for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            cin >> G[i][j];
        }
    }
    int Ans = 0;
    for (int i = 0;i < N; ++i) {
        for (int j = 0; j < M; ++j) {
            if (G[i][j] == '.') {
                for (int k = 0; k < 4; ++k) {
                    int cnt = 0;
                    reset(N, M);
                    dfs(i, j, N, M, k, cnt);
                    Ans = max(Ans, cnt);
                }
            }
        }
    }
    cout << Ans << endl;
    }
    return 0;
}
