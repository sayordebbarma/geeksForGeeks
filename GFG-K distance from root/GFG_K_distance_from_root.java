class Tree
{
     // Recursive function to print right view of a binary tree.
     ArrayList<Integer> Kdistance(Node root, int k)
     {
          // Your code here
          ArrayList<Integer> result = new ArrayList<>();
          if (root == null || k < 0) return result;
          if (k == 0) {
              result.add(root.data);
              return result;
          }
          result.addAll(Kdistance(root.left, k - 1));
          result.addAll(Kdistance(root.right, k - 1));
          return result;
     }
}
