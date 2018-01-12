package br.com.pedront.hackerrank.crackingthecodinginterview.graph.dfs;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author pnakano
 * @version $Revision: $<br/>
 *          $Id: $
 * @since 09/01/18 13:47
 */
public class ConnectedCellInAGrid {

    static boolean isFilled(final int[][] grid, final int row, final int col) {
        if (row < 0 || row >= grid.length) {
            return false;
        }

        if (col < 0 || col >= grid[0].length) {
            return false;
        }

        if (grid[row][col] != 1) {
            return false;
        }

        return true;
    }

    static int measureAndMarkRegion(int[][] grid, final int row, final int col) {
        HashSet<Point> visited = new HashSet<>();

        ArrayList<Point> nextCells = new ArrayList<>();

        nextCells.add(new Point(col, row));
        visited.add(new Point(col, row));

        int regionCount = 0;

        while (!nextCells.isEmpty()) {
            Point point = nextCells.remove(0);

            addAdjacents(nextCells, visited, grid, point.y, point.x);

            grid[point.y][point.x] = 'X';
            regionCount++;
        }

        return regionCount;
    }

    private static void addAdjacents(ArrayList<Point> nextCells, HashSet<Point> visited, int[][] grid, final int row,
            final int col) {
        for (int rowDiff = -1; rowDiff <= 1; rowDiff++) {
            for (int colDiff = -1; colDiff <= 1; colDiff++) {
                if ((rowDiff != 0 || colDiff != 0) && isFilled(grid, row - rowDiff, col - colDiff)) {
                    Point point = new Point(col - colDiff, row - rowDiff);
                    if (!visited.contains(point)) {
                        nextCells.add(new Point(col - colDiff, row - rowDiff));
                        visited.add(new Point(col - colDiff, row - rowDiff));
                    }
                }
            }
        }
    }

    static void printLargestRegion(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int largest = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int regionSize = measureAndMarkRegion(grid, i, j);
                    if (regionSize > largest) {
                        largest = regionSize;
                    }
                }
            }
        }

        System.out.println(largest);
    }

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // int n = in.nextInt();
        // int m = in.nextInt();
        // int grid[][] = new int[n][m];
        // for (int grid_i = 0; grid_i < n; grid_i++) {
        // for (int grid_j = 0; grid_j < m; grid_j++) {
        // grid[grid_i][grid_j] = in.nextInt();
        // }
        // }

        int grid[][] = {
                { 1, 1, 0, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 1, 0 },
                { 1, 0, 0, 0 }
        };

        printLargestRegion(grid);
    }
}
