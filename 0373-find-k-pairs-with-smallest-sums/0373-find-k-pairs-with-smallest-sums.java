import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        // {index in nums1, index in nums2}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(
                (long) nums1[a[0]] + nums2[a[1]],
                (long) nums1[b[0]] + nums2[b[1]]
            )
        );

        // Add first pair from each row
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.offer(new int[]{i, 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] pair = pq.poll();

            int i = pair[0];
            int j = pair[1];

            ans.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            // Move to the next element in nums2
            if (j + 1 < nums2.length) {
                pq.offer(new int[]{i, j + 1});
            }
        }

        return ans;
    }
}
