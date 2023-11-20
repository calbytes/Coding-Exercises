import java.util.ArrayList;

public class PathSumIII {
    //437. Path Sum III

    int counter = 0;
    public int pathSum(TreeNode root, int sum) {

        if (root == null) return 0;

        pathSumHelper(root, sum, 0);
        pathSum(root.left, sum);
        pathSum(root.right, sum);

        return counter;
    }

    void pathSumHelper(TreeNode root, int sum, long currentSum) {
        if (root == null) return;

        currentSum += root.val;
        if (currentSum == sum) {
            counter++;
        }
        pathSumHelper(root.left, sum, currentSum);
        pathSumHelper(root.right, sum, currentSum);
    }



    public PathSumIII(){
        TreeNode left = new TreeNode(2);
        TreeNode root = new TreeNode(1, left, null);

        TreeNode leftLeft = new TreeNode(3);
        left.left = leftLeft;

        TreeNode leftLeaf = new TreeNode(4);
        leftLeft.left = leftLeaf;

        TreeNode leaf = new TreeNode(5);
        leftLeaf.left = leaf;
        int ans = pathSum(root, 3);
        Main.print("paths: " + ans);
    }


    public class TreeNode {
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
}
