class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        // code here
        int i = 0, j = 0, k = n - 1, l = n - 1, ans = 0;

        while (i < n && j < n && k >= 0 && l >= 0) {
            int sum = mat1[i][j] + mat2[k][l];
    
            if (sum == x) {
                ans++;
                if (j == n - 1) {
                    j = 0;
                    i++;
                } else {
                    j++;
                }
                if (l == 0) {
                    l = n - 1;
                    k--;
                } else {
                    l--;
                }
            } else if (sum > x) {
                if (l == 0) {
                    l = n - 1;
                    k--;
                } else {
                    l--;
                }
            } else {
                if (j == n - 1) {
                    j = 0;
                    i++;
                } else {
                    j++;
                }
            }
        }
        return ans;
        }
}
