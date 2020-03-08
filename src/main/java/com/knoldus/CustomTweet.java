package com.knoldus;

import java.util.Date;

/**
 * CustomTweet is created to provide only required fields of Twitter Status.
 */

public class CustomTweet {
    long id;
    int favouriteCount;
    int retweetCount;
    Date createdAt;

    CustomTweet(long id, int favouriteCount, int retweetCount, Date createdAt) {
        this.id = id;
        this.favouriteCount = favouriteCount;
        this.retweetCount = retweetCount;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CustomTweet{"
                + "id=" + id
                + ", favouriteCount=" + favouriteCount
                + ", retweetCount=" + retweetCount
                + ", createdAt=" + createdAt
                + '}';
    }
}
