package out.SecondProblem;

import java.util.Vector;

public class Solver {

    int[][] moves = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    int n, m;
    int[][] grid;
    Vector<Pair<Integer, Integer>> Extras;
    int choose;

    public Solver(int n, int m, int[][] grid, Vector<Pair<Integer, Integer>> Extras, int choose) {
        this.Extras = Extras;
        this.n = n;
        this.m = m;
        this.grid = grid;
        this.choose = choose;
    }

    public Vector<Pair<Integer, Integer>> solve() {

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        
        for (int i = 0; i < n; i++) {
            if(choose == 1){
            dfsDesert(pacific, i, 0);
            dfsDesert(atlantic, i, m - 1);
            }   
            if(choose == 2){
                dfsRiver(pacific, i, 0);
                dfsRiver(atlantic, i, m - 1);  
            }
        }

        for (int j = 0; j < m; j++) {
            if(choose == 1){
            dfsDesert(pacific, 0, j);
            dfsDesert(atlantic, n - 1, j);
            }
            if(choose == 2){
            dfsRiver(pacific, 0, j);
            dfsRiver(atlantic, n - 1, j);    
            }
        }

        Vector<Pair<Integer, Integer>> ans = new Vector<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (pacific[i][j] && atlantic[i][j])
                    ans.add(new Pair<>(i, j));

        }

        return ans;
    }

    private void dfsDesert(boolean[][] visited, int i, int j) {

        visited[i][j] = true;

        for (int[] current : moves) {

            int ci = i + current[0];
            int cj = j + current[1];

            if (canBeVisited(ci, cj, visited) && grid[ci][cj] > grid[i][j]
                    &&  !Extras.contains(new Pair<>(ci, cj))) 
                dfsDesert(visited, ci, cj);
        }

        // if(i+1 < n && !visited[i+1][j] && a[i+1][j] > a[i][j] && !Extras.contains(new
        // Pair<>(i+1 , j)) )
        // dfsDesert(visited , i+1, j);

        // if(i-1 >= 0 && !visited[i-1][j] && a[i-1][j] > a[i][j] && !Extras.contains(new Pair<>(i -1, j)))
        // dfsDesert(visited , i-1, j);

        // if(j+1 < m && !visited[i][j+1] && a[i][j+1] > a[i][j] && !Extras.contains(new
        // Pair<>(i , j+1)))
        // dfsDesert(visited , i, j+1);

        // if(j-1 >= 0 && !visited[i][j-1] && a[i][j-1] >a[i][j] && !Extras.contains(new
        // Pair<>(i , j-1)))
        // dfsDesert(visited , i, j-1);
        
    }

    private void dfsRiver(boolean[][] visited, int i, int j) {
        visited[i][j] = true;
    
        for (int[] move : moves) {
            int ci = i + move[0];
            int cj = j + move[1];
    
            if (canBeVisited(ci, cj, visited)) {
                boolean isRiver = Extras.contains(new Pair<>(ci, cj));
    
                if ((isRiver && grid[ci][cj] >= grid[i][j]) || (!isRiver && grid[ci][cj] > grid[i][j])) {
                    dfsRiver(visited, ci, cj); 
                }
            }
        }
    }

    public boolean canBeVisited(int ci , int cj , boolean[][] visited){
        return ci >= 0 && ci < n && cj >= 0 && cj < m && !visited[ci][cj];
    }
    
}
