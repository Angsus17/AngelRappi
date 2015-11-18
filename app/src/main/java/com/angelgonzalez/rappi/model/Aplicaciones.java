package com.angelgonzalez.rappi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by angel.gonzalez on 10/11/2015.
 */
public class Aplicaciones implements Serializable {

    private Feed feed;

    /**
     * @return The feed
     */
    public Feed getFeed() {
        return feed;
    }

    /**
     * @param feed The feed
     */
    public void setFeed(Feed feed) {
        this.feed = feed;
    }
}