/*
You are given pointer to the root of the binary search
tree and two values v1 and v2. You need to return the
lowest common ancestor (LCA) of v1 and v2 in the binary
search tree. You only need to complete the function.

Link: https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor
*/

/* Node is defined as :
class Node
   int data;
   Node left;
   Node right;

   */

static Node lca(Node root,int v1,int v2) {
   // Set it up so that v1 is always the larger int
   if (v2 > v1)
       return lca(root, v2, v1);

   // If the root is greater than both ints, go to the left
   if (root.data > v1)
       return lca(root.left, v1, v2);

   // If the root is less than both ints, go to the right
   if (root.data < v2)
       return lca(root.right, v1, v2);

   // If the root is in between or equal to the ints, you've found it!
   return root;
}
