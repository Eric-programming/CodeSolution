class Solution {
    int[] arr;
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if(nums.length == 0) return res;
        arr = nums;
        res[0] = findLeft(target);
        res[1] = findRight(target);
        return res;
    }
    private int findLeft(int target){
        int left = 0, right = arr.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(arr[left] == target) return left;
        if(arr[right] == target) return right;
        return -1;
    }
    private int findRight(int target){
        int left = 0, right = arr.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(arr[mid] <= target){
                left = mid;
            }else{
                right = mid;
            }
        }
        if(arr[right] == target) return right;
        if(arr[left] == target) return left;
        return -1;
    }
}
