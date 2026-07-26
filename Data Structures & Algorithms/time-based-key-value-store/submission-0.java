class Pair {
    String value;
    int timestamp;

    public Pair (String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}

class TimeMap {
    HashMap<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair> pairs = map.get(key);
        if (pairs != null) {
            pairs.add(new Pair(value, timestamp));
            map.put(key, pairs);
        } else {
            Pair pair = new Pair(value, timestamp);
            map.put(key, new ArrayList<>(List.of(pair)));
        }
    }
    
    public String get(String key, int timestamp) {
        List<Pair> pairs = map.get(key); 
        if (pairs == null) return "";
        
        return findValue(pairs, timestamp);
    }

    private String findValue(List<Pair> pairs, int timestamp) {
        int left = 0, right = pairs.size()-1;
        String ans = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Pair midPair = pairs.get(mid);
            if (midPair.timestamp == timestamp) return midPair.value;
            else if (midPair.timestamp < timestamp) {
                ans = midPair.value;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
