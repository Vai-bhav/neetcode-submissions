class Tuple {
    int tweetId;
    int timestamp;

    public Tuple(int tweetId, int timestamp) {
        this.tweetId = tweetId;
        this.timestamp = timestamp;
    }
}

class Twitter {
    int timestamp;
    Map<Integer, Set<Integer>> followersMap;
    Map<Integer, List<Tuple>> userTweets;

    public Twitter() {
        timestamp=0;
        followersMap = new HashMap<>();
        userTweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweets.putIfAbsent(userId, new ArrayList<>());
        userTweets.get(userId).add(0, new Tuple(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> (a.timestamp - b.timestamp));
        Set<Integer> users = new HashSet<>(followersMap.getOrDefault(userId, new HashSet<>()));
        users.add(userId);

        for (int user: users) {
            List<Tuple> tweetsList = userTweets.getOrDefault(user, new ArrayList<>());
            int maxIdx = Math.min(10, tweetsList.size());

            for (int i=0;i<maxIdx;i++) {
                pq.offer(tweetsList.get(i));

                if (pq.size() > 10) pq.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(pq.size() > 0) {
            ans.add(0, pq.poll().tweetId);
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        followersMap.putIfAbsent(followeeId, new HashSet<>());
        followersMap.putIfAbsent(followerId, new HashSet<>());
        followersMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followersMap.containsKey(followerId)) {
            followersMap.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }
}
