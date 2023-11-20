public class PathSum1 {
//LeetCode, 112. Path Sum
     private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public PathSum1(){
         TreeNode left = new TreeNode(5);
         TreeNode right = new TreeNode(10);
         TreeNode root = new TreeNode(10, left, right);
         boolean ans = hasPathSum(root, 20);
         System.out.println("ans: " + ans);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return dfs(root, 0, targetSum);
    }

    public boolean dfs(TreeNode node, int curVal, int targetSum){
        if(node == null) return false;

        curVal += node.val;

        if(node.left == null && node.right == null){
            if(curVal == targetSum) return true;
        }

        return dfs(node.left, curVal, targetSum) || dfs(node.right, curVal, targetSum);
    }
}
