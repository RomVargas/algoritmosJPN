class Program {

// O(n) time | O(n) space
func twoNumberSum(_ array: inout [Int], _ targetSum: Int) -> [Int] {
    var numbersHashMap = [Int: Bool] ()
		
		for number in array {
			let potentialMatch = targetSum - number
			
			if let exists = numbersHashMap[potentialMatch], exists {
				return [potentialMatch, number]
			} else {
				numbersHashMap[number] = true
			}
		}
    return []
  }

// O(n^2) time | O(1) space
  func twoNumberSum2(_ array: inout [Int], _ targetSum: Int) -> [Int] {
    for i in 0 ..< array.count - 1 {
			let firstNumber = array[i]
			
			for j in i + 1 ..< array.count {
				let secondNumber = array[j]
				
				if firstNumber + secondNumber == targetSum {
					return [firstNumber, secondNumber]
				}
			}
		}
    return []
  }

  //  O(n) time | O(n) space
  func twoNumberSum3(_ array: inout [Int], _ targetSum: Int) -> [Int] {
    var numbersHashMap = [Int: Bool]()
		
		for number in array {
			let potentialMatch = targetSum - number
			
			if let exists = numbersHashMap[potentialMatch], exists {
				return [potentialMatch, number]
			} else {
				numbersHashMap[number] = true
			}
		}
    return []
  }
}
