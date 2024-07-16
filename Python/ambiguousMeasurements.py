import ipdb;

"""
<div class="html">
<p>
  This problem deals with measuring cups that are missing important measuring
  labels. Specifically, a measuring cup only has two measuring lines, a Low (L)
  line and a High (H) line. This means that these cups can't precisely measure
  and can only guarantee that the substance poured into them will be between the
  L and H line. For example, you might have a measuring cup that has a Low line
  at <span>400ml</span> and a high line at <span>435ml</span>. This means that
  when you use this measuring cup, you can only be sure that what you're
  measuring is between <span>400ml</span> and <span>435ml</span>.
</p>
<p>
  You're given a list of measuring cups containing their low and high lines as
  well as one <span>low</span> integer and one <span>high</span> integer
  representing a range for a target measurement. Write a function that returns a
  boolean representing whether you can use the cups to accurately measure a
  volume in the specified <span>[low, high]</span> range (the range is
  inclusive).
</p>
<p>Note that:</p>
<ul>
  <li>
    Each measuring cup will be represented by a pair of positive integers
    <span>[L, H]</span>, where <span>0 &lt;= L &lt;= H</span>.
  </li>
  <li>
    You'll always be given at least one measuring cup, and the
    <span>low</span> and <span>high</span> input parameters will always satisfy
    the following constraint: <span>0 &lt;= low &lt;= high</span>.
  </li>
  <li>
    Once you've measured some liquid, it will immediately be transferred to a
    larger bowl that will eventually (possibly) contain the target measurement.
  </li>
  <li>You can't pour the contents of one measuring cup into another cup.</li>
</ul>
<p></p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">measuringCups</span> = [
  [200, 210],
  [450, 465],
  [800, 850],
] 
<span class="CodeEditor-promptParameter">low</span> = 2100
<span class="CodeEditor-promptParameter">high</span> = 2300
</pre>
<h3>Sample Output</h3>
<pre>true
<span class="CodeEditor-promptComment">// We use cup [450, 465] to measure four volumes:</span>
<span class="CodeEditor-promptComment">// First measurement: Low = 450, High = 465</span>
<span class="CodeEditor-promptComment">// Second measurement: Low = 450 + 450 = 900, High = 465 + 465 = 930</span>
<span class="CodeEditor-promptComment">// Third measurement: Low = 900 + 450 = 1350, High = 930 + 465 = 1395</span>
<span class="CodeEditor-promptComment">// Fourth measurement: Low = 1350 + 450 = 1800, High = 1395 + 465 = 1860</span>

<span class="CodeEditor-promptComment">// Then we use cup [200, 210] to measure two volumes:</span>
<span class="CodeEditor-promptComment">// Fifth measurement: Low = 1800 + 200 = 2000, High = 1860 + 210 = 2070</span>
<span class="CodeEditor-promptComment">// Sixth measurement: Low = 2000 + 200 = 2200, High = 2070 + 210 = 2280</span>

<span class="CodeEditor-promptComment">// We've measured a volume in the range [2200, 2280].</span>
<span class="CodeEditor-promptComment">// This is within our target range, so we return `true`.</span>

<span class="CodeEditor-promptComment">// Note: there are other ways to measure a volume in the target range.</span>
</pre>
</div>
"""

def ambiguousMeasurements(measuringCups, low, high):
    """
    The `ambiguousMeasurements` function uses memoization to determine if a range can be measured using
    a given set of measuring cups.
    
    :param measuringCups: The `measuringCups` parameter is a list of tuples, where each tuple represents
    a measuring cup with two values: the lower bound and the upper bound of the amount it can measure.
    For example, `measuringCups = [(1, 3), (2, 5),
    :param low: The `low` parameter in the `ambiguousMeasurements` function represents the lower bound
    of the range that you want to measure. It is used to determine if there is a combination of
    measuring cups that can measure a quantity within the specified range
    :param high: The `high` parameter in the `ambiguousMeasurements` function represents the upper limit
    of the range that you want to measure. It is used to determine if there is a combination of
    measuring cups that can measure a quantity within the specified range
    :return: The code provided is a Python function that uses memoization to determine if a range of
    measurements can be achieved using a given set of measuring cups. The function
    `ambiguousMeasurements` takes in a list of measuring cups, a low measurement, and a high measurement
    as input parameters. It then initializes a memoization dictionary and calls the `canMeasureInRange`
    function with these parameters.
    """
    memoization = {}
    return canMeasureInRange(measuringCups, low, high, memoization)

def canMeasureInRange(measuringCups, low, high, memoization):
    """
    The function `canMeasureInRange` recursively determines if a range can be measured using given
    measuring cups within specified low and high limits, utilizing memoization for efficiency.
    
    :param measuringCups: Measuring cups is a list of tuples where each tuple represents a measuring cup
    with two values - the lower limit and the upper limit of the cup's capacity. For example, a
    measuring cup with a capacity of 3 to 5 units would be represented as (3, 5)
    :param low: The `low` parameter in the `canMeasureInRange` function represents the lower bound of
    the range within which you want to check if you can measure a certain amount using the measuring
    cups. It is used to determine the minimum amount that needs to be measured
    :param high: The `high` parameter in the `canMeasureInRange` function represents the upper limit of
    the range within which you are trying to measure. It is used to determine if a combination of
    measuring cups can measure a quantity within the specified range
    :param memoization: Memoization is a technique used in dynamic programming to store the results of
    expensive function calls and reuse them later to avoid redundant computations. In this context, the
    `memoization` parameter is likely a dictionary that stores previously computed results for different
    ranges of low and high values. This helps improve the efficiency of
    :return: The function `canMeasureInRange` is returning the boolean value `canMeasure`, which
    indicates whether it is possible to measure a range within the given measuring cups and constraints.
    """
    ipdb.set_trace();
    memoizeKey = createHashableKey(low, high)
    if memoizeKey in memoization:
        return memoization[memoizeKey]

    if low <= 0 and high <= 0:
        return False

    canMeasure = False
    for cup in measuringCups:
        cupLow, cupHigh = cup
        if low <= cupLow and cupHigh <= high:
            canMeasure = True
            break

       # The lines `newLow = max(0, low - cupLow)` and `newHigh = max(0, high - cupHigh)` in the
       # `canMeasureInRange` function are calculating the remaining range after subtracting the
       # capacity of the current measuring cup.
        newLow = max(0, low - cupLow)
        newHigh = max(0, high - cupHigh)
        canMeasure = canMeasureInRange(measuringCups, newLow, newHigh, memoization)
        if canMeasure:
            break

    memoization[memoizeKey] = canMeasure
    return canMeasure

def createHashableKey(low, high):
    return str(low) + ":" + str(high)

measuringCups= [
  [200, 210],
  [450, 465],
  [800, 850]
]

print(ambiguousMeasurements(measuringCups, 2100, 2300))