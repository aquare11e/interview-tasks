package me.rkomarov.binaryTreeDiameter;

import lombok.Value;

public class BinaryTreeDiameterStatelessSolution implements BinaryTreeDiameterSolution {

    @Value
    private static class PartialResult {
        int depth;
        int maxDiameter;
    }

    @Override
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        return diameterHelper(root).maxDiameter - 1;
    }

    private PartialResult diameterHelper(TreeNode root) {
        if (root == null) {
            return new PartialResult(0, 0);
        }

        PartialResult left = diameterHelper(root.left);
        PartialResult right = diameterHelper(root.right);


        return new PartialResult(
            Math.max(left.depth, right.depth) + 1,
            Math.max(
                Math.max(left.maxDiameter, right.maxDiameter),
                left.depth + right.depth + 1
            )
        );
    }

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode one = new TreeNode(1, two, three);

        System.out.println(new BinaryTreeDiameterStatelessSolution().diameterOfBinaryTree(one));
    }
}
