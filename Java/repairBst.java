import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <div class="html">
  <p>
    You're given a Binary Search Tree (BST) that has at least 2 nodes and that
    only has nodes with unique values (no duplicate values). Exactly two nodes
    in the BST have had their values swapped, therefore breaking the BST. Write
    a function that returns a repaired version of the tree with all values on
    the correct nodes.
  </p>
  <p>
    Your function can mutate the original tree; you do not need to create a new
    one. Moreover, the shape of the returned tree should be exactly the same as
    that of the original input tree.
  </p>
  <p>
    Each <span>BST</span> node has an integer <span>value</span>, a
    <span>left</span> child node, and a <span>right</span> child node. A node is
    said to be a valid <span>BST</span> node if and only if it satisfies the BST
    property: its <span>value</span> is strictly greater than the values of
    every node to its left; its <span>value</span> is less than or equal to the
    values of every node to its right; and its children nodes are either valid
    <span>BST</span> nodes themselves or <span>None</span> / <span>null</span>.
  </p>
  <h3>Sample Input</h3>
  <pre style="position: relative;"><span class="CodeEditor-promptParameter">tree</span> =    10
        /     \
       7       20
     /   \    /  \
   3     12  8   22
  /           \
2              14
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
  <h3>Sample Output</h3>
  <pre style="position: relative;">          10
        /     \
       7       20
     /   \    /  \
   3      8  12   22
  /           \
2              14
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
</div>
 */
public class repairBst {
    static class BST {
    public int value;
    public BST left = null;
    public BST right = null;

    public BST(int value) {
      this.value = value;
    }
  }
    
    
  public static void main(String[] args){
    repairBst test = new repairBst();
    BST prueba = test.mainRepairBst(new BST(1));
    BST prueba2 = test.mainRepairBst(new BST(2));
    List<BST> arbol = new ArrayList<BST>();
    arbol.add(prueba);
    arbol.add(prueba2);
    System.out.println(prueba.value);
  }

  private BST nodeOne = new BST(1), nodeTwo = new BST(2), previousNode = new BST(0);

  public BST mainRepairBst(BST tree) {
    this.inOrderTraversal(tree);
    int tempNodeOneValue = nodeOne.value;
    nodeOne.value = nodeTwo.value;
    nodeTwo.value = tempNodeOneValue;

    return tree;
  }

  private void inOrderTraversal(BST node) {
    if (node == null) {
      return;
    }
    inOrderTraversal(node.left);

    if(this.previousNode != null && this.previousNode.value > node.value){
      if(this.nodeOne == null) {
        this.nodeOne = this.previousNode;
      }
      this.nodeTwo = node;
    }
    this.previousNode = node;
    inOrderTraversal(node.right);
  }
}
