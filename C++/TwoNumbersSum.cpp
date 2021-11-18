#include <vector>
using namespace std;

vector<int> twoNumberSum(vector<int> array, int targetSum) {
  // Write your code here.
	for (int i = 0; i < array.size() - 1; i++){
		int firstNum = array[i];
		for (int j = i + 1; j < array.size(); j++){
			int secondNum = array[j];
			if (firstNum + secondNum == targetSum) {
				return vector<int>{firstNum, secondNum};
			}
		}
	}
  return {};
}

#include <vector>
#include <unordered_set>
using namespace std;

vector<int> twoNumberSum2(vector<int> array, int targetSum) {
  // Write your code here.
	unordered_set<int> nums;
	for(int num: array){
		int potentialMatch = targetSum - num;
		if(nums.find(potentialMatch) != nums.end()) {
			return vector<int>{potentialMatch, num};
		} else {
			nums.insert(num);
		} 
	}
  return {};
}

#include <vector>
#include <unordered_set>
using namespace std;

vector<int> twoNumberSum3(vector<int> array, int targetSum) {
  // Write your code here.
	unordered_set<int> nums;
	for(int num: array){
		int potentialMatch = targetSum - num;
		if(nums.find(potentialMatch) != nums.end()) {
			return vector<int>{potentialMatch, num};
		} else {
			nums.insert(num);
		} 
	}
  return {};
} 
