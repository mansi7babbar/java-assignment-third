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
                .setOAuthConsumerKey("e6uS4phTxImI68qlA6h4V3zwR")
                .setOAuthConsumerSecret("M8b4Q3sudgU9mNZgJx1onUlqQYi5h5YCK1GVacjAc8yHDAohFc")
                .setOAuthAccessToken("160922224-AKOoOasbqi3huqT7uyq4Og0Oqlucn8rKeD9IcUvU")
                .setOAuthAccessTokenSecret("7HgIJUmjOX2AZThvVp7RPWsZwOrW1ffpvkEpjeBSQynnH");
        TwitterFactory twitterFactory = new TwitterFactory(config.build());
        return twitterFactory.getInstance();
    }
}
