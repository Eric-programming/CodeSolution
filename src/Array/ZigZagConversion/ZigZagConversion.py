class Solution:
    def convert(self, s: str, numRows: int) -> str:
        # 1. Create n number of lists
        lists = []
        for i in range(numRows):
            lists.append([])

        # 2. Traverse the string in zig zag order
        index = 0
        while index < len(s):
            # Go down
            for i in range(numRows):
                if index == len(s):
                    break
                lists[i].append(s[index])
                index += 1

            # Go up
            for i in range(numRows - 2, 0, -1):
                if index == len(s):
                    break
                lists[i].append(s[index])
                index += 1
        
        # 3. Combine the lists into one str
        res = ""
        for cur_list in lists:
            res += "".join(cur_list)
        
        return res
