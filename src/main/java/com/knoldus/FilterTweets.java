package com.knoldus;

import twitter4j.TwitterException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * FilterTweets is created to perform various queries on list of CustomTweet.
 */

public interface FilterTweets {

    /**
     * Provides latest tweets upto a certain limit.
     * @param hashtag Keyword to be searched in tweets.
     * @param limit Number of tweets required.
     * @return List of CustomTweet is returned.
     * @throws TwitterException Handles an exception if occurred.
     */
    List<CustomTweet> getLatestTweets(String hashtag, long limit) throws TwitterException, IOException;

    /**
     * Provides oldest tweets upto a certain limit.
     * @param hashtag Keyword to be searched in tweets.
     * @param limit Number of tweets required.
     * @return List of CustomTweet is returned.
     * @throws TwitterException Handles an exception if occurred.
     */
    List<CustomTweet> getOldestTweets(String hashtag, long limit, long offset) throws TwitterException, IOException;

    /**
     * Provides higher to lower number of retweets for all tweets containing given hashtag.
     * @param hashtag Keyword to be searched in tweets.
     * @return Number of tweets required.
     * @throws TwitterException Handles an exception if occurred.
     */
    List<CustomTweet> getTweetsWithHigherToLowerRetweets(String hashtag) throws TwitterException, IOException;

    /**
     * Provides higher to lower number of likes for all tweets containing given hashtag.
     * @param hashtag Keyword to be searched in tweets.
     * @return Number of tweets required.
     * @throws TwitterException Handles an exception if occurred.
     */
    List<CustomTweet> getTweetsWithHigherToLowerLikes(String hashtag) throws TwitterException, IOException;

    /**
     * Provides tweets posted on a given date.
     * @param hashtag Keyword to be searched in tweets.
     * @param date Date on which tweet is posted.
     * @return Number of tweets required.
     * @throws TwitterException Handles an exception if occurred.
     */
    List<CustomTweet> getTweetsOnGivenDate(String hashtag, LocalDate date) throws TwitterException, IOException;

    /**
     * Provide number of likes on tweets posted within a given time interval.
     * @param hashtag Keyword to be searched in tweets.
     * @param minutes Time interval in which tweets are posted.
     * @return Number of tweets required.
     * @throws TwitterException Handles an exception if occurred.
     */
    List<CustomTweet> getLikesOnTweetsInGivenTimeInterval(String hashtag, long minutes)
            throws TwitterException, IOException;

}
