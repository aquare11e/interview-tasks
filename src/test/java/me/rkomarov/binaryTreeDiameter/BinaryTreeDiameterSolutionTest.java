package me.rkomarov.binaryTreeDiameter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryTreeDiameterSolutionTest {

    @ParameterizedTest
    @MethodSource("solutionObjects")
    public void emptyTreeTest(BinaryTreeDiameterSolution solution) {
        // Given
        // Expect
        assertEquals(0, solution.diameterOfBinaryTree(null));
    }

    @ParameterizedTest
    @MethodSource("solutionObjects")
    public void singleNodeTreeTest(BinaryTreeDiameterSolution solution) {
        // Given
        // Expect
        assertEquals(0, solution.diameterOfBinaryTree(new TreeNode(1)));
    }

    @ParameterizedTest
    @MethodSource("solutionObjects")
    public void twoNodesTreeTest(BinaryTreeDiameterSolution solution) {
        // Given
        /*
                            1
                           /
                          2
         */
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1, two, null);
        // Expect
        assertEquals(1, solution.diameterOfBinaryTree(one));
    }

    @ParameterizedTest
    @MethodSource("solutionObjects")
    public void defaultCaseTreeTest(BinaryTreeDiameterSolution solution) {
        // Given
        /*
                            1
                           / \
                          2   3
                         / \
                        4  5
         */
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode one = new TreeNode(1, two, three);

        // When
        assertEquals(3, solution.diameterOfBinaryTree(one));
    }

    @ParameterizedTest
    @MethodSource("solutionObjects")
    public void diameterInLeftSubtreeTest(BinaryTreeDiameterSolution solution) {
        // Given
        /*
                            1
                           / \
                          2   3
                         / \
                        4   5
                       /     \
                      6       7
                     /         \
                    8           9
         */
        TreeNode nine = new TreeNode(9);
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7, null, nine);
        TreeNode six = new TreeNode(6, eight, null);
        TreeNode five = new TreeNode(5, null, seven);
        TreeNode four = new TreeNode(4, six, null);
        TreeNode three = new TreeNode(3, null, null);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode one = new TreeNode(1, two, three);

        // Expect
        assertEquals(6, solution.diameterOfBinaryTree(one));
    }

    @ParameterizedTest
    @MethodSource("solutionObjects")
    public void diameterInRightSubtreeTest(BinaryTreeDiameterSolution solution) {
        // Given
        /*
                            1
                           / \
                          2   3
                             / \
                            4   5
                           /     \
                          6       7
                         /         \
                        8           9
         */
        TreeNode nine = new TreeNode(9);
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7, null, nine);
        TreeNode six = new TreeNode(6, eight, null);
        TreeNode five = new TreeNode(5, null, seven);
        TreeNode four = new TreeNode(4, six, null);
        TreeNode three = new TreeNode(3, four, five);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1, two, three);

        // Expect
        assertEquals(6, solution.diameterOfBinaryTree(one));
    }

    public static Stream<Arguments> solutionObjects() {
        return Stream.of(
            Arguments.of(new BinaryTreeDiameterDefaultSolution()),
            Arguments.of(new BinaryTreeDiameterStatelessSolution())
        );
    }
}