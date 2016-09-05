package com.eelseth.testgrability.model;

import java.io.Serializable;

/**
 * Created by eelSeth on 9/3/2016.
 */
public class Author implements Serializable {

    GenericTag name;
    GenericTag uri;

    public GenericTag getName() {
        return name;
    }

    public void setName(GenericTag name) {
        this.name = name;
    }

    public GenericTag getUri() {
        return uri;
    }

    public void setUri(GenericTag uri) {
        this.uri = uri;
    }
}
