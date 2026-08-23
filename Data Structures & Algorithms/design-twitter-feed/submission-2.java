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
    Map<Integer, List<Tuple>> tweets;

    public Twitter() {
        timestamp=0;
        followersMap = new HashMap<>();
        tweets = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(0, new Tuple(tweetId, timestamp));
        timestamp++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> (a.timestamp - b.timestamp));
        Set<Integer> followers = followersMap.getOrDefault(userId, new HashSet<>());
        for (Tuple t: tweets.getOrDefault(userId, new ArrayList<>())) {
            pq.offer(t);
            if (pq.size() > 10) pq.poll();
        }

        for (int follower: followers) {
            List<Tuple> userTweets = tweets.getOrDefault(follower, new ArrayList<>());
            for (Tuple t: userTweets) {
                pq.offer(t);
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
        followersMap.get(followerId).remove(Integer.valueOf(followeeId));
    }
}
