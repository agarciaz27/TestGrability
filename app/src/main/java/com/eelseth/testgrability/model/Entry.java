package com.eelseth.testgrability.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by eelSeth on 9/3/2016.
 */
public class Entry implements Serializable {

    @SerializedName("im:name")
    GenericTag imName;
    @SerializedName("im:image")
    List<GenericTag> imImage;
    GenericTag summary;
    @SerializedName("im:price")
    GenericTag imPrice;
    @SerializedName("im:contenttype")
    GenericTag imContentType;
    GenericTag rights;
    GenericTag title;
    GenericTag link;
    GenericTag id;
    @SerializedName("im:artist")
    GenericTag imArtist;
    GenericTag category;
    @SerializedName("im:releaseDate")
    GenericTag imReleaseDate;

    public GenericTag getImName() {
        return imName;
    }

    public void setImName(GenericTag imName) {
        this.imName = imName;
    }

    public List<GenericTag> getImImage() {
        return imImage;
    }

    public void setImImage(List<GenericTag> imImage) {
        this.imImage = imImage;
    }

    public GenericTag getSummary() {
        return summary;
    }

    public void setSummary(GenericTag summary) {
        this.summary = summary;
    }

    public GenericTag getImPrice() {
        return imPrice;
    }

    public void setImPrice(GenericTag imPrice) {
        this.imPrice = imPrice;
    }

    public GenericTag getImContentType() {
        return imContentType;
    }

    public void setImContentType(GenericTag imContentType) {
        this.imContentType = imContentType;
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

    public GenericTag getLink() {
        return link;
    }

    public void setLink(GenericTag link) {
        this.link = link;
    }

    public GenericTag getId() {
        return id;
    }

    public void setId(GenericTag id) {
        this.id = id;
    }

    public GenericTag getImArtist() {
        return imArtist;
    }

    public void setImArtist(GenericTag imArtist) {
        this.imArtist = imArtist;
    }

    public GenericTag getCategory() {
        return category;
    }

    public void setCategory(GenericTag category) {
        this.category = category;
    }

    public GenericTag getImReleaseDate() {
        return imReleaseDate;
    }

    public void setImReleaseDate(GenericTag imReleaseDate) {
        this.imReleaseDate = imReleaseDate;
    }
}
