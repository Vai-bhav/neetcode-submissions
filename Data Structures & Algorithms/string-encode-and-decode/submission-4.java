class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str: strs) {
            sb.append(str.length());
            sb.append('#');
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int n = str.length();
        List<String> ans = new ArrayList<>();
        int i = 0;

        while(i < n) {
            int j = i;
            while(j < n && str.charAt(j) != '#') j++;
            int len = Integer.parseInt(str.substring(i, j));

            ans.add(str.substring(j+1, j+1+len));

            i = j+len+1;
        }

        return ans;
    }
}
