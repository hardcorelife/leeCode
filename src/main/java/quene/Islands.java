package quene;

/**
 * @author qiweigang
 * @date 2019-12-12 17:41
 * <p>
 * 典型的DFS，递归的作用是以当前的位置为起点，进行深度优先搜索，将上下左右为1的都置0
 * 每执行完一次，意味着存在一座岛屿，则sum++
 */
public class Islands {
    public static void main(String[] args) {
        int [][] map = {{1,1,1,1,0}, {1,1,0,1,0}, {1,1,0,0,0},{0,0,0,0,0}};
        int [][] map1 = {{1,1,0,0,0}, {1,1,0,0,0}, {0,0,1,0,0},{0,0,0,1,1}};
        Solution s = new Solution();
        System.out.println(s.numIslands(map));
        System.out.println(s.numIslands(map1));
    }

}

class Solution {
    int m = 0, n = 0;

    public int numIslands(int[][] grid) {
        int sum = 0;
        m = grid.length;
        if (m == 0) {
            return 0;
        }
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    DFSMaking(grid, i, j);
                    sum++;
                }
            }
        }
        return sum;
    }

    public void DFSMaking(int[][] grid, int i, int j) {
        if (i >= m || i < 0 || j >= n || j < 0 || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 0;
        DFSMaking(grid, i + 1, j);
        DFSMaking(grid, i - 1, j);
        DFSMaking(grid, i, j + 1);
        DFSMaking(grid, i, j - 1);
    }
}