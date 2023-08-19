package dsa.recursion;

import java.util.Arrays;

public class RecursionEasySolutions {
    
    public static void print1ToN(int n) {
        print1ToN(1, n);
        System.out.println();
    }

    private static void print1ToN(int noToPrint, int n) {
        if(noToPrint > n) return;

        System.out.print(noToPrint + " ");

        print1ToN(noToPrint + 1, n);
    }

    public static int findNthFibonacci(int n) {
        if(n <= 1) {
            return n;
        }
        return findNthFibonacci(n - 1) + findNthFibonacci(n - 2);
    }

    // Problem link: https://www.codechef.com/problems/FIBXOR01/?tab=statement
    public static int findNthSpecialFibonacci(int a, int b, int n) {
        if(n == 1) return b;
        if(n == 0) return a;

        return findNthSpecialFibonacci(a, b, n - 1) ^ findNthSpecialFibonacci(a, b, n - 2);
    }

    public static int findSumOfDigits(int n) {
        if(n == 0) return 0;
        return findSumOfDigits(n / 10) + n % 10;
    }

    public static int reverseNumber(int n) {
        return reverseNumber(n, 0);
    }

    private static int reverseNumber(int n, int sum) {
        if(n == 0) return sum;

        sum = sum * 10 + n % 10;

        return reverseNumber(n / 10, sum);
    }

    public static boolean checkPalindrome(int n) {

        return n == reverseNumber(n);
    }

    public static void sumTriangleFromArray(int[] arr) {
    	if(arr == null || arr.length <= 0) {
    		return;
    	}

    	int[] tempArr = new int[arr.length - 1];

        // Recursion to make the array
        makeTriangleArray(arr, tempArr, 0, 1);

        // Recursion to make the triangle
    	sumTriangleFromArray(tempArr);
    	System.out.println(Arrays.toString(arr));
    }

    private static void makeTriangleArray(int[] sourceArr, int[] destArr, int index, int nextIndexToAdd) {
        if(nextIndexToAdd >= sourceArr.length) {
            return;
        }

        destArr[index] = sourceArr[index] + sourceArr[nextIndexToAdd];

        makeTriangleArray(sourceArr, destArr, index + 1, nextIndexToAdd + 1);
    }

    public static int[] findMinMax(int[] arr) {
        MinMax minMaxObj = findMinMax(arr, arr.length - 1);

        return new int[] {minMaxObj.min(), minMaxObj.max()};
    }

    private static MinMax findMinMax(int[] arr, int idx) {
        if(idx <= 0) {
            return new MinMax(arr[0], arr[0]);
        }

        MinMax minMaxObj = findMinMax(arr, idx - 1);

        if(arr[idx] < minMaxObj.min()) {
            minMaxObj = new MinMax(arr[idx], minMaxObj.max());
        }

        if(arr[idx] > minMaxObj.max()) {
            minMaxObj = new MinMax(minMaxObj.min(), arr[idx]);
        }

        return minMaxObj;
    }

    public static int binarySearch(int[] arr, int target) {
        return binarySearch(arr, target, 0, arr.length - 1);
    }

    private static int binarySearch(int[] arr, int target, int startIdx, int endIdx) {
        if(startIdx >= endIdx) {
            return -1;
        }

        int midIdx = (startIdx + endIdx) / 2;

        if(arr[midIdx] == target) {
            return midIdx;
        } else if(arr[midIdx] > target) {
            return binarySearch(arr, target, startIdx, midIdx - 1);
        } else {
            return binarySearch(arr, target, midIdx, endIdx);
        }
    }

    public static String findFirstUpperCaseLetter(String str) {
        return findFirstUpperCaseLetter(str, 0);
    }

    private static String findFirstUpperCaseLetter(String str, int currentIdx) {
        if(currentIdx >= str.length()){
            return null;
        }

        char currentLetter = str.charAt(currentIdx);
        if(currentLetter >= 'A' && currentLetter <= 'Z') {
            return Character.toString(currentLetter);
        } else {
            return findFirstUpperCaseLetter(str, currentIdx + 1);
        }
    }

    public static String reverseString(String str) {
        return new String(reverseString(str.toCharArray(), 0, str.length() - 1));
    }

    private static char[] reverseString(char[] charArr, int startIdx, int endIdx) {
        if(startIdx >= endIdx) return charArr;

        char temp = charArr[startIdx];
        charArr[startIdx] = charArr[endIdx];
        charArr[endIdx] = temp;

        return reverseString(charArr, startIdx + 1, endIdx - 1);
    }

}

record MinMax(int min, int max){}
