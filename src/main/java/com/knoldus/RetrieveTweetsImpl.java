package com.knoldus;

import twitter4j.Query;
import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveTweetsImpl implements RetrieveTweets {
    TwitterSetup twitterSetup;

    public RetrieveTweetsImpl(TwitterSetup twitterSetup) {
        this.twitterSetup = twitterSetup;
    }

    @Override
    public List<CustomTweet> retrieveTweets(String hashtag) throws TwitterException {
        Query hashtagQuery = new Query(hashtag);
        List<Status> tweets = twitterSetup.getTwitterInstance().search(hashtagQuery).getTweets();
        return tweets.stream().map(tweet ->
                new CustomTweet(tweet.getId(), tweet.getFavoriteCount(), tweet.getRetweetCount(), tweet.getCreatedAt()))
                .collect(Collectors.toList());
    }
}
