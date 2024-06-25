"""
<div class="html">
<p>
  You're given a two-dimensional array (a matrix) of potentially unequal height
  and width containing only <span>0</span>s and <span>1</span>s. Each
  <span>0</span> represents land, and each <span>1</span> represents part of a
  river. A river consists of any number of <span>1</span>s that are either
  horizontally or vertically adjacent (but not diagonally adjacent). The number
  of adjacent <span>1</span>s forming a river determine its size.
</p>
<p>
  Note that a river can twist. In other words, it doesn't have to be a straight
  vertical line or a straight horizontal line; it can be L-shaped, for example.
</p>
<p>
  Write a function that returns an array of the sizes of all rivers represented
  in the input matrix. The sizes don't need to be in any particular order.
</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">matrix</span> = [
  [1, 0, 0, 1, 0],
  [1, 0, 1, 0, 0],
  [0, 0, 1, 0, 1],
  [1, 0, 1, 0, 1],
  [1, 0, 1, 1, 0],
]
</pre>
<h3>Sample Output</h3>
<pre>[1, 2, 2, 2, 5] <span class="CodeEditor-promptComment">// The numbers could be ordered differently.</span>

<span class="CodeEditor-promptComment">// The rivers can be clearly seen here:</span>
<span class="CodeEditor-promptComment">// [</span>
<span class="CodeEditor-promptComment">//   [1,  ,  , 1,  ],</span>
<span class="CodeEditor-promptComment">//   [1,  , 1,  ,  ],</span>
<span class="CodeEditor-promptComment">//   [ ,  , 1,  , 1],</span>
<span class="CodeEditor-promptComment">//   [1,  , 1,  , 1],</span>
<span class="CodeEditor-promptComment">//   [1,  , 1, 1,  ],</span>
<span class="CodeEditor-promptComment">// ]</span>
</pre>
</div>
"""

def riverSizes(matrix):
    """
    The function `riverSizes` takes a matrix representing a map with land and water, and returns a list
    of sizes of all river networks in the map.
    
    :param matrix: It seems like you have not provided the matrix parameter for the `riverSizes`
    function. Could you please provide the matrix parameter so that I can assist you further with the
    implementation of the `riverSizes` function?
    :return: The function `riverSizes` returns a list of sizes of rivers in the given matrix.
    """
    sizes = []
    visited = [[False for value in row] for row in matrix]
    for i in range(len(matrix)):
        for j in range(len(matrix[i])):
            if visited[i][j]:
                continue
            traverseNode(i, j, matrix, visited, sizes)
    return sizes


def traverseNode(i, j, matrix, visited, sizes):
    """
    The function `traverseNode` iterates through a matrix to find river sizes by exploring neighboring
    nodes.
    
    :param i: The `i` parameter in the `traverseNode` function represents the row index of the current
    node in the matrix that is being traversed. It is used to keep track of the current position within
    the matrix
    :param j: The parameter `j` in the `traverseNode` function represents the column index of the
    current node in the matrix. It is used to keep track of the current position within the matrix while
    traversing the nodes
    :param matrix: Matrix is a 2D array representing a grid where each cell can contain either a 0 or a
    1. A value of 1 in a cell represents a river, while a value of 0 represents land
    :param visited: The `visited` parameter is a 2D boolean array that keeps track of whether a cell in
    the matrix has been visited during the traversal process. It helps in avoiding revisiting the same
    cell multiple times and getting stuck in an infinite loop
    :param sizes: The `sizes` parameter in the `traverseNode` function is a list that is used to store
    the sizes of rivers found during the traversal of the matrix. Each time a river is traversed, its
    size is calculated and added to this list for further processing or analysis
    """
    currentRiverSize = 0 
    nodesToExplore = [[i, j]]
    while len(nodesToExplore):
        currentNode = nodesToExplore.pop()
        i = currentNode[0]
        j = currentNode[1]
        if visited[i][j]:
            continue
        visited[i][j] = True
        if matrix[i][j] == 0:
            continue
        currentRiverSize += 1
        unvisitedNeighbors = getUnvisitedNeighbors(i, j, matrix, visited)
        for neighbor in unvisitedNeighbors:
            nodesToExplore.append(neighbor)
    if currentRiverSize > 0:
        sizes.append(currentRiverSize)


def getUnvisitedNeighbors(i, j, matrix, visited):
    """
    The function `getUnvisitedNeighbors` returns a list of unvisited neighboring cells in a matrix based
    on the current cell's position and the visited status of each cell.
    
    :param i: The parameter `i` in the `getUnvisitedNeighbors` function represents the row index of the
    current cell in the matrix. It is used to determine the row position of the neighboring cells to
    check for unvisited neighbors
    :param j: The parameter `j` in the `getUnvisitedNeighbors` function represents the column index of
    the current cell in the matrix. It is used to determine the neighbors of the cell by checking the
    adjacent cells in the same column (above and below) for unvisited cells
    :param matrix: It seems like you were about to provide more information about the `matrix` parameter
    but it got cut off. Could you please provide more details or context about the `matrix` parameter so
    that I can assist you further with the `getUnvisitedNeighbors` function?
    :param visited: The `visited` parameter is a 2D boolean matrix that keeps track of which cells in
    the grid have been visited. Each element in the matrix corresponds to a cell in the grid, and if the
    value is `True`, it means that cell has been visited. The function `getUnvisited
    :return: The function `getUnvisitedNeighbors` returns a list of coordinates representing the
    unvisited neighbors of a cell at position (i, j) in a matrix.
    """
    unvisitedNeighbors = []
    if i > 0 and not visited[i - 1][j]:
        unvisitedNeighbors.append([i - 1, j])
    if i < len(matrix) - 1 and not visited[i + 1][j]:
        unvisitedNeighbors.append([i + 1, j])
    if j > 0 and not visited[i][j - 1]:
        unvisitedNeighbors.append([i, j - 1])
    if j < len(matrix[0]) - 1 and not visited[i][j + 1]:
        unvisitedNeighbors.append([i, j + 1])
    return unvisitedNeighbors
