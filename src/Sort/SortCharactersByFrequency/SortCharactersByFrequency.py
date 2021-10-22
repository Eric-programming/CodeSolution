class Solution:
    def frequencySort(self, s: str) -> str:
        # 1. store each character's frequency
        freq_by_char = dict()
        for cur_char in s:
            if cur_char not in freq_by_char:
                freq_by_char[cur_char] = 0
            freq_by_char[cur_char] += 1

        # 2. store frequency with list of characters
        chars_by_freq = dict()
        max_freq = 0
        for cur_char in freq_by_char:
            cur_freq = freq_by_char[cur_char]
            max_freq = max(max_freq, cur_freq)
            if cur_freq not in chars_by_freq:
                chars_by_freq[cur_freq] = []
            chars_by_freq[cur_freq].append(cur_char)

        # 3. Iterate from the max freq to least freq
        result = []
        for cur_freq in range(max_freq, 0, -1):
            if cur_freq in chars_by_freq:
                for cur_char in chars_by_freq[cur_freq]:
                    result.append(cur_char * cur_freq)
        return "".join(result)
