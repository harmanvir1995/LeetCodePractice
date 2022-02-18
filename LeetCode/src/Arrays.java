
public class Arrays {
	public static void main(String[] args) {
		int data[] = {1,3,5,6};
		System.out.println(searchInsert(data, 4));;
		for(int i=0; i<data.length; i++) {
			System.out.print(data[i] + ", ");
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
	            for(int j=i; j<nums.length; j++){
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
}
