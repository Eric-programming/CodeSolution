class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>(); 
        int n = num.length;
        for (int i = 0; i < n-2; i++) {
            if (0 < i && num[i] == num[i-1]) continue;
            int left = i+1, right = n-1;
            while (left < right) {
                int sum = num[left] + num[right] + num[i];
                if (sum == 0) {
                    res.add(Arrays.asList(num[i], num[left], num[right]));
                    while (left < right && num[left] == num[left+1]) left++;
                    left++;
                    while (left < right && num[right] == num[right-1]) right--;
                    right--;
                } else if (sum < 0) {
                    // improve: skip duplicates
                    while (left < right && num[left] == num[left+1]) left++;
                    left++;
                } else {
                    // improve: skip duplicates
                    while (left < right && num[right] == num[right-1]) right--;
                    right--;
                }
            }
        }
        return res;
    }
}
