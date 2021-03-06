package com.angelgonzalez.rappi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by angel.gonzalez on 10/11/2015.
 */
public class Feed  implements Serializable {


    private Author author;

    private List<Entry> entry = new ArrayList<>();

    private Updated updated;

    private Rights rights;

    private Title title;

    private Icon icon;

    private List<Link> link = new ArrayList<>();

    private Id id;

    /**
     *
     * @return
     * The author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     * The author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     *
     * @return
     * The entry
     */
    public List<Entry> getEntry() {
        return entry;
    }

    /**
     *
     * @param entry
     * The entry
     */
    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    /**
     *
     * @return
     * The updated
     */
    public Updated getUpdated() {
        return updated;
    }

    /**
     *
     * @param updated
     * The updated
     */
    public void setUpdated(Updated updated) {
        this.updated = updated;
    }

    /**
     *
     * @return
     * The rights
     */
    public Rights getRights() {
        return rights;
    }

    /**
     *
     * @param rights
     * The rights
     */
    public void setRights(Rights rights) {
        this.rights = rights;
    }

    /**
     *
     * @return
     * The title
     */
    public Title getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(Title title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     *
     * @param icon
     * The icon
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /**
     *
     * @return
     * The link
     */
    public List<Link> getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    public void setLink(List<Link> link) {
        this.link = link;
    }

    /**
     *
     * @return
     * The id
     */
    public Id getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Id id) {
        this.id = id;
    }

}
