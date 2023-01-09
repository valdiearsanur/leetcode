class Solution:
    def closetTarget(self, words: List[str], target: str, startIndex: int) -> int:
        minval = 1001
        n = len(words)
        for i in range(n*2-1):
            j = i % n
            word = words[j]
            if target == word:
                distance = abs(j-startIndex)
                distance_rev = abs(j+n - startIndex)
                distance_rev2 = abs(startIndex+n - j)
                minval = min(distance, minval)
                minval = min(distance_rev, minval)
                minval = min(distance_rev2, minval)
                
        # print(minval, abs(0-2) % 3)
        return minval if minval != 1001 else -1
'''
1 2 3 4 5 6
0 1 2 3 4 5


0+6 - 4
2


8 + 9 - 2 = 14 % 9
2 + 9 - 8
'''
