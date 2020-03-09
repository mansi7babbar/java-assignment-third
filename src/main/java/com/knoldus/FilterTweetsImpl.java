package com.knoldus;

import twitter4j.TwitterException;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterTweetsImpl implements FilterTweets {
    RetrieveTweets retrieveTweets;

    public FilterTweetsImpl(RetrieveTweets retrieveTweets) {
        this.retrieveTweets = retrieveTweets;
    }

    @Override
    public List<CustomTweet> getLatestTweets(String hashtag, long limit) throws TwitterException, IOException {
        return retrieveTweets.retrieveTweets(hashtag)
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomTweet> getOldestTweets(String hashtag, long limit, long offset)
            throws TwitterException, IOException {
        return retrieveTweets.retrieveTweets(hashtag)
                .stream()
                .sorted(Comparator.comparing(tweet -> tweet.createdAt))
                .limit(limit)
                .skip(offset)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomTweet> getTweetsWithHigherToLowerRetweets(String hashtag) throws TwitterException, IOException {
        List<CustomTweet> getTweetsWithHigherToLowerRetweets =
                retrieveTweets.retrieveTweets(hashtag)
                .stream()
                .sorted(Comparator.comparing(tweet -> tweet.retweetCount))
                .collect(Collectors.toList());
        Collections.reverse(getTweetsWithHigherToLowerRetweets);
        return getTweetsWithHigherToLowerRetweets;
    }

    @Override
    public List<CustomTweet> getTweetsWithHigherToLowerLikes(String hashtag) throws TwitterException, IOException {
        List<CustomTweet> getTweetsWithHigherToLowerLikes =
                retrieveTweets.retrieveTweets(hashtag)
                .stream()
                .sorted(Comparator.comparing(tweet -> tweet.favouriteCount))
                .collect(Collectors.toList());
        Collections.reverse(getTweetsWithHigherToLowerLikes);
        return getTweetsWithHigherToLowerLikes;
    }

    @Override
    public List<CustomTweet> getTweetsOnGivenDate(String hashtag, LocalDate date) throws TwitterException, IOException {
        return retrieveTweets.retrieveTweets(hashtag)
                .stream()
                .filter(tweet -> tweet.createdAt
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate()
                        .equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomTweet> getLikesOnTweetsInGivenTimeInterval(String hashtag, long minutes)
            throws TwitterException, IOException {
        LocalDateTime endTime = LocalDateTime.now();
        LocalDateTime startTime = endTime.minusMinutes(minutes);
        return retrieveTweets.retrieveTweets(hashtag)
                .stream()
                .filter(tweet ->
                        tweet.createdAt.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
                                .isAfter(startTime)
                                && tweet.createdAt.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
                                        .isBefore(endTime)
                )
                .collect(Collectors.toList());
    }
}
