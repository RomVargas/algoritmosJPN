"""
<div class="html">
  <p>
    You're given the position of two knight pieces on an infinite chess board.
    Write a function that returns the minimum number of turns required before
    one of the knights is able to capture the other knight, assuming the knights
    are working together to achieve this goal.
  </p>

  <p>
    The position of each knight is given as a list of 2 values, the x and y
    coordinates. A knight can make 1 of 8 possible moves on any given turn. Each
    of these moves involves moving in an "L" shape. This means they can either
    move 2 squares horizontally and 1 square vertically, or they can move 1
    square horizontally and 2 squares vertically. For example, if a knight is
    currently at position [0, 0], then it can move to any of these 8 locations
    on its next move:
  </p>

  <pre>[
  [-2, 1], [-1, 2], [1, 2], [2, 1], [2, -1], [1, -2], [-1, -2], [-2, -1]
]</pre>

  <p>
    A knight is able to capture the other knight when it is able to move onto
    the square currently occupied by the other knight.
  </p>

  <p>
    Each turn allows each knight to move up to one time. For example, if both
    knights moved towards each other once, and then knightA captures knightB on
    its next move, two turns would have been used (even though knightB never
    made its second move).
  </p>
  <h3>Sample Input</h3>
  <pre><span class="CodeEditor-promptParameter">knightA</span> = [0, 0]
<span class="CodeEditor-promptParameter">knightB</span> = [4, 2]</pre>
  <h3>Sample Output</h3>
  <pre>1 <span class="CodeEditor-promptComment">// knightA moves to [2, 1], knightB captures knightA on [2, 1]
</span>
</pre>
</div>
"""

def knightConnection(knightA, knightB):
    dx, dy = abs(knightA[0] - knightB[0]), abs(knightA[1] - knightB[1])
    if dx < dy:
        dx, dy = dy, dx
    if dx * dy == 1:
        return 1
    if (dx, dy) in [(1, 0), (2, 2)]:
        return 2
    t = dy - dx // 2 - dx % 2 * 2
    return (1 + dx // 4 * 2 + dx % 4 + (t // 3 + t % 3 - dx // 2 % 2 if t >= 0 else (1 - dx // 2 % 2 * 2) * (dy % 2))) // 2