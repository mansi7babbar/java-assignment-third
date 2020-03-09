package com.knoldus;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * TwitterSetup is created to generate a twitter instance.
 */
public class TwitterSetup {
    Twitter getTwitterInstance() throws IOException {
        InputStream input = new FileInputStream("path/to/config.properties");
        Properties prop = new Properties();
        prop.load(input);

        ConfigurationBuilder config = new ConfigurationBuilder();
        config.setDebugEnabled(true)
                .setOAuthConsumerKey(prop.getProperty("consumer.key"))
                .setOAuthConsumerSecret("consumer.secret")
                .setOAuthAccessToken("token.key")
                .setOAuthAccessTokenSecret("token.secret");

        TwitterFactory twitterFactory = new TwitterFactory(config.build());
        return twitterFactory.getInstance();
    }
}
