class Node
{
   int data;
   Node right,down;

   Node(int data){
       this.data = data;
       right = null;
       down = null;
   }
}
*/
/*Function should return the head of the 2D LL.*/
class Solution {
    static Node construct(int arr[][]) {
        // Add your code here.
        int m = arr.length;
        int n = arr[0].length;
        Node[][] nodeMatrix = new Node[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nodeMatrix[i][j] = new Node(arr[i][j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1) {
                    nodeMatrix[i][j].right = nodeMatrix[i][j + 1]; 
                }
                if (i < m - 1) {
                    nodeMatrix[i][j].down = nodeMatrix[i + 1][j]; 
                }
            }
        }

        return nodeMatrix[0][0];

    }
}
