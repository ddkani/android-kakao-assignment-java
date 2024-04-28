package com.example.kakao_assignment_clone.retrofit;

import com.example.kakao_assignment_clone.dto.SearchImageResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface RetrofitService {

    // https://developers.kakao.com/docs/latest/ko/daum-search/dev-guide#search-image
    @GET("/v2/search/image")
    Call<SearchImageResult> getImageSearch(
        @Header("Authorization") String key,
        @Query("query") String query,
        @Query("sort") String sort,
        @Query("page") int page,
        @Query("size") int size
    );
}
