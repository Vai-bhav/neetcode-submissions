class DisjointSet {
    int[] size;
    int[] parent;
    public DisjointSet(int n) {
        size = new int[n];
        parent = new int[n];
        for (int i=0;i<n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void unionBySize(int u, int v) {
        int uParent = parent(u);
        int vParent = parent(v);

        if(uParent == vParent) return;
        else if (size[uParent] > size[vParent]) {
            parent[vParent] = uParent;
            size[uParent] += size[vParent];
        } else {
            parent[uParent] = vParent;
            size[vParent] += size[uParent];
        }
    }

    public int parent(int u) {
        if (parent[u] == u) return u;

        return parent[u] = parent(parent[u]);
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        DisjointSet dsu = new DisjointSet(n);

        for (int[] edge: edges) {
            dsu.unionBySize(edge[0], edge[1]);
        }

        Set<Integer> set = new HashSet<>();
        for (int i=0;i<n;i++) {
            set.add(dsu.parent(dsu.parent[i]));
        }

        return set.size();
    }
}
