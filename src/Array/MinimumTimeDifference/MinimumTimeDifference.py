class Solution:
    def findMinDifference(self, timePoints: List[str]) -> int:

        def convert_to_minutes(time: str) -> int:
            time_arr = time.split(":")
            return int(time_arr[0]) * 60 + int(time_arr[1])

        times = set()
        max_minutes = 0

        for time in timePoints:
            minutes = convert_to_minutes(time)
            if minutes in times:
                return 0
            else:
                times.add(minutes)
                max_minutes = max(minutes, max_minutes)

        pre_minutes = None
        min_diff = one_day_in_minutes = 24 * 60

        for cur_minutes in range(max_minutes, -1, -1):
            if cur_minutes in times:
                if pre_minutes is not None:
                    min_diff = min(min_diff, pre_minutes - cur_minutes,
                                   (cur_minutes + one_day_in_minutes) - pre_minutes)
                pre_minutes = cur_minutes

        # Compare min minutes with max minutes
        min_diff = min(
            min_diff, (pre_minutes + one_day_in_minutes) - max_minutes)

        return min_diff
