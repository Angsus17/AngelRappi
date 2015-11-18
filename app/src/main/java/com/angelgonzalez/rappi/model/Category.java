package com.angelgonzalez.rappi.model;

import java.io.Serializable;

/**
 * Created by angel.gonzalez on 10/11/2015.
 */
public class Category implements Serializable {


    private AttributesCategory attributes;

    /**
     *
     * @return
     * The attributes
     */
    public AttributesCategory getAttributes() {
        return attributes;
    }

    /**
     *
     * @param attributes
     * The attributes
     */
    public void setAttributes(AttributesCategory attributes) {
        this.attributes = attributes;
    }

}
