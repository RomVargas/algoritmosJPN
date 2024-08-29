"""
<div class="html">
<p>
  Write a function that takes in a list of Cartesian coordinates (i.e., (x, y)
  coordinates) and returns the number of squares that can be formed by these
  coordinates.
</p>
<p>
  A square must have its four corners amongst the coordinates in order to be
  counted. A single coordinate can be used as a corner for multiple different
  squares.
</p>
<p>
  You can also assume that no coordinate will be farther than 100 units from the
  origin.
</p>

<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">points</span> = [
  [1, 1],
  [0, 0],
  [-4, 2],
  [-2, -1],
  [0, 1],
  [1, 0],
  [-1, 4]
]</pre>
<h3>Sample Output</h3>
<pre>2 <span class="CodeEditor-promptComment"> // [1, 1], [0, 0], [0, 1], and [1, 0] makes a square,
// as does [1, 1], [-4, 2], [-2, -1], and [-1, 4]</span></pre></div>
"""

def countSquares(points):
    pointsSet = set()
    for point in points:
        pointsSet.add(pointToString(point))

    count = 0
    for pointA in points:
        for pointB in points:
            if pointA == pointB:
                continue

            midpoint = [(pointA[0] + pointB[0]) / 2, (pointA[1] + pointB[1]) / 2]
            xDistanceFromMid = pointA[0] - midpoint[0]
            yDistanceFromMid = pointA[1] - midpoint[1]

            pointC = [midpoint[0] + yDistanceFromMid, midpoint[1] - xDistanceFromMid]
            pointD = [midpoint[0] - yDistanceFromMid, midpoint[1] + xDistanceFromMid]

            if pointToString(pointC) in pointsSet and pointToString(pointD) in pointsSet:
                count += 1

    return count / 4

def pointToString(point):
    # Verificar si ambas coordenadas del punto son números enteros
    if point[0] % 1 == 0 and point[1] % 1 == 0:
        # Convertir las coordenadas a enteros si son números enteros
        point = (int(coordinate) for coordinate in point)
    # Convertir las coordenadas a cadenas y unirlas con una coma
    return ",".join([str(coordinate) for coordinate in point])



