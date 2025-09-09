package SecondProblem;

import java.util.Scanner;
import java.util.Vector;

public class ForSecond {

    public ForSecond(){
        
        Scanner in = new Scanner(System.in);

            System.out.println("Enter n and m : ");
        int n, m;
        n = in.nextInt();
        m = in.nextInt();

        System.out.println("Enter the grid : ");
        int[][] heights = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                heights[i][j] = in.nextInt();

        // 1 2 2 3 5
        // 3 2 3 4 4
        // 2 4 5 3 1
        // 6 7 1 4 5
        // 5 1 1 2 4

        Vector<Pair<Integer, Integer>> Pairs = new Vector<>();

        System.out.println("1 for deserts and 2 for rivers");
        int choose = in.nextInt();

        System.out.println("How many you want ?");
        int p = in.nextInt();

        if(p!=0){
        System.out.println("Enter " + p + " pairs: ");
        for (int i = 0; i < p; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            Pairs.add(new Pair<>(x, y));
        }
        }

        Solver solver = new Solver(n, m, heights, Pairs, choose);

        Vector<Pair<Integer, Integer>> ans = solver.solve();

        for (Pair<Integer, Integer> cell : ans) {
            System.out.println(cell);
        }
    }
}
