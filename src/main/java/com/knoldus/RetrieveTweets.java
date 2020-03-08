package com.knoldus;

import twitter4j.TwitterException;

import java.util.List;

/**
 * RetrieveTweets is created to retrieve tweets containing provided hashtag.
 */

public interface RetrieveTweets {

    /**
     * Provides list of CustomTweet from a list of Status having tweets containing provided hashtag.
     * @param hashtag Keyword to be searched in tweets.
     * @return List of CustomTweet is returned.
     * @throws TwitterException Handles an exception if occurred.
     */
    List<CustomTweet> retrieveTweets(String hashtag) throws TwitterException;

}
