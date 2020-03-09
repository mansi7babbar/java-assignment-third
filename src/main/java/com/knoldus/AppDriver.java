package com.knoldus;

import twitter4j.TwitterException;

import java.io.IOException;
import java.util.List;

public class AppDriver {
    public static void main(String[] args) throws TwitterException, IOException {
        FilterTweetsImpl filterTweets = new FilterTweetsImpl(new RetrieveTweetsImpl(new TwitterSetup()));

        List<CustomTweet> getLatestTweets = filterTweets
                .getLatestTweets(Constants.hashtag, Constants.limit);
        System.out.println(getLatestTweets);

        List<CustomTweet> getOldestTweets = filterTweets
                .getOldestTweets(Constants.hashtag, Constants.limit, Constants.offset);
        System.out.println(getOldestTweets);

        List<CustomTweet> getTweetsWithHigherToLowerRetweets = filterTweets
                .getTweetsWithHigherToLowerRetweets(Constants.hashtag);
        System.out.println(getTweetsWithHigherToLowerRetweets);

        List<CustomTweet> getTweetsWithHigherToLowerLikes = filterTweets
                .getTweetsWithHigherToLowerLikes(Constants.hashtag);
        System.out.println(getTweetsWithHigherToLowerLikes);

        List<CustomTweet> getTweetsOnGivenDate = filterTweets
                .getTweetsOnGivenDate(Constants.hashtag, Constants.date);
        System.out.println(getTweetsOnGivenDate);

        List<CustomTweet> getLikesOnTweetsInGivenTimeInterval = filterTweets
                .getLikesOnTweetsInGivenTimeInterval(Constants.hashtag, Constants.minutes);
        System.out.println(getLikesOnTweetsInGivenTimeInterval);
    }
}
