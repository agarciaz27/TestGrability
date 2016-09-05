package com.eelseth.testgrability.model;

import java.io.Serializable;

/**
 * Created by eelSeth on 9/3/2016.
 */
public class Content implements Serializable{

    Feed feed;

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }
}
