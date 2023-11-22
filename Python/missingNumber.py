"""<div class="html">
  <p>
    You're given an unordered list of unique integers <span>nums</span> in the
    range <span>[1, n]</span>, where <span>n</span> represents the length of
    <span>nums + 2</span>. This means that two numbers in this range are missing
    from the list.
  </p>

  <p>
    Write a function that takes in this list and returns a new list with the two
    missing numbers, sorted numerically.
  </p>

  <h3>Sample Input</h3>
  <pre><span class="CodeEditor-promptParameter">nums</span> = [1, 4, 3]</pre>
  <h3>Sample Output</h3>
  <pre>[2, 5] <span class="CodeEditor-promptComment"> // n is 5, meaning the completed list should be [1, 2, 3, 4, 5]</span>
</pre>
</div>"""

def missingNumbers(nums):
    includedNums = set(nums)

    solution = []
    for num in range(1, len(nums) + 3):
        if not num in includedNums:
            solution.append(num)
    return solution

import program
import unittest


class TestProgram(unittest.TestCase):
    def test_case_1(self):
        input = [4, 5, 1, 3]
        expected = [2, 6]
        actual = program.missingNumbers(input)
        self.assertEqual(actual, expected)
