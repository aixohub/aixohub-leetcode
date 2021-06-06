package com.aixohub.leetcode.medium.findMaxForm;

public class OneAndZero3 {

    public static void main(String[] args) {
        String[] strs =  {"10", "0001", "111001", "1", "0"};

        int maxForm = findMaxForm(strs, 5, 3);
        System.out.println(maxForm);
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] pt = preprocess(strs);
        // remove useless
        int valid = 0, i, j;
        for (i = 0; i < pt.length; i++) {
            if (pt[i][0] > m || pt[i][1] > n) {
                continue;
            }
            if (valid != i) {
                pt[valid][0] = pt[i][0];
                pt[valid][1] = pt[i][1];
            }
            valid++;
        }
        // sort
        int[] ans = new int[4];
        sort(pt, valid);
        dfs(pt, valid, 0, ans, m, n);
        return ans[3];
    }


    private static int[][] preprocess(String[] strs) {
        int[][] pt = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            char[] cs = strs[i].toCharArray();
            for (int j = 0; j < cs.length; j++) {
                if (cs[j] == '0') {
                    pt[i][0]++;
                } else {
                    pt[i][1]++;
                }
            }
        }
        return pt;
    }

    private static void sort(int[][] pt, int len) {
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((pt[i][0] > pt[j][0]) || (pt[i][0] == pt[j][0] && pt[i][1] > pt[j][1])) {
                    int[] tmp = pt[i];
                    pt[i] = pt[j];
                    pt[j] = tmp;
                }
            }
        }
    }

    private static void dfs(int[][] pt, int len, int cur, int[] ans, int m, int n) {
        if (cur >= len || len - cur + ans[2] <= ans[3]) {
            return;
        }
        if (ans[3] > 0 && ans[3] - ans[2] > 0) {
            int left = ans[3] - ans[2];
            if (ans[0] + pt[cur][0] * left > m) {
                return;
            }
        }
        // check first
        if (ans[0] + pt[cur][0] <= m && ans[1] + pt[cur][1] <= n) {
            // add current
            ans[0] += pt[cur][0];
            ans[1] += pt[cur][1];
            ans[2] += 1;
            ans[3] = Math.max(ans[3], ans[2]);
            dfs(pt, len, cur + 1, ans, m, n);
            ans[0] -= pt[cur][0];
            ans[1] -= pt[cur][1];
            ans[2] -= 1;

        }
        for (cur = cur + 1; cur < len; cur++) {
            if (pt[cur][0] != pt[cur - 1][0] || pt[cur][1] != pt[cur - 1][1]) {
                break;
            }
        }
        if (cur < len) {
            dfs(pt, len, cur, ans, m, n);
        }
    }

}
