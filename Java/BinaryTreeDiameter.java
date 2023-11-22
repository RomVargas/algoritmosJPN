public class BinaryTreeDiameter {
    static class BinaryTree {
    public int value;
    public BinaryTree left = null;
    public BinaryTree right = null;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public int binaryTreeDiameter(BinaryTree tree) {
    return getTreeInfo(tree).diameter;
  }

  public TreeInfo getTreeInfo(BinaryTree tree) {
    if (tree == null){
      return new TreeInfo(0,0);
    }

    TreeInfo leftTreeInfo = getTreeInfo(tree.left);
    TreeInfo rightTreeInfo = getTreeInfo(tree.right);

    int longestPathThroughtRoot = leftTreeInfo.height + rightTreeInfo.height;
    int maxDiameterSoFar = Math.max(leftTreeInfo.diameter, rightTreeInfo.diameter);
    int currentDiameter = Math.max(longestPathThroughtRoot, maxDiameterSoFar);
    int currentHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);

    return new TreeInfo(currentDiameter, currentHeight);
  }

  static class TreeInfo {
    public int diameter;
    public int height;

    public TreeInfo(int diameter, int height) {
      this.diameter = diameter;
      this.height = height;
    }
  }
}
