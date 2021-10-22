class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # Store each element's frequency
        freq_by_num = dict()
        max_freq = 0
        for num in nums:
            if num not in freq_by_num:
                freq_by_num[num] = 0
            freq_by_num[num] += 1
            max_freq = max(max_freq, freq_by_num[num])
                
        num_by_freq = dict()
        for num in freq_by_num:
            freq = freq_by_num[num]
            if freq not in num_by_freq:
                num_by_freq[freq] = []
            num_by_freq[freq].append(num)
        
        # Find the top k frequent element
        result = []
        
        for cur_freq in range(max_freq, -1, -1):
            if cur_freq in num_by_freq:
                cur_nums = num_by_freq[cur_freq]
                for num in cur_nums:
                    result.append(num)
                    k -= 1
                    if k == 0: 
                        return result
