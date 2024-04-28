package com.example.kakao_assignment_clone.dto;

import java.util.ArrayList;

public class SearchImageResult {
    public ArrayList<SearchImageDocument> documents;
    public SearchImageMeta meta;

    public ArrayList<SearchImageDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<SearchImageDocument> documents) {
        this.documents = documents;
    }

    public SearchImageMeta getMeta() {
        return this.meta;
    }

    public void setMeta(SearchImageMeta meta) {
        this.meta = meta;
    }
}
