// O(n^2) time | O(1) space
export function twoNumberSum(array: number[], targetSum: number) {
  for (let i =0; i< array.length -1 ; i++) {
		const firstNum = array[i];
		for (let j = i + 1; j < array.length; j++) {
			const secondNum = array[j];
			if(firstNum + secondNum === targetSum) {
				return [firstNum, secondNum];			}
		}
	}
  return [];
}

export function twoNumberSum2(array: number[], targetSum: number) {
  const nums: {[key: number]:  boolean} = {};
	for (const num of array) {
		const potentialMatch = targetSum - num;
		if(potentialMatch in nums) {
			return [potentialMatch, num];
		} else {
			nums[num] = true;
		}
	}
  return [];
}

export function twoNumberSum3(array: number[], targetSum: number) {
  const nums: {[key: number]:  boolean} = {};
	for (const num of array) {
		const potentialMatch = targetSum - num;
		if(potentialMatch in nums) {
			return [potentialMatch, num];
		} else {
			nums[num] = true;
		}
	}
  return [];
}