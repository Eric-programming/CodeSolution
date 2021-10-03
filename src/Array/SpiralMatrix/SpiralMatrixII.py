class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        # 1. Create the 2d array
        res = [[0] * n for i in range(n)]

        # 2. Traverse in spiral order to fill the array
        top = left = 0  # border
        right = down = n - 1  # border
        counter = 1

        while counter <= n * n:
            # Top row
            for col in range(left, right + 1):
                res[top][col] = counter
                counter += 1
            top += 1

            # Right col
            for row in range(top, down + 1):
                res[row][right] = counter
                counter += 1
            right -= 1

            # down row or bottom row
            for col in range(right, left - 1, -1):
                res[down][col] = counter
                counter += 1
            down -= 1

            # left col
            for row in range(down, top - 1, -1):
                res[row][left] = counter
                counter += 1
            left += 1

        return res
