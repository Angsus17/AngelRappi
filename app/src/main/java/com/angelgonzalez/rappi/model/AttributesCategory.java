package com.angelgonzalez.rappi.model;

import java.io.Serializable;

/**
 * Created by angel.gonzalez on 10/11/2015.
 */
public class AttributesCategory implements Serializable {

    private String label;

    private String imid;

    private String term;

    private String scheme;

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

    /**
     *
     * @return
     * The imId
     */
    public String getImId() {
        return imid;
    }

    /**
     *
     * @param imid
     * The im:id
     */
    public void setImId(String imid) {
        this.imid = imid;
    }

    /**
     *
     * @return
     * The term
     */
    public String getTerm() {
        return term;
    }

    /**
     *
     * @param term
     * The term
     */
    public void setTerm(String term) {
        this.term = term;
    }

    /**
     *
     * @return
     * The scheme
     */
    public String getScheme() {
        return scheme;
    }

    /**
     *
     * @param scheme
     * The scheme
     */
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

}
