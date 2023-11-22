public class evaluateExpressionTree {
    if (tree.value >= 0){
        return tree.value;
      }

    int leftValue = evaluateExpressionTree(tree.left);
    int rightValue = evaluateExpressionTree(tree.right);

    if(tree.value == -1){
      return leftValue + rightValue;
    } else if(tree.value == -2) {
      return leftValue - rightValue;
    } else if(tree.value == -3) {
      return leftValue / rightValue;
    } 
    return leftValue * rightValue;
}


class Program {
  // This is an input class. Do not edit.
  static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }
}

import java.util.*;

class ProgramTest {
  @Test
  public void TestCase1() {
    Program.BinaryTree tree = new Program.BinaryTree(-1);
    tree.left = new Program.BinaryTree(2);
    tree.right = new Program.BinaryTree(-2);
    tree.right.left = new Program.BinaryTree(5);
    tree.right.right = new Program.BinaryTree(1);
    var expected = 6;
    var actual = new Program().evaluateExpressionTree(tree);
    Utils.assertTrue(expected == actual);
  }
}
