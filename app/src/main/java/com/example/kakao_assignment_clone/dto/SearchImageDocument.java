package com.example.kakao_assignment_clone.dto;

import com.google.gson.annotations.SerializedName;

public class SearchImageDocument {
    private String collection;
    private String datetime;
    private int width;
    private int height;

    @SerializedName("display_sitename")
    private String displaySiteName;
    @SerializedName("doc_url")
    private String docUrl;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("thumbnail_url")
    private String thumbnailUrl;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getDisplaySiteName() {
        return displaySiteName;
    }

    public void setDisplaySiteName(String displaySiteName) {
        this.displaySiteName = displaySiteName;
    }

    public String getDocUrl() {
        return docUrl;
    }

    public void setDocUrl(String docUrl) {
        this.docUrl = docUrl;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
