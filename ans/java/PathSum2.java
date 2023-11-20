import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    //LeetCode, 113. Path Sum II

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

    public PathSum2(){
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode eleven = new TreeNode(11, seven, two);

        TreeNode rootLeft = new TreeNode(4, eleven, null);

        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode four = new TreeNode(4, five, one);

        TreeNode thirteen = new TreeNode(13);
        TreeNode eight = new TreeNode(8, thirteen, four);

        TreeNode root = new TreeNode(5, rootLeft, eight);
        pathSum(root, 22);
        for(List<Integer> list : lists){
            String paths = "";
            for(int i : list){
                paths += ", " + i;
            }
            Main.print(paths);
        }
    }

    public static ArrayList<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        dfs(root, 0, targetSum, list);
        return lists;
    }

    public static void dfs(TreeNode node, int curVal, int targetSum, List<Integer> list){
        if(node == null) return;

        list.add(node.val);
        curVal += node.val;

        if(node.left == null && node.right == null && curVal == targetSum){
            lists.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }

        dfs(node.left, curVal, targetSum, list);
        dfs(node.right, curVal, targetSum, list);
        list.remove(list.size()-1);
    }
}
