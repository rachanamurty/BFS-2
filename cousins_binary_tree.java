// check if two given nodes are cousins - i.e., they are the same level but dont have same parent
// TC: O(n) - As we are going over each node just once
// SC : O(n) - For storing the values of each level of nodes - worst case O(n) avg just the number of nodes on the level + its children

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean xPresent = false;
        boolean yPresent = false;
       // Start queue traversal
        while(queue.size() > 0){
            int size = queue.size();
            xPresent = false;
            yPresent = false;
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                // Check if x and y are siblings
                if (node.left != null && node.right != null) {
                    int left = node.left.val;
                    int right = node.right.val;
                    if ((left == x && right == y) || (left == y && right == x)) {
                        return false; // x and y have the same parent
                    }
                }
                if(node.val == x){
                    xPresent = true;
                }

                if(node.val == y){
                    yPresent = true;
                }

                if(node.left!=null){
                    queue.add(node.left);
                }

                if(node.right!=null){
                    queue.add(node.right);
                }
            }
           // After each level we check if x and y are both present
            if(xPresent && yPresent){
                return true;
            }
        }
        return false;
    }
}
