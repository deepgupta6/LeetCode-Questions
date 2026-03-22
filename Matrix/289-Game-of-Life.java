class Solution {
    int m;
    int n;

    public int countLive(int[][] board,int i,int j){
        int res = 0;

        if(i-1>=0 && j-1>=0 && board[i-1][j-1]==1) res++;
        if(j-1>=0 && board[i][j-1]==1) res++;
        if(i+1<m && j-1>=0 && board[i+1][j-1]==1) res++;
        if(i-1>=0 && board[i-1][j]==1) res++;
        if(i+1<m && board[i+1][j]==1) res++;
        if(i-1>=0 && j+1<n && board[i-1][j+1]==1) res++;
        if(j+1<n && board[i][j+1]==1) res++;
        if(i+1<m && j+1<n && board[i+1][j+1]==1) res++;

        return res;
    }

    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;

        int[][] temp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int cnt = countLive(board,i,j);
                int state = board[i][j];

                if(state==1 && cnt<2){
                    temp[i][j]=0;
                } else if(state==1 && (cnt==2 || cnt==3)){
                    temp[i][j]=1;
                } else if(state==1 && cnt>3){
                    temp[i][j] = 0;
                } else if(state==0 && cnt ==3){
                    temp[i][j] = 1;
                } else {
                    temp[i][j]=0;
                }

            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] = temp[i][j];
            }
        }

    }
}


// In place Solution

class Solution {

    public int countLive(int[][] board, int i, int j, int m, int n) {
        int[][] dir = {
            {-1,-1}, {-1,0}, {-1,1},
            {0,-1},          {0,1},
            {1,-1},  {1,0},  {1,1}
        };

        int res = 0;

        for (int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni >= 0 && nj >= 0 && ni < m && nj < n &&
                Math.abs(board[ni][nj]) == 1) {
                res++;
            }
        }

        return res;
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int onesCount = countLive(board, i, j, m, n);
                int state = Math.abs(board[i][j]);

                if (state == 1) {
                    if (onesCount < 2 || onesCount > 3) {
                        board[i][j] = -1;
                    }
                } else {
                    if (onesCount == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] > 0 ? 1 : 0;
            }
        }
    }
}