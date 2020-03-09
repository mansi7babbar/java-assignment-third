package com.knoldus;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * TwitterSetup is created to generate a twitter instance.
 */
public class TwitterSetup {
    Twitter getTwitterInstance() {
        Config configFactory = ConfigFactory.load();
        ConfigurationBuilder config = new ConfigurationBuilder();
        config.setDebugEnabled(true)
                .setOAuthConsumerKey(configFactory.getString("consumer.key"))
                .setOAuthConsumerSecret(configFactory.getString("consumer.secret"))
                .setOAuthAccessToken(configFactory.getString("token.key"))
                .setOAuthAccessTokenSecret(configFactory.getString("token.secret"));
        TwitterFactory twitterFactory = new TwitterFactory(config.build());
        return twitterFactory.getInstance();
    }
}
