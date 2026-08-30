class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        size = new int[n+1];
        parent = new int[n+1];

        for (int i=0;i<=n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public boolean unionBySize(int u, int v) {
        int uParent = findUPar(u);
        int vParent = findUPar(v);

        if (uParent == vParent) return true;

        if (size[uParent] > size[vParent]) {
            parent[vParent] = uParent;
            size[uParent] += size[vParent];
        } else {
            parent[uParent] = vParent;
            size[vParent] += size[uParent];
        }

        return false;
    }

    public int findUPar(int u) {
        if (parent[u] == u) return u;

        return parent[u] = findUPar(parent[u]);
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);

        for (int i=0;i<n;i++) {
            if (dsu.unionBySize(edges[i][0], edges[i][1])) {
                return edges[i];
            }
        }

        return new int[]{-1, -1};
    }
}