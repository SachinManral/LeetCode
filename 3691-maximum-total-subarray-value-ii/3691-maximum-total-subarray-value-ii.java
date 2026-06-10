class SegmentTree {
    int[] segmentTree;
    boolean isMinTree;

    SegmentTree(int[] nums, boolean flag) {
        int n = nums.length;
        this.isMinTree = flag;
        segmentTree = new int[4 * n];
        buildSegTree(0, 0, n - 1, nums);
    }

    void buildSegTree(int i, int l, int r, int[] nums) {
        if (l == r) {
            segmentTree[i] = nums[l];
            return;
        }

        int mid = (l+r)>>1;

        buildSegTree(2*i+1, l, mid, nums);
        buildSegTree(2*i+2, mid+1, r, nums);

        if (isMinTree) {
            segmentTree[i] = Math.min(segmentTree[2*i+1], segmentTree[2*i+2]);
        } else {
            segmentTree[i] = Math.max(segmentTree[2*i+1], segmentTree[2*i+2]);
        }
    }

    int query(int start, int end, int i, int l, int r) {
        //No overlap
        if (l > end || r < start) {
            return isMinTree ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        //Complete Overlap
        if (l >= start && r <= end) {
            return segmentTree[i];
        }

        int mid = (l+r)>>1;

        int a = query(start, end, 2*i+1, l, mid);
        int b = query(start, end, 2*i+2, mid + 1, r);

        if (isMinTree) {
            return Math.min(a, b);
        }

        return Math.max(a, b);
    }

    int query(int l, int r, int n) {
        return query(l, r, 0, 0, n - 1);
    }
}

class Solution {
    long getValue(int l, int r, SegmentTree minST, SegmentTree maxST, int n) {
        int minEl = minST.query(l, r, n);
        int maxEl = maxST.query(l, r, n);
        return (long) maxEl - minEl;
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        SegmentTree minST = new SegmentTree(nums, true);
        SegmentTree maxST = new SegmentTree(nums, false); 

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        for (int l = 0; l < n; l++) {
            long value = getValue(l, n-1, minST, maxST, n);
            pq.offer(new long[]{value, l, n-1});
        }

        long result = 0;
        while (k-- > 0) {
            long[] top = pq.poll();
            long value = top[0];
            int l = (int) top[1];
            int r = (int) top[2];

            result += value;

            long nextBestValue = getValue(l, r-1, minST, maxST, n);

            pq.offer(new long[]{nextBestValue, l, r-1});
        }

        return result;
    }
}