import java.util.LinkedList;
import java.util.Queue;

public class EvenOddTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args){
        /*
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(4);

        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        TreeNode three = root.left.left;
        TreeNode seven = root.right.left;
        TreeNode nine = root.right.right;

        three.left = new TreeNode(12);
        three.right = new TreeNode(8);
        seven.left = new TreeNode(6);
        nine.right = new TreeNode(2);

         */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(7);
        //printTree(root);

        System.out.println("EvenOdd tree : " + isEvenOddTree(root));
    }

    public static void printTree(TreeNode node){
        System.out.println(node.val);
        if(node.left != null) printTree(node.left);
        if(node.right != null) printTree(node.right);
    }

    public static boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> curQ = new LinkedList<>();
        Queue<TreeNode> nextQ = new LinkedList<>();
        boolean odd = false;

        curQ.add(root);
        //addToNextQ(root, nextQ);

        int i = 0;

        while(!curQ.isEmpty()){
            log("level : " + i + ", e/o : " + odd + ", curQ.size() : " + curQ.size());

            TreeNode node1 = curQ.remove();
            int last = node1.val;
            if(!isEvenOdd(last, !odd)){
                log(last + " " + !odd);
                return false;
            }
            addToNextQ(node1, nextQ);

            if(odd){
                while(curQ.size() > 0){
                    TreeNode node = curQ.remove();
                    log("odd --->" + node.val);
                    if(!isEvenOdd(node.val, !odd)){
                        log(node.val +" !odd");
                        return false;
                    }
                    if(last <= node.val){
                        log(last + " !<= " + node.val);
                        return false;
                    }
                    last = node.val;
                    addToNextQ(node, nextQ);
                }
            }else if(!odd){
                while(curQ.size() > 0){
                    TreeNode node = curQ.remove();
                    log("!odd --->" + node.val);
                    if(!isEvenOdd(node.val, !odd)){
                        log(node.val +" !odd");
                        return false;
                    }
                    log("last: " + last + ", node.val: " + node.val);
                    if(last >= node.val){
                        log(last + "!<=" + node.val);
                        return false;
                    }
                    last = node.val;
                    addToNextQ(node, nextQ);
                }
            }

            curQ = nextQ;
            nextQ = new LinkedList<>();
            odd = !odd;
            i++;
        }

        return true;
    }

    public static void addToNextQ(TreeNode node, Queue<TreeNode> nextQ){
        if(node == null) return;
        if(node.left != null) nextQ.add(node.left);
        if(node.right != null) nextQ.add(node.right);
    }

    public static boolean isEvenOdd(int num, boolean odd){
        return ((num%2 == 0 && !odd) || (num%2 != 0 && odd));
    }

    public static void log(Object o){
        System.out.println(o.toString());
    }
}
