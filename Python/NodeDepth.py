def nodeDepths(root, depth=0):
    """
    We're going to use a stack to store tuples of (node, depth). 
    Then, as we iterate over the stack we add the depth to a running sum and push the child nodes to the
    stack with depths that are incremented by 1.
    
    :param root: The root node of the binary tree
    :param depth: the depth of the node, defaults to 0 (optional)
    :return: The sum of all the depths of the nodes in the tree.
    """
    if root is None:
        return 0
    return depth + nodeDepths(root.left, depth + 1) + nodeDepths(root.right, depth + 1)

def nodeDepths2(root):
    sumOfDepths = 0
    stack = [{"node": root, "depth":0}]
    while len(stack) > 0:
        nodeInfo = stack.pop()
        node, depth = nodeInfo["node"], nodeInfo["depth"]
        if node is None:
            continue
        sumOfDepths += depth
        stack.append({"node": node.left, "depth": depth + 1})
        stack.append({"node": node.right, "depth": depth + 1})
    return sumOfDepths    

# This is the class of the input binary tree.
class BinaryTree:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None
