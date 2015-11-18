package com.angelgonzalez.rappi.model;

import java.io.Serializable;

/**
 * Created by angel.gonzalez on 10/11/2015.
 */
public class ImName implements Serializable {


    private String label;

    /**
     *
     * @return
     * The label
     */
    public String getLabel() {
        return label;
    }

    /**
     *
     * @param label
     * The label
     */
    public void setLabel(String label) {
        this.label = label;
    }

}
