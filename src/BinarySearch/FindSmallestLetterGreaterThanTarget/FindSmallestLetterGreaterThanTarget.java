class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
       //Base case
        int n = letters.length;
        if(target < letters[0] || letters[n - 1] <= target) return letters[0];
        
        int left = 0, right = n - 1;
        while(left + 1 < right){
            int mid = (left + right) / 2;
            if(target < letters[mid]){
                right = mid;
            }else{
                left = mid;
            }
        }
        
        return letters[right];
    }
}
