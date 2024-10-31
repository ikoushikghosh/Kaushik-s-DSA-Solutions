package org.koushik.dsa.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraySolutions {

    public static void main(String[] args) {
        getSmallestPositiveIntGreaterThanZeroNotInArr(new int[] {1, 2, 3});
        countElementsHavingGreaterElementsInArr(new int[] {-3, 2, 6, 8, 4, 8, 5});
        checkPairExistsHavingSumEqualsToK(new int[] {1, 2, 3, 4}, 7);
        reverseArray(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
        reversePartArray(new int[] {-3, 4, 2, 8, 7, 9, 6, 2}, 3, 6);
        rotateArrayKTimesTowardsRight(new int[] {1, 2, 3, 4, 5, 6, 7}, 4);
    }

    public static void getSmallestPositiveIntGreaterThanZeroNotInArr(int[] array) {
        int max = Integer.MIN_VALUE;
        int result = 0;
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < array.length; i++) {
            set.add(array[i]);
            if(array[i] > max) {
                max = array[i];
            }
        }

        if(max < 0) {
            result = 1;
        } else {
            for(int i = 1; i <= max; i++) {
                if(!set.contains(i)) {
                    result = i;
                    break;
                }
            }

            if(result == 0) {
                result = max + 1;
            }
        }

        System.out.printf("Smallest positive integer not present in array is %d%n", result);
    } // TC: O(n) & SC: O(n)

    public static void countElementsHavingGreaterElementsInArr(int[] array) {
        int max = Integer.MIN_VALUE;
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
            }
        }

        for(int j = 0; j < array.length; j++) {
            if(array[j] < max) {
                count++;
            }
        }

        System.out.printf("Total count of elements having at least one greater element in array is  %d%n", count);
    } // TC: O(n) & SC: O(n)

    public static void checkPairExistsHavingSumEqualsToK(int[] array, int k) {
        // Approach 01: TC = O(n^2) & SC = O(1)
        /* for(int i = 0; i < array.length; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[i] + array[j] == k) {
                    System.out.printf("The pair exists at (%d, %d) in array having sum %d%n", i, j, k);
                    return;
                }
            }
        }
        System.out.printf("There are no pair exists in array having sum %d%n", k);*/

        // Approach 02: TC = O(n) & SC = O(n)
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < array.length; i++) {
            if(set.contains(k - array[i])) {
                System.out.printf("The pair exists in array having sum %d%n", k);
                return;
            } else {
                set.add(array[i]);
            }
        }

        System.out.printf("There are no pair exists in array having sum %d%n", k);

    }

    public static void reverseArray(int[] array){
        int startIdx = 0;
        int endIdx = array.length - 1;

        swapElements(array, startIdx, endIdx);

        System.out.printf("Reversed array is %s%n", Arrays.toString(array));
    } // TC: O(n) & SC: O(1)

    public static void reversePartArray(int[] array, int startIdx, int endIdx) {
        swapElements(array, startIdx, endIdx);

        System.out.printf("Reversed part of array from %d to %d is %s%n", startIdx, endIdx, Arrays.toString(array));
    } // TC: O(n) & SC: O(1)

    public static void rotateArrayKTimesTowardsRight(int[] array, int k) {
        // limit k no. of rotation - max. rotation possible
        int rotation = k % array.length;

        // reverse the whole array
        reverseArray(array);

        // reverse the first k elements
        reversePartArray(array, 0, rotation - 1);

        // reverse rest of (n - k) elements of array
        reversePartArray(array, rotation, array.length - 1);

        System.out.printf("Rotated array after %d rotation is %s%n", rotation, Arrays.toString(array));
    } // TC: O(n) & SC: O(1)

    private static void swapElements(int[] array, int startIdx, int endIdx) {
        while (startIdx < endIdx) {
            int temp = array[startIdx];
            array[startIdx++] = array[endIdx];
            array[endIdx--] = temp;
        }
    }
}
