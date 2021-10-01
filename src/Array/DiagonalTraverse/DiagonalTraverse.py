class Solution:
    def findDiagonalOrder(self, mat: List[List[int]]) -> List[int]:

        m = len(mat)
        n = len(mat[0])

        def is_traverse_up(row, col):
            # if even number we are traversing up right
            return (row + col) % 2 == 0

        def is_with_in_boundary(row, col):
            return 0 <= row and 0 <= col and row < m and col < n

        res = []
        row = col = 0

        for i in range(m * n):
            res.append(mat[row][col])

            if is_traverse_up(row, col):
                if is_with_in_boundary(row - 1, col + 1):
                    row -= 1
                    col += 1
                elif is_with_in_boundary(row, col + 1):
                    col += 1
                else:
                    row += 1
            else:
                if is_with_in_boundary(row+1, col-1):
                    row += 1
                    col -= 1
                elif is_with_in_boundary(row+1, col):
                    row += 1
                else:
                    col += 1
        return res
