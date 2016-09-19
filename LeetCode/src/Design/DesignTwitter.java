package Design;

import java.util.*;

public class DesignTwitter {
    HashMap<Integer, List<Integer>> users;
    HashMap<Integer, List<Integer>> tweets;
    HashMap<Integer, Integer> orders;
    int timestamp;

    /** Initialize your data structure here. */
    public DesignTwitter() {
        users = new HashMap<>();
        tweets = new HashMap<>();
        orders = new HashMap<>();
        timestamp = 0;
    }

    class Wrapper {
        int id;
        int timestamp;

        public Wrapper (int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<Integer>());
        }
        tweets.get(userId).add(tweetId);
        orders.put(tweetId, timestamp++);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Wrapper> pq = new PriorityQueue<>(new Comparator<Wrapper>() {
            @Override
            public int compare(Wrapper o1, Wrapper o2) {
                return o1.timestamp - o2.timestamp;
            }
        });
        HashSet<Integer> allTweets = new HashSet<>();
        if (tweets.containsKey(userId)) {
            allTweets.addAll(tweets.get(userId));
        }
        List<Integer> allUsers = new ArrayList<>();
        if (users.containsKey(userId)) {
            allUsers.addAll(users.get(userId));
        }
        for (int user : allUsers) {
            if (tweets.containsKey(user)) {
                allTweets.addAll(tweets.get(user));
            }
        }
        //add all the tweets to the priority queue
        for (int tweet: allTweets) {
            pq.offer(new Wrapper(tweet, orders.get(tweet)));
            if (pq.size() > 10) {
                pq.poll();
            }
        }
        List<Wrapper> temp = new ArrayList<>(pq);
        Collections.sort(temp, new Comparator<Wrapper>() {
            @Override
            public int compare(Wrapper o1, Wrapper o2) {
                return o2.timestamp - o1.timestamp;
            }
        });
        for (Wrapper wrapper: temp) {
            res.add(wrapper.id);
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new ArrayList<Integer>());
        }
        users.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId)) {
            users.get(followerId).remove(new Integer(followeeId));
        }
    }
}