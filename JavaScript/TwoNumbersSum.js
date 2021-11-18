function twoNumberSum(array, targetSum) {
    for(let i = 0; i < array. length - 1; i++){
          const firstNum = array[i];
          for (let j = i + 1; j < array.length; j++){
              const secondNum = array[j];
              if(firstNum + secondNum === targetSum) {
                  return [firstNum, secondNum];
              }
          }
      }
      return[]
  }

function twoNumberSum2(array, targetSum) {
  array.sort((a,b) => a - b);
	let left = 0;
	let right = array.length -1;
	while(left < right) {
		const currentSum = array[left] + array[right];
		if (currentSum === targetSum) {
			return [array[left], array[right]];
		} else if(currentSum < targetSum){
			left++;
		} else if (currentSum > targetSum) {
			right--;
		}
	}
	return [];
}

function twoNumberSum(array, targetSum) {
  const nums = {};
	for (const num of array) {
		const potentialMatch = targetSum - num;
		if (potentialMatch in nums){
			return [potentialMatch, num];
		} else {
			nums[num] = true;
		}
	}
	return[];
}



// Do not edit the line below.
exports.twoNumberSum = twoNumberSum;