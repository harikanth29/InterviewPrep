package com.hk.main.java.Karrat;

public class CheckBlackCells {

    /*
A nonogram is a logic puzzle, similar to a crossword, in which the player is given a blank grid and has to color it according to some instructions. Specifically, each cell can be either black or white, which we will represent as 'B' for black and 'W' for white.

+------------+
| W  W  W  W |
| B  W  W  W |
| B  W  B  B |
| W  W  B  W |
| B  B  W  W |
+------------+

For each row and column, the instructions give the lengths of contiguous runs of black ('B') cells. For example, the instructions for one row of [ 2, 1 ] indicate that there must be a run of two black cells, followed later by another run of one black cell, and the rest of the row filled with white cells.

These are valid solutions: [ W, B, B, W, B ] and [ B, B, W, W, B ] and also [ B, B, W, B, W ]
This is not valid: [ W, B, W, B, B ] since the runs are not in the correct order.
This is not valid: [ W, B, B, B, W ] since the two runs of Bs are not separated by Ws.

Your job is to write a function to validate a possible solution against a set of instructions. Given a 2D matrix representing a player's solution; and instructions for each row along with additional instructions for each column; return True or False according to whether both sets of instructions match.

Example instructions #1

matrix1 = [[ W, W, W, W ],
           [ B, W, W, W ],
           [ B, W, B, B ],
           [ W, W, B, W ],
           [ B, B, W, W ]]
rows1_1    =  [], [1], [1,2], [1], [2]
columns1_1 =  [2,1], [1], [2], [1]
validateNonogram(matrix1, rows1_1, columns1_1) => True

Example solution matrix:
matrix1 ->
                                   row
                +------------+     instructions
                | W  W  W  W | <-- []
                | B  W  W  W | <-- [1]
                | B  W  B  B | <-- [1,2]
                | W  W  B  W | <-- [1]
                | B  B  W  W | <-- [2]
                +------------+
                  ^  ^  ^  ^
                  |  |  |  |
  column       [2,1] | [2] |
  instructions      [1]   [1]


Example instructions #2

(same matrix as above)
rows1_2    =  [], [], [1], [1], [1,1]
columns1_2 =  [2], [1], [2], [1]
validateNonogram(matrix1, rows1_2, columns1_2) => False

The second and third rows and the first column do not match their respective instructions.

Example instructions #3

(same matrix as above)
rows1_3    = [], [1], [3], [1], [2]
columns1_3 = [3], [1], [2], [1]
validateNonogram(matrix1, rows1_3, columns1_3) => False

The third row and the first column do not match their respective instructions.

Example instructions #4

(same matrix as above)
rows1_4    =  [], [1,1], [1,2], [1], [2]
columns1_4 =  [2,1], [1], [2], [1]
validateNonogram(matrix1, rows1_4, columns1_4) => False

The second row does not match the respective instructions

Example instructions #5

matrix2 = [
 [ W, W ],
 [ B, B ],
 [ B, B ],
 [ W, B ]
]
rows2_1    = [], [2], [2], [1]
columns2_1 = [1, 1], [3]
validateNonogram(matrix2, rows2_1, columns2_1) => False

The black cells in the first column are not separated by white cells.

Example instructions #6

(same matrix as above)
rows2_2    = [], [2], [2], [1]
columns2_2 = [3], [3]
validateNonogram(matrix2, rows2_2, columns2_2) => False

The first column has the wrong number of black cells.

Example instructions #7

(same matrix as above)
rows2_3    = [], [], [], []
columns2_3 = [], []
validateNonogram(matrix2, rows2_3, columns2_3) => False

All of the instructions are empty

n: number of rows in the matrix
m: number of columns in the matrix
*/
    public static void main(String[] argv) {


        char[][] matrix1 = {
                {'W','W','W','W'},
                {'B','W','W','W'},
                {'B','W','B','B'},
                {'W','W','B','W'},
                {'B','B','W','W'}};

        int[][] rows1_1 = {{},{1},{1,2},{1},{2}};
        int[][] columns1_1 = {{2,1},{1},{2},{1}};

        int[][] rows1_2 = {{},{},{1},{1},{1,1}};
        int[][] columns1_2 = {{2},{1},{2},{1}};

        int[][] rows1_3 = {{},{1},{3},{1},{2}};
        int[][] columns1_3 = {{3},{1},{2},{1}};

        int[][] rows1_4 = {{},{1,1},{1,2},{1},{2}};
        int[][] columns1_4 = {{2,1},{1},{2},{1}};

        char[][] matrix2 = {
                {'W','W'},
                {'B','B'},
                {'B','B'},
                {'W','B'}};

        int[][] rows2_1 = {{},{2},{2},{1}};
        int[][] columns2_1 = {{1,1},{3}};

        int[][] rows2_2 = {{},{2},{2},{1}};
        int[][] columns2_2 = {{3},{3}};

        int[][] rows2_3 = {{},{},{},{}};
        int[][] columns2_3 = {{},{}};

//     Solution sol = new Solution();
//     boolean result =sol.validate(grid10);
//     System.out.println("result:"+result);
    }
    public boolean validate(char[][] grid, int[][] rows,  int[][] cols){
        int n=grid.length,m=grid[0].length;
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n;j++){
                char val = grid[i][j];
                sb.append(val);
            }
            for(int k=0;k<rows.length;k++){
                int[] arr= rows[k];
                int len=arr.length;
                if(len==0){
                    for(char c:sb.toString().toCharArray()){
                        if(c=='B')return false;
                    }
                }else if(len==1){
                    boolean check=false;
                    for(char c:sb.toString().toCharArray()){
                        if(c=='B' && !check){
                            check =true;
                        }else{
                            return false;
                        }
                    }
                }else{
                    for(int kk=0;kk<len;kk++){
                        int res =find(sb.toString(),kk,arr[kk]);
                        if(res==-1)return false;
                    }
                }
            }
        }

//     for(int i=0;i<n;i++){
//       boolean[] cache = new boolean[n];
//       for(int j=0;j<n;j++){
//         int val = grid[j][i];
//         if(val>0 && val<=n){
//           cache[val-1]=true;
//         }else{
//           return false;
//         }
//       }
//       for(int k=0;k<n;k++){
//         if(!cache[k])return false;
//       }
//     }
        return true;

    }
    public int find(String s,int num,int index){
        int res=-1;
        for(int jj=index;jj<s.length();jj++){// {'B','W','B','B'},
            if(s.charAt(jj)=='B'){
                while(num-->0){
                    if(s.charAt(jj)=='B'){
                        res=jj;
                    }else{
                        res=-1;
                    }
                }
            }
        }
        return res;
    }
}
