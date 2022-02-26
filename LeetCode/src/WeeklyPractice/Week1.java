package WeeklyPractice;

public class Week1 {
	public static void main(String args[]) {
		int[] nums1 = {1,2,3,0,0,0}; int m = 3; int[] nums2 = {2,5,6}; int n = 3;
		merge(nums1,m,nums2,n);
		for(int i=0; i<nums1.length; i++) {
			System.out.print(nums1[i] + ", ");
		}
	}
	//Question 88
	 public static void merge(int[] nums1, int m, int[] nums2, int n) {
	        int pointer1 = m-1;
	        int pointer2 = n-1;
	        int k = m+n-1;
	        System.out.println(pointer1);
	        while(k>=0) {
	        	if(pointer1 >= 0 && pointer2 >= 0) {
	        		if(nums1[pointer1] >= nums2[pointer2]  ) {
		        		nums1[k] = nums1[pointer1];
		        		pointer1--;
		        		k--;
		        	}
		        	else {
		        		nums1[k] = nums2[pointer2];
		        		pointer2--;
		        		k--;
		        	}
	        	}
	        	else if(pointer1 >= 0) {
	        		nums1[k] = nums1[pointer1];
	        		k--;
	        		pointer1--;
	        	}
	        	else if(pointer2 >= 0) {
	        		nums1[k] = nums2[pointer2];
	        		k--;
	        		pointer2--;
	        	}
	        }
	 }
	 
	
	
	//Question 53.
	public static int maxSubArray(int[] nums) {
      int maxSum = Integer.MIN_VALUE;
      int sum = 0;
      for(int i=0; i<nums.length; i++) {
    	 
    	  if(sum < 0) {
    		  sum = 0;
    	  }
    	  sum = sum + nums[i];
    	  if(sum > maxSum) {
    		  maxSum = sum;
    	  }
      }
      return maxSum;
    }
	
	// Question 35.
	 public int searchInsert1(int[] nums, int target) {
		 for(int i=0; i<nums.length; i++) {
			if(nums[i] >= target) {
				return i;
			}
		 }
		 return nums.length;
	 }
	 //binarySearch 
	 public static int search(int[] nums, int target) {
		 int result = searchBSHelper(nums, target, 0, nums.length-1);
		 return result;
	 }
	 
	 public static int searchBSHelper(int[] nums, int target, int low, int high) {
		 if(low>=high) {
			 return -1;
		 }
		 int mid = (low + high) / 2;
		 if(target == nums[mid]) {
			 return mid;
		 }
		 if(target < nums[mid]) {
			 return searchBSHelper(nums, target, 0, mid-1);
		 }
		 else {
			 return searchBSHelper(nums, target, mid+1, nums.length);
		 }
	 }
	 
	
	//Question 27.
	 public int removeElement(int[] nums, int val) {
	        int pointer = 0;
	        for(int i=0; i<nums.length; i++) {
	        	if(nums[i] == val) {
	        		continue;
	        	}
	        	nums[pointer] = nums[i];
	        	pointer++;
	        }
	        return pointer;
	 }
	
	//Question 6.
		 public static int removeDuplicates(int[] nums) {
		        int pointer = 0;
		        for(int i=1; i<nums.length; i++) {
		        	if(i<nums.length -1 && nums[i] == nums[i+1] ) {
		        		continue;
		        	}
		        	nums[pointer] = nums[i];
		        	pointer++;
		        }
		        return pointer;
		  }
	
	//Question 1.
	 public int[] twoSum(int[] nums, int target) {
	        for(int i=0; i<nums.length-1; i++) {
	        	for(int j=i+1; j<nums.length; j++) {
	        		if(nums[i] + nums[j] == target) {
	        			int result[] = {i,j};
	        			return result;
	        		}
	        	}
	        }
	        return null;
	 }
	 
	 
}
