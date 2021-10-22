from typing import *


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # 1. Calculate the prefix
        res = [1]
        for i in range(1, len(nums)):
            res.append(res[i - 1] * nums[i - 1])
        
        # 2. use the array to calculate the product except self
        postfix = 1
        for i in range(len(nums) - 1, -1, -1):
            prefix = res[i]
            res[i] = postfix * prefix 
            postfix *= nums[i]
        
        return res
