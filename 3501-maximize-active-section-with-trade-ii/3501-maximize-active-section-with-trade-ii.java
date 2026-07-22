class SegmentTree {

    int n;
    int[] a;
    int[] seg;

    SegmentTree(int[] a) {
        this.a = a;
        n = a.length;
        seg = new int[n << 2];
        build(1, 0, n - 1);
    }

    void build(int p, int l, int r) {
        if (l == r) {
            seg[p] = a[l];
            return;
        }

        int m = (l + r) >> 1;
        build(p << 1, l, m);
        build(p << 1 | 1, m + 1, r);
        seg[p] = Math.max(seg[p << 1], seg[p << 1 | 1]);
    }

    int query(int l, int r) {
        if (l > r) return 0;
        return query(1, 0, n - 1, l, r);
    }

    int query(int p, int l, int r, int x, int y) {
        if (x <= l && r <= y) return seg[p];

        int m = (l + r) >> 1;
        int ans = 0;

        if (x <= m) ans = Math.max(ans, query(p << 1, l, m, x, y));
        if (y > m) ans = Math.max(ans, query(p << 1 | 1, m + 1, r, x, y));

        return ans;
    }
}

class Solution {

    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int one = 0;

        for (char c : s.toCharArray())
            if (c == '1')
                one++;

        List<Integer> len = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();

        int i = 0;
        while (i < n) {
            int st = i;
            while (i < n && s.charAt(i) == s.charAt(st)) i++;

            if (s.charAt(st) == '0') {
                len.add(i - st);
                l.add(st);
                r.add(i - 1);
            }
        }

        int m = len.size();

        List<Integer> ans = new ArrayList<>();
        if (m < 2) {
            for (int[] q : queries) ans.add(one);
            return ans;
        }

        int[] a = new int[m - 1];
        for (i = 0; i < m - 1; i++)
            a[i] = len.get(i) + len.get(i + 1);

        SegmentTree seg = new SegmentTree(a);

        for (int[] q : queries) {
            int x = q[0], y = q[1];

            int li = lb(r, x);
            int ri = ub(l, y) - 1;

            if (li >= ri || li >= m || ri < 0) {
                ans.add(one);
                continue;
            }

            int f = r.get(li) - Math.max(l.get(li), x) + 1;
            int lst = Math.min(r.get(ri), y) - l.get(ri) + 1;

            if (li + 1 == ri) {
                ans.add(one + f + lst);
                continue;
            }

            int v1 = f + len.get(li + 1);
            int v2 = len.get(ri - 1) + lst;
            int v3 = seg.query(li + 1, ri - 2);

            ans.add(one + Math.max(Math.max(v1, v2), v3));
        }

        return ans;
    }

    int lb(List<Integer> a, int x) {
        int l = 0, r = a.size();

        while (l < r) {
            int m = (l + r) >> 1;
            if (a.get(m) < x) l = m + 1;
            else r = m;
        }

        return l;
    }

    int ub(List<Integer> a, int x) {
        int l = 0, r = a.size();

        while (l < r) {
            int m = (l + r) >> 1;
            if (a.get(m) <= x) l = m + 1;
            else r = m;
        }

        return l;
    }
}