"""
<div class="html">
<p>
  You're given an array of points plotted on a 2D graph (the xy-plane). Write a
  function that returns the maximum number of points that a single line (or
  potentially multiple lines) on the graph passes through.
</p>
<p>
  The input array will contain points represented by an array of two integers
  <span>[x, y]</span>. The input array will never contain duplicate points and
  will always contain at least one point.
</p>
<h3>Sample Input</h3>
<pre style="position: relative;"><span class="CodeEditor-promptParameter">points</span> = [
  [1, 1],
  [2, 2],
  [3, 3],
  [0, 4],
  [-2, 6],
  [4, 0],
  [2, 1],
]
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
<h3>Sample Output</h3>
<pre style="position: relative;">4 <span class="CodeEditor-promptComment">// A line passes through points: [-2, 6], [0, 4], [2, 2], [4, 0].</span>
<div class="open_grepper_editor" title="Edit &amp; Save To Grepper"></div></pre>
</div>
"""

def lineThroughPoints(points):
    maxNumberOfPointsOnLine = 1

    for idx1, p1 in enumerate(points):
        slopes = {}
        for idx2 in range(idx1 + 1, len(points)):
            p2 = points[idx2]
            rise, run = getSlopeOfLineBetweenPoints(p1, p2)
            slopeKey = createHashableKeyForRational(rise, run)
            if slopeKey not in slopes:
                slopes[slopeKey] = 1
    
            slopes[slopeKey] += 1
    
        maxNumberOfPointsOnLine = max(maxNumberOfPointsOnLine, max(slopes.values(), default=0))

    return maxNumberOfPointsOnLine

def getSlopeOfLineBetweenPoints(p1, p2):
    p1x, p1y = p1
    p2x, p2y = p2
    slope = [1, 0]

    if p1x != p2x:
        xDiff = p1x - p2x
        yDiff = p1y - p2y
        gcd = getGreatestCommonDivisor(abs(xDiff), abs(yDiff))
        xDiff = xDiff // gcd
        yDiff = yDiff // gcd
        if xDiff < 0:
            xDiff *= -1
            yDiff *= -1

        slope = [yDiff, xDiff]
    return slope

def createHashableKeyForRational(numerator, denominator):
    return str(numerator) + ":" + str(denominator)

def getGreatestCommonDivisor(num1, num2):
    a = num1
    b = num2
    while True:
        if a == 0:
            return b
        if b == 0:
            return a

        a, b = b, a % b
