package me.rkomarov.binaryTreeDiameter;

public class BinaryTreeDiameterDefaultSolution implements BinaryTreeDiameterSolution {

    private int max = 0;

    @Override
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        levelHelper(root);
        return max - 1;
    }

    private int levelHelper(TreeNode branch) {
        if (branch == null)  {
            return 0;
        }

        int left  = levelHelper(branch.left);
        int right  = levelHelper(branch.right);

        max = Math.max(max, left + right + 1);
        return Math.max(right, left) + 1;
    }

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode one = new TreeNode(1, two, three);

        System.out.println(new BinaryTreeDiameterDefaultSolution().diameterOfBinaryTree(one));
    }
}
