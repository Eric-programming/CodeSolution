class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        res = [[1]]

        for i in range(1, numRows):
            cur_level = [1]
            pre_level = res[i - 1]
            for j in range(1, i):
                cur_level.append(pre_level[j - 1] + pre_level[j])
            cur_level.append(1)
            res.append(cur_level)
        return res
