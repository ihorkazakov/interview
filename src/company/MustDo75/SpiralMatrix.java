package company.MustDo75;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int total = matrix.length * matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int sr = 0;
        int sc = 0;
        int lr = matrix.length - 1;
        int lc = matrix[0].length - 1;

        int count = 0;

        while(count < total){
            for(int i = sc; i <= lc; i++){
                if(count == total)
                    return ans;
                ans.add(matrix[sr][i]);
                count++;
            }
            sr++;
            for(int i = sr; i <= lr; i++){
                if(count == total)
                    return ans;
                ans.add(matrix[i][lc]);
                count++;
            }
            lc--;
            for(int i = lc; i >= sc; i--){
                if(count == total)
                    return ans;
                ans.add(matrix[lr][i]);
                count++;
            }
            lr--;
            for(int i = lr; i >= sr; i--){
                if(count == total)
                    return ans;
                ans.add(matrix[i][sc]);
                count++;
            }
            sc++;
        }
        return ans;
    }
}
