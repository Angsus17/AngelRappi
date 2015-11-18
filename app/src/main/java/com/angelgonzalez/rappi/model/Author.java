package com.angelgonzalez.rappi.model;

import java.io.Serializable;

/**
 * Created by angel.gonzalez on 10/11/2015.
 */
public class Author implements Serializable {


    private Name name;

    private Uri uri;

    /**
     *
     * @return
     * The name
     */
    public Name getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The uri
     */
    public Uri getUri() {
        return uri;
    }

    /**
     *
     * @param uri
     * The uri
     */
    public void setUri(Uri uri) {
        this.uri = uri;
    }

}
