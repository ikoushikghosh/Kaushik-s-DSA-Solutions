package dsa.carrayforward;

public class CarryForwardSolutions {
    
    public static int countNoOfPairsOfGivenChars(String str, char firstChar, char secondChar) {
    	char[] arr = str.toCharArray();
    	int count = 0;
    	int firstCharCount = 0;
    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i] == firstChar) {
    			firstCharCount += 1;
    		}

    		if(arr[i] == secondChar) {
    			count += firstCharCount;
    		}
    	}

    	return count; // TC: O(n) SC: O(1)
    }
    // [b, a, a, g, d, c, a, g] (a, g)
    // fc = 3
    // count = 5

    public static int countLeaderElementsInArray(int[] arr) {
    	// Leader element is the element which is greater than all elements of it's left side

    	int leaderElement = arr[0];
    	int count = 1;

    	for(int i = 1; i < arr.length; i++) {
    		if(arr[i] > leaderElement) {
    			leaderElement = arr[i];
    			count++;
    		}
    	}

    	return count; // TC: O(n) SC: O(1)
    }
    // [3, 2, 4, 5, 2, 7, -1, 15]
    // le => 15
    // count => 5

    public static int countSwitchToLightAllBulbs(int[] arr) {
    	// 0 -> off , 1 -> on
    	// the intution of the problem to solve it in optimal way is:
    	// 1. if we press switch odd no. of times then it's initial status will be change, i.e. if it ON, it will OFF or vice versa
    	// 2. if we press switch even no. of times then it's initial status will remain same, i.e. if it is ON, it will ON or vice versa
    	int count = 0;
    	for(int i = 0; i < arr.length; i++) {
    		if((arr[i] == 0 && count % 2 == 0) || (arr[i] == 1 && count % 2 == 1)) {
    			count++;
    		}
    	}

    	return count; // TC: O(n) SC: O(1)
    }
    // [0, 1, 1, 0, 1, 0]
    // count = 5

    public static int findClosestMinMax(int[] arr) {
    	int min = arr[0];
    	int max = arr[0];

    	for(int i = 1; i < arr.length; i++) {
    		if(arr[i] < min) {
    			min = arr[i];
    		}

    		if(arr[i] > max) {
    			max = arr[i];
    		}
    	}

    	int ans = arr.length;
    	int minIdx = -1, maxIdx = -1;

    	for(int i = 0; i < arr.length; i++) {
    		if(arr[i] == min) {
    			minIdx = i;
    		} else if(arr[i] == max) {
    			maxIdx = i;
    		}

    		if(minIdx >= 0 && maxIdx >= 0) {
    			int currentSubArrayLength = Math.abs(minIdx - maxIdx) + 1;
    			if(currentSubArrayLength < ans) {
    				ans = currentSubArrayLength;
    			}
    		}
    	}

    	return ans; // TC: O(n) SC: O(1)
    }

    public static int maxProfitToBuyAndSellStock(int[] arr) {
    	int maxProfit = 0;
    	int minBuyPrice = Integer.MAX_VALUE;

    	for(int i = 1; i < arr.length; i++) {
    		if(arr[i] < minBuyPrice) {
    			minBuyPrice = arr[i];
    		}

    		int currentProfit = arr[i] - minBuyPrice;
    		if(currentProfit > maxProfit) {
    			maxProfit = currentProfit;
    		}
    	}

    	return maxProfit; // TC: O(n) SC: O(1)
    }

    public static int countSubStringsStartingWithGivenChar(String str, char startsWith) {
    	char[] charArr = str.toCharArray();

    	int ans = 0;
    	int countOfStartChar = 0;
    	for(int i = 0; i < charArr.length; i++) {
    		if(charArr[i] == startsWith) {
    			countOfStartChar++;
    		}
    		ans += countOfStartChar; 
    	}

    	return ans; // TC: O(n) SC: O(1)
    }

    public static int maxSumByPickFromBothSides(int[] arr, int noOfElementsToPick) {
    	int arrLength = arr.length;

    	// build prefix sum for leftside pickup sum
    	int[] preSumArr = new int[arrLength];
    	preSumArr[0] = arr[0];

    	for(int i = 1; i < arrLength; i++) {
    		preSumArr[i] = preSumArr[i - 1] + arr[i];
    	}

    	// build suffixsum for rightside pickup sum
    	int[] sufSumArr = new int[arrLength];
    	sufSumArr[arrLength - 1] = arr[arrLength - 1];

    	for(int j = arrLength - 2; j >= 0; j--) {
    		sufSumArr[j] = sufSumArr[j + 1] + arr[j];
    	}

    	// initialize maxsum with either all pickup from left or all pickup from right - which is max
    	int ans = Math.max(preSumArr[noOfElementsToPick - 1], sufSumArr[arrLength - noOfElementsToPick]);

    	for(int k = 1; k < noOfElementsToPick; k++) {
    		int currentSum = preSumArr[k - 1] + sufSumArr[arrLength - (noOfElementsToPick - k)];

    		ans = Math.max(currentSum, ans);
    	}

    	return ans; // TC: O(n) SC: O(n)
    }

}
