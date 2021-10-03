from collections import deque

class Solution:
    def duplicateZeros(self, arr: List[int]) -> None:
        """
        Do not return anything, modify arr in-place instead.
        """
        queue = deque()
        
        for i in range(len(arr)):
            if arr[i] == 0:
                queue.append(0)
                queue.append(0)
            else:
                queue.append(arr[i])
            
            arr[i] = queue.popleft()
