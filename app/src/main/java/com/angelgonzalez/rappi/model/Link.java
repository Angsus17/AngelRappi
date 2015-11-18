package com.angelgonzalez.rappi.model;

import java.io.Serializable;

/**
 * Created by angel.gonzalez on 10/11/2015.
 */
public class Link implements Serializable {

    private Attributes attributes;

    /**
     *
     * @return
     * The attributes
     */
    public Attributes getAttributes() {
        return attributes;
    }

    /**
     *
     * @param attributes
     * The attributes
     */
    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

}
