package com.knoldus;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * TwitterSetup is created to generate a twitter instance.
 */
public class TwitterSetup {
    Twitter getTwitterInstance() {
        ConfigurationBuilder config = new ConfigurationBuilder();
        config.setDebugEnabled(true)
                .setOAuthConsumerKey(consumer.key)
                .setOAuthConsumerSecret(consumer.secret)
                .setOAuthAccessToken(token.key)
                .setOAuthAccessTokenSecret(token.secret);
        TwitterFactory twitterFactory = new TwitterFactory(config.build());
        return twitterFactory.getInstance();
    }
}
