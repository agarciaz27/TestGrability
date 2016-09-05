package com.eelseth.testgrability.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by eelSeth on 9/3/2016.
 */
public class Feed implements Serializable{

    Author author;
    List<Entry> entry;
    GenericTag updated;
    GenericTag rights;
    GenericTag title;
    GenericTag icon;
    List<GenericTag> link;
    GenericTag id;


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    public GenericTag getUpdated() {
        return updated;
    }

    public void setUpdated(GenericTag updated) {
        this.updated = updated;
    }

    public GenericTag getRights() {
        return rights;
    }

    public void setRights(GenericTag rights) {
        this.rights = rights;
    }

    public GenericTag getTitle() {
        return title;
    }

    public void setTitle(GenericTag title) {
        this.title = title;
    }

    public GenericTag getIcon() {
        return icon;
    }

    public void setIcon(GenericTag icon) {
        this.icon = icon;
    }

    public List<GenericTag> getLink() {
        return link;
    }

    public void setLink(List<GenericTag> link) {
        this.link = link;
    }

    public GenericTag getId() {
        return id;
    }

    public void setId(GenericTag id) {
        this.id = id;
    }

}
