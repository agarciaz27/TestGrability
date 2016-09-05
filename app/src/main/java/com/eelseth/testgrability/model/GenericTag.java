package com.eelseth.testgrability.model;

import java.io.Serializable;

/**
 * Created by eelSeth on 9/3/2016.
 */
public class GenericTag implements Serializable {

    String label;
    Attributes attributes;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }
}
