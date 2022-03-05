import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraysLeetCode {
	public static void main(String[] args) {
		int[] prices = {4,9,5};
		int[] nums2 = {9,4,9,8,4};
		System.out.println(intersection(prices, nums2));;
	}
	
	/**
	 * Given two integer arrays nums1 and nums2, return an array of their intersection. 
	 * Each element in the result must be unique and you may return the result in any order.
	 */
	// Using ArrayList
	public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        int result[] = null;
        int i = 0;
        int j = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i<nums1.length && j<nums2.length) {
        	if(nums1[i] == nums2[j]) {
        		set.add(nums1[i]);
        		i++;
        		j++;
        	}
        	else if(nums1[i] < nums2[j]) {
        		i++;
        	}
        	else if(nums2[j] < nums1[i]) {
        		j++;
        	}
        }
        result = new int[set.size()];
        int k=0;
        for(int m : set) {
        	result[k++] = m;
        }
        return result;
    }
	// Using Binary Search
	public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }
    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
    //Using HashSet
    public static int[] intersection3(int[] nums1, int[] nums2) {
    	HashSet<Integer> set = new HashSet<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        //Add all elements to set from array 1
        for(int i =0; i< nums1.length; i++) set.add(nums1[i]);
        for(int j = 0; j < nums2.length; j++) {
           // If present in array 2 then add to res and remove from set 
           if(set.contains(nums2[j])) {
                res.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }
        // Convert ArrayList to array
        int[] arr = new int[res.size()];
        for (int i= 0; i < res.size(); i++) arr[i] = res.get(i);
        return arr;
    }
	
	/**
	 * Given an integer array nums, move all 0's to the end of it while maintaining 
	 * the relative order of the non-zero elements.
	 * Note that you must do this in-place without making a copy of the array. 
	 */
	public void moveZeroes(int[] nums) {
		// Copy an array.
        int[] copy = new int[nums.length];
        int counter =0;
        // copy the elements and count the number of zeros.
        for(int i=0; i<copy.length; i++) {
        	copy[i] = nums[i];
        	if(nums[i] == 0) {
        		counter++;
        	}
        }
        int pointer = 0;
        // move back the elements to the front.
        // 
        for(int i=0; i<nums.length; i++) {
        	if(copy[i] == 0) {
        		continue;
        	}
        	nums[pointer] = nums[i];
        	pointer++;
        }
        // populate the zeros at the end
        for(; pointer<nums.length; pointer++) {
        	nums[pointer] =0;
        }
    }
	//Method 2
	public void moveZeroes2(int[] nums) {
		int[] withoutZeros = new int[nums.length];
		int pointer = 0;
		// Copy only the elements
		for(int i=0; i<nums.length; i++) {
			if(nums[i] == 0) {
				continue;
			}
			withoutZeros[pointer] = nums[i];
			pointer++;
		}
		 for(int i=0; i<withoutZeros.length; i++) {
	        	nums[i] = withoutZeros[i];
	        }
		 for(int i=withoutZeros.length; i<nums.length; i++) {
	        	nums[i] = 0;
	        }
	}
	
	// Third method
	// Function to move all zeros present in the array to the end
    public static void moveZeros3(int[] A)
    {
        // `k` stores the index of the next available position
        int k = 0;
        // do for each element
        for (int i: A)
        {
            // if the current element is non-zero, put the element at the
            // next free position in the array
            if (i != 0) {
                A[k++] = i;
            }
        }
        // move all 0's to the end of the array (remaining indices)
        for (int i = k; i < A.length; i++) {
            A[i] = 0;
        }
    }
	
	
	/**
	 * Given an array nums containing n distinct numbers in the range [0, n], 
	 * return the only number in the range that is missing from the array.
	 */
	public int missingNumber(int[] nums) {
		// Sorting an array
        Arrays.sort(nums);
        if(nums[0] != 0){
            return 0;
        }
        for(int i=0; i<nums.length-1; i++){
        	// If an element is found whose difference is not 1, then add 1 to it and return.
            if(nums[i+1]-nums[i] != 1){
                return nums[i] + 1;
            }
        }
        // Else return the element at the last.
        return nums[nums.length-1]+1;
    }
	// Another solution using sum of n numbers.
	 public int missingNumber1(int[] nums) {
	        int expectedSum = nums.length * (nums.length + 1) / 2;
	        int actualSum = 0;
	        for (int num : nums) {
	            actualSum += num;
	        }
	        return expectedSum - actualSum;
	    }
	 // Using XOR
	 public int missingNumber2(int[] nums) {
	        int missing = nums.length;
	        for (int i = 0; i < nums.length; i++) {
	            missing = missing ^ i ^ nums[i];
	        }
	        return missing;
	    }
	
	
	/**
	 * You are given a sorted unique integer array nums.

	   Return the smallest sorted list of ranges that cover all the numbers in 
	   the array exactly. That is, each element of nums is covered by exactly one 
	   of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
	 * @param nums
	 * @return
	 */
	public static List<String> summaryRanges(int[] nums) {
		List<String> ranges = new ArrayList<>();
		int from = 0;
		int to = 0;
		for(int i=0; i<nums.length; i++) {
			from = i;
			while(i<nums.length-1 && nums[i+1]-nums[i]==1) {
				i++;
			}
			to = i;
			if(from == to) {
				ranges.add(nums[from]+"");
			}
			else {
				ranges.add(nums[from] + "->" + nums[to]);
			}
		}
		return ranges;
	}
	
	// Brute Force Algorithm
	 public boolean containsDuplicate(int[] nums) {
	        for(int i=0; i<nums.length-1; i++){
	            for(int j=i+1; j<nums.length; j++){
	                if(nums[j] == nums[i]){
	                    return true;
	                }
	            }
	        }
	          return false;
	    }

	/**
	 * Given an array nums of size n, return the majority element.
	   The majority element is the element that appears more than 
	   n / 2 times. You may assume that the majority element always 
	   exists in the array.
	 */
	public int majorityElement(int[] nums) {
		// check whether `nums[i]` is a majority element or not
		int n = nums.length;
		for (int i = 0; i <= n/2; i++)
		{
			int count = 1;
			for (int j = i + 1; j < n; j++)
			{
				if (nums[j] == nums[i]) {
					count++;
				}
			}

			if (count > n/2) {
				return nums[i];
			}
		}
		return -1;
	}

	/**
	 * Given a non-empty array of integers nums, every element appears 
	 * twice except for one. Find that single one.
		You must implement a solution with a linear 
		runtime complexity and use only constant extra space.
	 */
	// Solution is based on the XOR property.
	// XOR of two numbers is 0. This means all the pairs will result in
	// 0 and only one number will be left, that is the result.
	public int singleNumber(int[] nums) {
		int result = 0;
		for(int i=0; i<nums.length; i++) {
			result = result ^ nums[i];
		}
		return result;
	}

	/**
	 * You are given an array prices where prices[i] is the price of 
	 * a given stock on the ith day.You want to maximize your profit 
	 * by choosing a single day to buy one stock and choosing a different 
	 * day in the future to sell that stock.
	 * @param prices
	 * @return
	 */
	// Input: prices = [7,1,5,3,6,4]
	// Output: 5
	// Brute Force approach
	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		for(int i=0; i<prices.length-1; i++) {
			for(int j=i+1; j<prices.length; j++) {
				if(prices[j] > prices[i] & prices[j] - prices[i] > maxProfit) {
					maxProfit = prices[j] - prices[i];
				}
			}
		}
		return maxProfit;
	}

	// maxArray from the right
	public static int maxProfit1(int[] prices) {
		int[] maxArray = new int[prices.length];
		int maxProfit = 0;
		int maxTillNow = Integer.MIN_VALUE;
		for(int i=prices.length-1; i>=0; i--) {
			if(maxTillNow < prices[i]) {
				maxTillNow = prices[i];
			}
			maxArray[i] = maxTillNow;
		}
		for(int i=0; i<maxArray.length-1; i++) {
			if(maxArray[i+1]-prices[i] > maxProfit) {
				maxProfit = maxArray[i+1]-prices[i];
			}
		}
		return maxProfit;
	}
	//One pass solution without any extra space
	// Input: prices = [7,1,5,3,6,4]
	// Output: 5
	public static int maxProfit2(int[] prices) {
		int n = prices.length;
		int minSoFar = Integer.MAX_VALUE;
		int maxProfit = 0;
		for(int i=0;i< n;i++){
			if(prices[i] < minSoFar) {
				minSoFar = prices[i];
			}
			else {
				if((prices[i]- minSoFar) > maxProfit) {
					maxProfit = prices[i] - minSoFar;
				}
			}	 
		}
		return maxProfit;
	}

	/**
	 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
	 * In Pascal's triangle, each number is the sum of the two numbers directly above it
	 * @param rowIndex
	 * @return
	 */
	public static List<Integer> getRow(int rowIndex) {
		rowIndex++;
		List<Integer> row = new ArrayList<>(rowIndex);
		for(int i =0; i<rowIndex; i++){
			for(int j=row.size()-1; j>=1; j--){
				row.set(j, row.get(j) + row.get(j-1));
			}
			row.add(1);  	
		}
		return row;
	}

	/**
	 * Given an integer numRows, return the first numRows of Pascal's triangle.
		In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
	`	Example 1:

	   Input: numRows = 5
	   Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

	 * @param numRows
	 * @return
	 */
	//grab pen and paper to solve it.
	//main login behind solving Pascal's triangle.
	// 1. When we move to the next line we add 1 at the back, and then perform 
	//	  operations on the elements from second last to the second element, 
	//    starting from the second last element.
	// 2. Then keep on adding the two numbers moving towards the first element.
	//
	// Example:- creation of 3rd row and 4th row:-
	// 		> 11 			//second row
	// 		> 111 			//1 is added to the last
	//		   ^
	//		> 121			//adding second last and third last element.
	//		> 1211			//1 is added to the last
	//		    ^
	//		> 1231			//adding second last and third last element.
	//		   ^
	//		> 1331 			//adding third last and fourth last element.
	//		This goes on..!!
	public static List<List<Integer>> generate(int numRows) {
		//Creation of list which will store lists.
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		//This ArrayList will be added to the result ArrayList.
		List<Integer> row = new ArrayList<>();
		//Creating number of rows.
		for(int i=0; i<numRows; i++) {
			//For each row perform the operations from the second last 
			//element to second element in the list.
			//This for loop will be executed only after the numRows is 
			//greater than or equal to 3.
			for(int j=row.size()-1; j>=1; j--) {
				row.set(j, row.get(j) + row.get(j-1));
			}
			//adding 1 at the last.
			row.add(1);
			//Adding an object of array list to the result. 
			result.add(new ArrayList<Integer>(row));			 
		}
		return result;
	}



	/**
	 * Given an integer array nums where the elements are sorted in 
	 * ascending order, convert it to a height-balanced binary search tree.

		A height-balanced binary tree is a binary tree in which the depth 
		of the two subtrees of every node never differs by more than one.
	 * @param x
	 * @return
	 */
	public static TreeNode sortedArrayToBST(int[] nums) {
		return helperSortedArrayToBST(nums, 0, nums.length-1);
	}
	private static TreeNode helperSortedArrayToBST(int[] nums, int low, int high ) {
		if(low>high) {
			return null;
		}
		int mid = (low + high)/2;
		TreeNode head = new TreeNode(nums[mid]);
		head.left = helperSortedArrayToBST(nums, low, mid-1);
		head.right = helperSortedArrayToBST(nums, mid+1, high);
		return head;
	}


	public static boolean isPalindrome(int x) {
		if(x<0) {
			return false;
		}
		int temp = x;
		int reversedNumber = temp%10;
		temp = temp/10;
		while(temp != 0) {
			reversedNumber = reversedNumber*10 +  temp%10;
			temp=temp/10;
		}
		return x == reversedNumber;
	}

	/**
	 * You are given two integer arrays nums1 and nums2, sorted in 
	 * non-decreasing order, and two integers m and n, representing 
	 * the number of elements in nums1 and nums2 respectively.
	 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int pointer = 0;
		for(int i=0; i<nums1.length; i++) {
			for(int j=0; j<nums1.length; j++) {
				if(pointer<nums2.length && nums1[j]>nums2[pointer]) {
					for(int k= nums1.length-1; k>j; k--) {
						nums1[k] = nums1[k-1];
					}
					nums1[j] = nums2[pointer];
					pointer++;
					System.out.println(pointer);
				}
			}
		}
	}

	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		int index = m-1;
		int i = m-n-1;
		int j = n-1;
		while(index>=0) {
			if(i>=0 && j>=0) {
				if(nums1[i] > nums2[j]) {
					nums1[index] = nums1[i];
					index--;
					i--;
				}
				else {
					nums1[index] = nums2[j];
					index--;
					j--;
				}
			}
			else if(i>=0) {
				nums1[index] = nums1[i];
				index--;
				i--;
			}
			else {
				nums1[index] = nums2[j];
				index--;
				j--;
			}
		}
	}

	public static void merge3(int[] nums1, int m, int[] nums2, int n) {
		int idx = m + n - 1;
		int i = m - 1, j = n - 1;
		while (idx >= 0) {
			if (i >= 0 && j >= 0) {
				if (nums1[i] > nums2[j]) { // pick i
					nums1[idx--] = nums1[i--];
				} else {
					nums1[idx--] = nums2[j--];
				}
			} else if (i >= 0) {
				nums1[idx--] = nums1[i--];
			} else { // j >= 0
				nums1[idx--] = nums2[j--];
			}
		}
	}


	/** 
	 * Given an array of integers nums and an integer target, return 
	 * indices of the two numbers such that they add up to target.
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		for(int i=0;i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if(nums[i] + nums[j] == target){
					int result[]  = {i, j};
					return result;
				}
			}
		}
		return null;
	}

	/**
	 * Given an integer array nums sorted in non-decreasing order, 
	 * remove the duplicates in-place such that each unique element 
	 * appears only once. The relative order of the elements should 
	 * be kept the same.
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates(int[] nums) {
		int index = 0;
		for(int i=0; i<nums.length;i++ ){
			if(i<nums.length-1 && nums[i] == nums[i+1]) {
				continue;
			}
			nums[index++] = nums[i];
			// index++;
		}  
		return index;
	}

	/**
	 * Given an integer array nums and an integer val, remove 
	 * all occurrences of val in nums in-place. The relative 
	 * order of the elements may be changed.
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement(int[] nums, int val) {
		int index = 0;
		for(int i=0; i<nums.length; i++) {
			if(val != nums[i]) {
				nums[index] = nums[i];
				index++;
			}
		}
		return index;
	}

	/**
	 * Given an integer array nums, find the contiguous subarray 
	 * (containing at least one number) which has the largest sum 
	 * and return its sum.
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchInsert(int[] nums, int target) {
		int n = nums.length;
		for(int i = 0 ; i < n ; i++)
		{
			if(nums[i] >= target)
				return i;
		}
		return n;
	}

	/**
	 * Given an integer array nums, find the contiguous subarray 
	 * (containing at least one number) which has the largest sum 
	 * and return its sum. A subarray is a contiguous part of an array.
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		int max_sum = Integer.MIN_VALUE;
		int cur=0;
		for(int x:nums)
		{
			if(cur<0){
				cur=0;  
			} 
			cur += x;
			max_sum =  Math.max(max_sum , cur);
		}
		return max_sum;
	}


	/**
	 * You are given a large integer represented as an integer array digits, 
	 * where each digits[i] is the ith digit of the integer. The digits are 
	 * ordered from most significant to least significant in left-to-right 
	 * order. The large integer does not contain any leading 0's.
	 * Increment the large integer by one and return the resulting array of digits.
	 */
	public static int[] largeNumber(int data[]) {
		int[] duplicate = new int[data.length+1];
		int n =1;
		if(data[data.length-1] == 9) {
			while(n < data.length && data[data.length-n] == 9) {
				data[data.length-n] = 0;
				n++;
				System.out.println(n);
			}
			if(n>0) {
				data[data.length-n] = data[data.length-n] + 1;
			}
		}
		else {
			data[data.length-1] = data[data.length-1] + 1;
		}

		if(data[0] >= 10) {
			duplicate[0] = 1;
			for(int i=1; i<duplicate.length; i++) {
				duplicate[i] = 0;
			}
			data = duplicate;
		}
		return data;
	}
	//This code is from Github. 
	public static class PlusOneArray
	{
		public static int[] PlusOne(int[] digits)
		{
			int numOfNine = GetNines(digits);

			if (numOfNine > 0)
			{

				if (digits.length != numOfNine)
				{
					digits[digits.length - numOfNine - 1] += 1;
				}
				else
				{
					digits[digits.length - numOfNine] = 1;
					int[] newDigits = new int[digits.length + 1];
					//digits.copyTo(newDigits, 0);
					digits = newDigits;
				}

				int i = digits.length - numOfNine;
				for (; i < digits.length; i++)
				{
					digits[i] = 0;
				}
			}
			else
			{
				digits[digits.length - 1] = digits[digits.length - 1] + 1;
			}

			return digits;
		}
		//Helper method.
		private static int GetNines(int[] digits)
		{
			int n = 0;
			for (int i = digits.length - 1; i >= 0; i--)
			{
				if (digits[i] == 9)
					n++;
				else
					break;
			}
			return n;
		}
	}
}
